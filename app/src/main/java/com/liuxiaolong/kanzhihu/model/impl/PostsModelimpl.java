package com.liuxiaolong.kanzhihu.model.impl;

import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.liuxiaolong.kanzhihu.App;

import com.liuxiaolong.kanzhihu.model.IPostsModel;
import com.liuxiaolong.kanzhihu.model.entity.Post;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/21.
 */
public class PostsModelimpl implements IPostsModel {
    private RequestQueue mQueue;

    public PostsModelimpl(){
        mQueue= Volley.newRequestQueue(App.getContext());

    }
    @Override
    public void loadPostsData(final Callback callback,String api) {
        StringRequest stringRequest=new StringRequest(api, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj=new JSONObject(response);
                    int count =obj.getInt("count");
                    JSONArray array=obj.getJSONArray("posts");
                    Gson gson=new Gson();
                    List<Post> postslist=new ArrayList<>();

                    for (int i = 0; i <count ; i++) {
                        Post post;
                        post=gson.fromJson(array.getString(i),Post.class);
                        postslist.add(post);
                        Log.i("test", "onResponse: "+post.toString());
                    }
                    callback.onSuccess(postslist);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error", "response:"+error.getMessage());
            }
        });
        mQueue.add(stringRequest);
    }
}
