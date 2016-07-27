package com.liuxiaolong.kanzhihu.presenter;

import com.liuxiaolong.kanzhihu.model.IPostsModel;

/**
 * Created by Administrator on 2016/7/21.
 */
public interface IPostssenter extends IPresenter {

    /**
     * 加载首页文章列表
     */

    void  loadPostsData(String api);

    /**
     * 更新文章列表
     */
    void updatePostsData(String updata);
}
