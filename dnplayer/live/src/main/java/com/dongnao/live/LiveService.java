package com.dongnao.live;

import com.dongnao.live.list.LiveList;
import com.dongnao.live.live2.list.ColumnDetailList;
import com.dongnao.live.live2.list.LiveList2;
import com.dongnao.live.live2.list.ParentList;
import com.dongnao.live.live2.list.TagDetailList;
import com.dongnao.live.room.Room;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author Lance
 * @date 2018/9/7
 */
public interface LiveService {

    @GET("ajax_get_live_list_by_cate")
    Flowable<LiveList> getLiveList(@Query("cate") String cate, @Query("pageno") int pageno, @Query
            ("pagenum") int pagenum, @Query("version") String version);

    @GET("ajax_get_liveroom_baseinfo")
    Flowable<Room> getLiveRoom(@Query("roomid") String roomid, @Query("__version") String
            __version, @Query("slaveflag") int slaveflag, @Query("type") String type, @Query
                                       ("__plat") String __plat);

    // 获取当前所有频道
    @GET("api/v1/live")
    Flowable<LiveList2> getCurAllLives(@Query("limit") int limit, @Query("offset") int offset);

    // 获取父频道
    @GET("api/v1/getColumnList")
    Flowable<ParentList> getColumnList();

    /**
     * 获取子频道
     */
    @GET("api/v1/getColumnDetail")
    Flowable<ColumnDetailList> getColumnDetail(@Query("shortName") String shortName);

    @GET("api/v1/live/{tag_id}")
    Flowable<TagDetailList> getTagDetail(@Path("tag_id") String tag_id, @Query("limit") int limit, @Query("offset") int offset);
}
