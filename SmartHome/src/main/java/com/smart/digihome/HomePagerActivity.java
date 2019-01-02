package com.smart.digihome;

import android.os.Bundle;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


import adapter.SampleFragmentPagerAdapter;

public class HomePagerActivity extends AppCompatActivity{


    ViewPager viewPager;
    PagerTabStrip pagerSlidingTabStrip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager_home);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new SampleFragmentPagerAdapter(getSupportFragmentManager()));

        //pagerSlidingTabStrip = findViewById(R.id.tabs);
        //pagerSlidingTabStrip.setV

    }
}
