package com.easyapp.fansbeabuty;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.easyapp.baseproject.lib.recycleView.BaseRecyclerViewAdapter;
import com.easyapp.facebook.module.FacebookTool;
import com.easyapp.facebook.module.entities.Feed;
import com.facebook.GraphResponse;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by easyapp_jim on 2016/6/3.
 */
public class FragmentFans extends BaseRecyclerFragment {
    //    final String fb_id = "mdjulie";
//    final String fb_id = "ck101beauty";
    final String fb_id = "1752722608332654";
    FacebookTool facebookTool;

    @Override
    protected void init() {
        facebookTool = new FacebookTool();
    }


    @Override
    protected int setGridLayoutSpanCount() {
        return 1;
    }

    private void getFansPage() {
        Bundle bundle = new Bundle();
        bundle.putString("fields", "picture,full_picture,from,actions,message,link,created_time,updated_time,comments,likes");
        facebookTool.getFeed(fb_id, bundle, new FacebookTool.Callback() {
            //        facebookTool.getFeed(fb_id, new FacebookTool.Callback() {
            @Override
            public void complete(GraphResponse graphResponse, JSONObject jsonObject) {
                Logger.d(jsonObject.toString());
                Gson gson = new Gson();
                Feed feed = gson.fromJson(jsonObject.toString(), Feed.class);
                setData(feed.getData());
            }

            @Override
            public void fail() {
                Logger.d("fail");
            }
        });
    }


    @Override
    public void onRefresh() {
        getFansPage();

    }

    @Override
    protected void onLoadMore() {

    }

    @Override
    protected int getRecycleViewHolderLayout() {
        return R.layout.item_fans;
    }

    @Override
    protected int getRecycleViewHolderHeaderLayout() {
        return getRecycleViewHolderLayout();
    }

    @Override
    protected BaseRecyclerViewAdapter.ItemHolder getItemHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    protected BaseRecyclerViewAdapter.ItemHolder getHeaderItemHolder(View view) {
        return getItemHolder(view);
    }

    @Override
    protected void getBindViewHolder(RecyclerView.ViewHolder viewHolder, Object o) {
        ViewHolder holder = (ViewHolder) viewHolder;
        Feed.DataBean bean = (Feed.DataBean) o;

        if (bean.getMessage() != null) {
            holder.tvMessage.setText(bean.getMessage());
        }
        if (bean.getFull_picture() != null) {
            Glide.with(getContext()).load(bean.getFull_picture()).placeholder(R.drawable.img_empty340).error(R.drawable.img_empty340).into(holder.ivPicture);
        }
    }

    @Override
    protected void getBindHeaderViewHolder(RecyclerView.ViewHolder viewHolder, Object o) {
        getBindViewHolder(viewHolder, o);

    }

    static class ViewHolder extends BaseRecyclerViewAdapter.ItemHolder {
        @BindView(R.id.iv_picture)
        ImageView ivPicture;

        @BindView(R.id.tv_message)
        TextView tvMessage;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
