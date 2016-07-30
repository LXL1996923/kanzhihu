package com.liuxiaolong.kanzhihu.model.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/21.
 */
public class Posts implements Serializable{
    int id;

    String date;    // 发表日期
    String name;    // 文章名称 (yesterday / recent / archive)
    String pic;     // 抬头图 url
    String publishtime;     // 发表时间戳
    int count;      // 文章包含答案数量
    String excerpt;         // 摘要文字



    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(String publishtime) {
        this.publishtime = publishtime;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Posts{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", pic='" + pic + '\'' +
                ", publishtime='" + publishtime + '\'' +
                ", count=" + count +
                ", excerpt='" + excerpt + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
