package com.dongnao.dnplayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dongnao.live.live2.list.TagDetailList;

import java.util.ArrayList;
import java.util.List;

public class TagAdapter extends RecyclerView.Adapter<TagAdapter.MyHolder> implements View
        .OnClickListener{
    private static final String TAG = "TagAdapter";

    private LiveAdapter.OnItemClickListener mItemClickListener;

    private List<TagDetailList.DataBean> mData;
    private LayoutInflater layoutInflater;

    public TagAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        mData = new ArrayList<>();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.tag_item, viewGroup, false);
        //点击
        view.setOnClickListener(this);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        TagDetailList.DataBean bean = mData.get(i);
        myHolder.tv_nickname.setText(bean.getNickname());
        Glide.with(myHolder.picture).load(bean.getRoom_src()).into(myHolder.picture);
        //设置标签
        myHolder.itemView.setTag(bean.getRoom_id());
        myHolder.tv_room_name.setText(bean.getRoom_name());
        myHolder.tv_online.setText(bean.getOnline()+"");
    }

    @Override
    public int getItemCount() {
        return mData == null? 0 : mData.size();
    }

    @Override
    public void onClick(View v) {
        if (mItemClickListener!= null) {
            mItemClickListener.onItemClick((String) v.getTag());
        }

    }

    /**
     * 点击回调
     *
     * @param mItemClickListener
     */
    public void setItemClickListener(LiveAdapter.OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public void setData(List<TagDetailList.DataBean> data) {
        mData.clear();
        mData = data;
    }

    class MyHolder extends RecyclerView.ViewHolder {

        ImageView picture;
        TextView tv_nickname;
        TextView tv_online;
        TextView tv_room_name;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            picture = itemView.findViewById(R.id.picture);
            tv_nickname = itemView.findViewById(R.id.tv_nickname);
            tv_online = itemView.findViewById(R.id.tv_online);
            tv_room_name = itemView.findViewById(R.id.tv_room_name);

        }


    }
}
