package com.liuxiaolong.kanzhihu.model.API;

/**
 * Created by Administrator on 2016/7/21.
 */
public class kanzhihu {

    public static final String ZHIHU_URL="http://api.kanzhihu.com/";
    public static final String GETPOSTS=kanzhihu.ZHIHU_URL+"getposts";
    private String publishtime;

    public   void setPublishtime(String publishtime){
       this.publishtime=publishtime;
    }


    private    String UPDATA=kanzhihu.ZHIHU_URL+"getposts/"+publishtime;
    public String getUPDATA(){
        return  UPDATA;
    }
}
