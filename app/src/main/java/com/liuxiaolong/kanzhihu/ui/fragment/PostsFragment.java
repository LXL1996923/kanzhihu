package com.liuxiaolong.kanzhihu.ui.fragment;




import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.liuxiaolong.kanzhihu.R;
import com.liuxiaolong.kanzhihu.model.API.kanzhihu;
import com.liuxiaolong.kanzhihu.model.entity.Posts;
import com.liuxiaolong.kanzhihu.presenter.IPostssenter;
import com.liuxiaolong.kanzhihu.presenter.impl.PostsenterImpl;
import com.liuxiaolong.kanzhihu.ui.activity.PostAnswersActivity;
import com.liuxiaolong.kanzhihu.ui.adapter.PostsAdapter;
import com.liuxiaolong.kanzhihu.view.IPostsView;

import java.util.List;




public class PostsFragment extends Fragment implements IPostsView{
    public static final int SHOW=1;
    public static  final int HIDE=2;

    private boolean isLoading;

    private IPostssenter iPostssenter;
    private List<Posts> postsList;
    private RecyclerView recyclerView;
    private PostsAdapter postsAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
     LinearLayoutManager layoutManager;


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
        iPostssenter.loadPostsData(kanzhihu.GETPOSTS);

        initview();















        return view;
    }


    @Override
    public void ShowPostsData(final List<Posts> postsList) {
        this.postsList=postsList;
        postsAdapter=new PostsAdapter(postsList);
        layoutManager=new LinearLayoutManager(recyclerView.getContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(postsAdapter);
        postsAdapter.setOnItemClickListener(new PostsAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent=new Intent(getContext(), PostAnswersActivity.class);
                intent.putExtra("data",postsList.get(position));
                startActivity(intent);

            }
        });
        Message message=new Message();
        message.what=HIDE;
        handler.sendMessage(message);

    }

    @Override
    public void UpdatePostsData(List<Posts> postsList) {
        Log.i("test", "UpdataPostsData: "+true);
        this.postsList.addAll(postsList);
        postsAdapter.notifyDataSetChanged();
        postsAdapter.notifyItemRemoved(postsAdapter.getItemCount());
        isLoading=false;


    }







    public void initview() {
        if(postsAdapter!=null){


        }




            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);






                    int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();


                    Log.d("test", "loading executed" + lastVisibleItemPosition + "itemcount" + postsAdapter.getItemCount());

                    if (lastVisibleItemPosition == postsAdapter.getItemCount() - 1) {







                        if (!isLoading) {
                            isLoading = true;

                            iPostssenter.updatePostsData(postsAdapter.getUpdata());
                            swipeRefreshLayout.setRefreshing(false);


                        }
                    }
                }
            });


            swipeRefreshLayout.setColorSchemeResources(R.color.blue, R.color.green, R.color.orange);
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {


                               iPostssenter.loadPostsData(kanzhihu.GETPOSTS);










                }
            });


    }
}
