package com.dongnao.live.live2;

import com.dongnao.live.LiveService;
import com.dongnao.live.live2.list.ColumnDetailList;
import com.dongnao.live.live2.list.LiveList2;
import com.dongnao.live.live2.list.ParentList;
import com.dongnao.live.live2.list.TagDetailList;
import com.google.gson.Gson;

import java.io.IOException;

import io.reactivex.Flowable;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Lance
 * @date 2018/9/7
 */
public class Live2Manager {

    private final LiveService liveService;
    private static Live2Manager instance;


    private Live2Manager() {
        OkHttpClient callFactory = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response response = chain.proceed(chain.request());
                LiveList2 liveList = new Gson().fromJson(response.body().string(), LiveList2.class);
                return response;
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://capi.douyucdn.cn/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        liveService = retrofit.create(LiveService.class);
    }

    public static Live2Manager getInstance() {
        if (null == instance) {
            synchronized (LiveService.class) {
                if (null == instance) {
                    instance = new Live2Manager();
                }
            }
        }
        return instance;
    }

    // 获取当前全部直播
    public Flowable<LiveList2> getCurAllLives(int limit,int offset) {
        return liveService.getCurAllLives(limit,offset);
    }

    // 获取父频道
    public Flowable<ParentList> getColumnList() {
        return liveService.getColumnList();
    }

    // 获取子频道
    public Flowable<ColumnDetailList> getColumnDetail(String shortName) {
        return liveService.getColumnDetail(shortName);
    }

    public Flowable<TagDetailList> getTagDetail(String tagId,int limit,int offset) {
        return liveService.getTagDetail(tagId,limit,offset);
    }
}
