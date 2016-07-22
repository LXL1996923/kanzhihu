package com.liuxiaolong.kanzhihu.model;

/**
 * Created by Administrator on 2016/7/21.
 */
public interface IModel {
     interface Callback{
         void onSuccess(Object success);

         void onError(Object error);

     }

}
