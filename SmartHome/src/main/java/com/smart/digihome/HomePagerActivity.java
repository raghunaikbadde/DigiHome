package com.smart.digihome;

import android.os.Bundle;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;


import java.util.ArrayList;

import Constants.Constants;
import adapter.CustomExpandableListAdapter;
import adapter.SampleFragmentPagerAdapter;
import database.AppDataBase;
import pojo.ElectricFan;
import pojo.ElectricLight;
import pojo.Room;
import pojo.SixModularSwitchBoard;
import pojo.Switch;

public class HomePagerActivity extends AppCompatActivity{


    ViewPager viewPager;
    PagerTabStrip pagerSlidingTabStrip;
    Room hallRoom;
    DigiHomeApp instance;
    AppDataBase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager_home);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new SampleFragmentPagerAdapter(getSupportFragmentManager()));

        //pagerSlidingTabStrip = findViewById(R.id.tabs);
        //pagerSlidingTabStrip.setV

//        prepareDummyList();

    }


}
