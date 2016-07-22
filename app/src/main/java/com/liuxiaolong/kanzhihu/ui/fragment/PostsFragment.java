package com.liuxiaolong.kanzhihu.ui.fragment;

import android.os.Bundle;
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


public class PostsFragment extends Fragment implements IPostsView{
    private IPostssenter iPostssenter;
    private List<Posts> postsList;
    private RecyclerView recyclerView;
    private PostsAdapter postsAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;






    public PostsFragment() {
       iPostssenter=new PostsenterImpl(this);
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
    public void ShowPostsData(List<Posts> postsList) {
        this.postsList=postsList;
        postsAdapter=new PostsAdapter(postsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(postsAdapter);

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
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}
