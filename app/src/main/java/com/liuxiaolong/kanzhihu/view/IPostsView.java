package com.liuxiaolong.kanzhihu.view;

import com.liuxiaolong.kanzhihu.model.entity.Posts;

import java.util.List;

/**
 * Created by Administrator on 2016/7/21.
 */
public interface IPostsView extends IView {

    /**
     * 显示首页文章数据
     * @param postsList
     */
    void  ShowPostsData(List<Posts> postsList);

    /**
     * 更新文章数据
     * @param postsList
     *
     */
    void UpdataPostsData(List<Posts> postsList);
}
