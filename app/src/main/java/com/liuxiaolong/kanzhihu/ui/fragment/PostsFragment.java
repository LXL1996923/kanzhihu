package com.liuxiaolong.kanzhihu.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liuxiaolong.kanzhihu.R;
import com.liuxiaolong.kanzhihu.model.entity.Posts;
import com.liuxiaolong.kanzhihu.presenter.IPostssenter;
import com.liuxiaolong.kanzhihu.presenter.impl.PostsenterImpl;
import com.liuxiaolong.kanzhihu.ui.adapter.PostsAdapter;
import com.liuxiaolong.kanzhihu.view.IPostsView;

import java.util.List;

import java.util.logging.LogRecord;


public class PostsFragment extends Fragment implements IPostsView{
    public static final int SHOW=1;
    public static  final int HIDE=2;

    private IPostssenter iPostssenter;
    private List<Posts> postsList;
    private RecyclerView recyclerView;
    private PostsAdapter postsAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case SHOW:
                    swipeRefreshLayout.setRefreshing(true);

                    break;
                case HIDE:
                    swipeRefreshLayout.setRefreshing(false);
                    break;
                default:
                    break;


            }
        }
    };






    public PostsFragment() {



       iPostssenter=new PostsenterImpl(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Message msg=new Message();
        msg.what=SHOW;
        handler.sendMessage(msg);
    }


    public static PostsFragment newInstance() {


      return new PostsFragment();


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

           View view=inflater.inflate(R.layout.fragment_kanzhihu,container,false);
        recyclerView=(RecyclerView)view.findViewById(R.id.fragment_kanzhihu);
        swipeRefreshLayout=(SwipeRefreshLayout) view.findViewById(R.id.fragment_srl);
        iPostssenter.loadPostsData();




        setListeners();










        return view;
    }


    @Override
    public void ShowPostsData(List<Posts> postsList,int i) {
        this.postsList=postsList;
        postsAdapter=new PostsAdapter(postsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(postsAdapter);

       Message message=new Message();
        message.what=i;
        handler.sendMessage(message);



    }


    /**
     * SwipeRefreshLayout上拉刷新监听器
     */

    public void setListeners(){









        swipeRefreshLayout.setColorSchemeResources(R.color.blue,R.color.green,R.color.orange);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                iPostssenter.loadPostsData();

            }
        });
    }


    public void loadPostsData(){

    }
}
