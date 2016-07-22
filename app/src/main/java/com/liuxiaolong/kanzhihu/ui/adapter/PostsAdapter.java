package com.liuxiaolong.kanzhihu.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.liuxiaolong.kanzhihu.R;
import com.liuxiaolong.kanzhihu.model.entity.Posts;

import java.util.List;

/**
 * Created by Administrator on 2016/7/21.
 */
public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> implements View.OnClickListener {

    private List<Posts> postsList;
    private View.OnClickListener onClickListener;

    public PostsAdapter(List<Posts> postsList) {
        this.postsList = postsList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.kanzhihu_item,parent,false);



        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Posts posts=postsList.get(position);
        holder.excerpt.setText(posts.getExcerpt());
        holder.tvTitle.setText(posts.getName());
        Glide.with(holder.ivTitle.getContext())
                .load(posts.getPic())
                .into(holder.ivTitle);



    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    @Override
    public void onClick(View view) {


    }


    public static  class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle;
        public ImageView ivTitle;
        public TextView  excerpt;


        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle=(TextView)itemView.findViewById(R.id.tv_title);
            ivTitle=(ImageView) itemView.findViewById(R.id.iv_title);
            excerpt=(TextView)itemView.findViewById(R.id.excerpt);
        }
    }
}
