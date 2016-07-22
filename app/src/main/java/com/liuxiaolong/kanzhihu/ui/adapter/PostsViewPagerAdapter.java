package com.liuxiaolong.kanzhihu.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/21.
 */
public class PostsViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> fragments=new ArrayList<>();
    private final List<String> strings=new ArrayList<>();
    public PostsViewPagerAdapter(FragmentManager fm) {

        super(fm);

    }
    public void addFragment(Fragment fragment,String s){
        fragments.add(fragment);
        strings.add(s);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strings.get(position);
    }
}
