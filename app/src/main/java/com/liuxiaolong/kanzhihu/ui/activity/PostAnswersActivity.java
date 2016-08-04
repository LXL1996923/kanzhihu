package com.liuxiaolong.kanzhihu.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;


import com.liuxiaolong.kanzhihu.R;
import com.liuxiaolong.kanzhihu.model.entity.Post;
import com.liuxiaolong.kanzhihu.view.app.SwipeBackActivity;



public class PostAnswersActivity extends SwipeBackActivity {

    private Post post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_answers);




        post=(Post)getIntent().getSerializableExtra("data");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        String s=null;
        switch (post.getName()){
            case "yesterday":
               s="昨日最新";
                break;
            case "recent":
                s= "近日热门";
                break;
            case "archive":
               s="历史精华";
                break;
        }

        toolbar.setTitle(post.getDate()+" "+s);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Log.i("answer", "onCreate: "+post.toString());





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
