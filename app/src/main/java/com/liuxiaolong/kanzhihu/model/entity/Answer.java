package com.liuxiaolong.kanzhihu.model.entity;

/**
 * Created by Administrator on 2016/8/2.
 */
public class Answer {
    String title; //文章id
    String time;  //发表时间
    String summary;  //答案摘要
    String questionid;  //问题id，8位数字
    String answerid;  //答案id，8~9位数字
    String authorname;  //答主名称
    String authorhash;  //答主hash
    String avatar;  //答主头像url
    String vote;//赞同票数

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAuthorhash() {
        return authorhash;
    }

    public void setAuthorhash(String authorhash) {
        this.authorhash = authorhash;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public String getAnswerid() {
        return answerid;
    }

    public void setAnswerid(String answerid) {
        this.answerid = answerid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getQuestionid() {
        return questionid;
    }

    public void setQuestionid(String questionid) {
        this.questionid = questionid;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
