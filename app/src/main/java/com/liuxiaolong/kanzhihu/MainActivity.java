package com.liuxiaolong.kanzhihu;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.liuxiaolong.kanzhihu.ui.adapter.PostsViewPagerAdapter;
import com.liuxiaolong.kanzhihu.ui.fragment.Gank;
import com.liuxiaolong.kanzhihu.ui.fragment.PostsFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.homeTL)
    Toolbar homeTL;
    @BindView(R.id.homeTabs)
    TabLayout homeTabs;
    @BindView(R.id.homeVP)
    ViewPager homeVP;
    @BindView(R.id.homeNV)
    NavigationView homeNV;
    @BindView(R.id.homeDL)
    DrawerLayout homeDL;

    private PostsViewPagerAdapter postsViewPagerAdapter;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initview();


        setupViewPager(homeVP);
        homeTabs.setupWithViewPager(homeVP);
        homeTabs.setTabMode(TabLayout.MODE_FIXED);

    }


    private void setupViewPager(ViewPager viewPager) {
        PostsViewPagerAdapter postsViewPagerAdapter = new PostsViewPagerAdapter(getSupportFragmentManager());
        postsViewPagerAdapter.addFragment(PostsFragment.newInstance(), "知乎精选");
        postsViewPagerAdapter.addFragment(Gank.newInstance(), "Gank");
        viewPager.setAdapter(postsViewPagerAdapter);
    }

    public void initview() {



        setSupportActionBar(homeTL);
        homeTL.setNavigationIcon(R.drawable.ic_menu);
        homeTL.setTitle("看知乎");
        homeTL.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeDL.openDrawer(GravityCompat.START);

            }
        });

    }
}
