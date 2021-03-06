package com.liuxiaolong.kanzhihu.presenter.impl;


import com.liuxiaolong.kanzhihu.model.IModel;
import com.liuxiaolong.kanzhihu.model.IPostsModel;

import com.liuxiaolong.kanzhihu.model.entity.Post;
import com.liuxiaolong.kanzhihu.model.impl.PostsModelimpl;
import com.liuxiaolong.kanzhihu.presenter.IPostssenter;
import com.liuxiaolong.kanzhihu.view.IPostsView;

import java.util.List;

/**
 *
 * Created by liuxiaolong on 2016/7/21.
 */
public class PostsenterImpl implements IPostssenter {
    private IPostsView iPostsView;
    private IPostsModel iPostsModel;
    public PostsenterImpl(IPostsView iPostsView){
        iPostsModel=new PostsModelimpl();

        this.iPostsView=iPostsView;
    }


    @Override
    public void loadPostsData(String api) {
        iPostsModel.loadPostsData(new IModel.Callback() {
            @Override
            public void onSuccess(Object success) {
                List<Post> postsList= (List<Post>) success;

                iPostsView.ShowPostsData(postsList);
            }

            @Override
            public void onError(Object error) {

            }
        }, api);

    }

    @Override
    public void updatePostsData(String updata) {

        iPostsModel.loadPostsData(new IModel.Callback() {
            @Override
            public void onSuccess(Object success) {
                List<Post> postsList= (List<Post>) success;

                iPostsView.UpdatePostsData(postsList);
            }

            @Override
            public void onError(Object error) {

            }
        }, updata);

    }
}
