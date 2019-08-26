package com.dongnao.dnplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.dongnao.live.live2.Live2Manager;
import com.dongnao.live.live2.list.ColumnDetailList;
import com.dongnao.live.live2.list.ParentList;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

public class MainActivity extends RxAppCompatActivity implements TabLayout
        .BaseOnTabSelectedListener, LiveAdapter.OnItemClickListener {

    private static final String TAG = "MainActivity";

    private TabLayout tabLayout;
    private RecyclerView recyclerView;
    private LiveAdapter liveAdapter;

    private List<ParentList.DataBean> mParentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        // 配置recycleview
        recyclerView = findViewById(R.id.recycleView);
        LinearLayoutManager layoutManager = new GridLayoutManager(this,4);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        liveAdapter = new LiveAdapter(this);
        liveAdapter.setItemClickListener(this);
        recyclerView.setAdapter(liveAdapter);

        //配置tab
        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addOnTabSelectedListener(this);
        addTab("-1", "分类");
        addTab("-2", "推荐");
        //添加标签
        addTabs();
    }

    private void addTabs() {
        // 获取父频道
        Live2Manager.getInstance()
                .getColumnList()
                .compose(this.<ParentList>bindUntilEvent(ActivityEvent.DESTROY))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSubscriber<ParentList>() {

                    @Override
                    public void onNext(ParentList list) {
                        mParentList = list.getData();
                        List<ParentList.DataBean> data = mParentList;
                        if (data.size() > 0) {
                            ParentList.DataBean bean;
                            for (int i = 0; i < data.size(); i++) {
                                bean = data.get(i);
                                addTab(bean.getShort_name(), bean.getCate_name());
                            }
                        }
                        Log.d(TAG, "getColumnList onNext");
                    }

                    @Override
                    public void onError(Throwable t) {
                        t.printStackTrace();
                        Log.e(TAG, t.getMessage());
                        //Intent intent = new Intent(MainActivity.this, PlayActivity.class);

                        //intent.putExtra("url", "http://223.110.245.170/PLTV/3/224/3221225530/index.m3u8");
                        // startActivity(intent);
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "getColumnList onComplete");
                    }
                });
    }

    private void addTab(String tag, String title) {
        TabLayout.Tab tab = tabLayout.newTab();
        tab.setTag(tag);
        tab.setText(title);
        tabLayout.addTab(tab);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        tabLayout.removeOnTabSelectedListener(this);
    }

    /**
     * 切换标签回调
     *
     * @param tab
     */
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        // 请求获取房间
        onSelected(tab);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onItemClick(String id) {
        Intent intent = new Intent(this,DetailActivity.class);
        intent.putExtra("tag_id",id);
        startActivity(intent);
    }

    public void onSelected(TabLayout.Tab tab) {
        String tabStr = (String) tab.getTag();
        switch (tabStr) {
            case "-1":
                break;
            case "-2":
                break;
            default:
                Live2Manager.getInstance()
                        .getColumnDetail(tabStr)
                        .compose(this.<ColumnDetailList>bindUntilEvent(ActivityEvent.DESTROY))
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new DisposableSubscriber<ColumnDetailList>() {

                            @Override
                            public void onNext(ColumnDetailList list) {
                                liveAdapter.setLiveList(list);
                                liveAdapter.notifyDataSetChanged();
                                Log.d(TAG, "onNext");
                            }

                            @Override
                            public void onError(Throwable t) {
                                t.printStackTrace();
                                Log.e(TAG, t.getMessage());
                            }

                            @Override
                            public void onComplete() {
                                Log.e(TAG, "onComplete");
                            }
                        });
                break;
        }

    }
}
