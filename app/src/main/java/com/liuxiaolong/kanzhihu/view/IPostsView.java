package com.liuxiaolong.kanzhihu.view;


import com.liuxiaolong.kanzhihu.model.entity.Post;

import java.util.List;

/**
 * Created by Administrator on 2016/7/21.
 */
public interface IPostsView extends IView {

    /**
     * 显示首页文章数据
     * @param postsList
     */
    void  ShowPostsData(List<Post> postsList);

    /**
     * 更新文章数据
     * @param postsList
     *
     */
    void UpdatePostsData(List<Post> postsList);
}
