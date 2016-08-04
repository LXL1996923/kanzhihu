package com.liuxiaolong.kanzhihu.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.liuxiaolong.kanzhihu.R;

import com.liuxiaolong.kanzhihu.model.entity.Post;


import java.util.List;

/**
 * Created by Administrator on 2016/7/21.
 */
public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder>  implements View.OnClickListener{
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    private String updata;



    private List<Post> postsList;
    private OnRecyclerViewItemClickListener mOnItemClickListener;


    public PostsAdapter(List<Post> postsList) {
        this.postsList = postsList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType==TYPE_ITEM){
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.kanzhihu_item,parent,false);

            view.setOnClickListener(this);
            return new ViewHolder(view);

        }else if(viewType==TYPE_FOOTER){
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.footview,parent,false);
            return new FootViewHolder(view);
        }



        return null;

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

       if (position<postsList.size()){
           Post post=postsList.get(position);
           if(postsList.size()-position==1){
               String publishtime=post.getPublishtime();

               String updata="http://api.kanzhihu.com/getposts/"+publishtime;
               setUpdata(updata);


               Log.i("test", "Publishtime"+publishtime+updata);

           }

           String date=post.getDate();
           switch (post.getName()){
               case "yesterday":
                   holder.tvTitle.setText(date+" 昨日最新");
                   break;
               case "recent":
                   holder.tvTitle.setText(date+" 近日热门");
                   break;
               case "archive":
                   holder.tvTitle.setText(date+" 历史精华");
                   break;
           }



           holder.excerpt.setText(post.getExcerpt());

           Glide.with(holder.ivTitle.getContext())
                   .load(post.getPic())
                   .into(holder.ivTitle);
       }



          holder.itemView.setTag(position);


    }

    @Override
    public int getItemViewType(int position) {
       if(position+1==getItemCount()){
           return TYPE_FOOTER;
       }else{
           return  TYPE_ITEM;
       }
    }

    @Override
    public int getItemCount() {
        return postsList.size()==0?0:postsList.size()+1;
    }



    public String getUpdata() {
        return updata;
    }

    public void setUpdata(String updata) {
        this.updata = updata;
    }



    @Override
    public void onClick(View view) {
       if(mOnItemClickListener!=null){
           mOnItemClickListener.onItemClick(view, (Integer) view.getTag());
       }
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
    public static class FootViewHolder extends ViewHolder {

        public FootViewHolder(View view) {
            super(view);
        }
    }


    public  interface OnRecyclerViewItemClickListener {
        void onItemClick(View view , int position);
    }
    public void setOnItemClickListener(OnRecyclerViewItemClickListener onRecyclerViewItemClickListener){
               this.mOnItemClickListener=onRecyclerViewItemClickListener;
    }
}
