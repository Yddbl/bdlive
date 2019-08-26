package com.dongnao.dnplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.dongnao.live.live2.Live2Manager;
import com.dongnao.live.live2.list.TagDetailList;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * 对用分类的所有直播
 */
public class DetailActivity extends RxAppCompatActivity implements LiveAdapter.OnItemClickListener {

    private static final String TAG = "DetailActivity";
    private RecyclerView recyclerView;

    private String tag_id;
    private int limit = 20;
    private int offset = 0;

    private TagAdapter mAdapter;
    private SwipeRefreshLayout refreshLayout;
    // 上拉刷新
    private final static int UP_LOAD_TYPE = 1;
    // 下拉加载
    private final static int DOWN_LOAD_TYPE = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
        }
        tag_id = intent.getStringExtra("tag_id");
        Log.d(TAG,tag_id);
        recyclerView = findViewById(R.id.recycleView);
        refreshLayout = findViewById(R.id.swiperefreshlayout);
        mAdapter = new TagAdapter(this);
        LinearLayoutManager layoutManager = new GridLayoutManager(this,2);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new HomeDecoration(this,20,R.color.tag));
        mAdapter.setItemClickListener(this);
        recyclerView.setAdapter(mAdapter);

        //下拉刷新的圆圈是否显示
        refreshLayout.setRefreshing(false);

        //设置下拉时圆圈的颜色（可以由多种颜色拼成）
        refreshLayout.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light,
                android.R.color.holo_orange_light);

        //设置下拉时圆圈的背景颜色（这里设置成白色）
        refreshLayout.setProgressBackgroundColorSchemeResource(android.R.color.white);

        //设置下拉刷新时的操作
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // 具体操作
                getDetails(0,DOWN_LOAD_TYPE);
            }
        });
        getDetails(0,DOWN_LOAD_TYPE);

    }

    private void getDetails(int offset,int type) {
        Live2Manager.getInstance()
                .getTagDetail(tag_id,limit,offset)
                .compose(this.<TagDetailList>bindUntilEvent(ActivityEvent.DESTROY))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSubscriber<TagDetailList>() {

                    @Override
                    public void onNext(TagDetailList list) {
                        mAdapter.setData(list.getData());
                        mAdapter.notifyDataSetChanged();
                        Log.d(TAG, "onNext");
                    }

                    @Override
                    public void onError(Throwable t) {
                        t.printStackTrace();
                        Log.e(TAG, t.getMessage());
                        refreshLayout.setRefreshing(false);
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete");
                        refreshLayout.setRefreshing(false);
                    }
                });
    }


    @Override
    public void onItemClick(String id) {
        Log.d(TAG,id);
    }
}
