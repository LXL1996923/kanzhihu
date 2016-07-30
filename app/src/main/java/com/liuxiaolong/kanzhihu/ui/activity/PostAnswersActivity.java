package com.liuxiaolong.kanzhihu.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;

import android.support.v7.widget.Toolbar;
import android.view.View;

import com.liuxiaolong.kanzhihu.R;
import com.liuxiaolong.kanzhihu.model.entity.Posts;
import com.liuxiaolong.kanzhihu.view.app.SwipeBackActivity;



public class PostAnswersActivity extends SwipeBackActivity {

    private Posts post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_answers);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        post=(Posts)getIntent().getSerializableExtra("data");



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
