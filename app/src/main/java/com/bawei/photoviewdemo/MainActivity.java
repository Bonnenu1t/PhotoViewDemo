package com.bawei.photoviewdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends FragmentActivity {

    private ViewPager viewPager;
    private TextView tv_indicator;
    private ArrayList<String> urlList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String [] urls={"http://img.taopic.com/uploads/allimg/140326/235113-1403260U22059.jpg",
                "http://pic.qiantucdn.com/01/61/38/93bOOOPIC15.jpg",
                "http://img2.3lian.com/img2007/19/51/025.jpg",
                "http://pic16.nipic.com/20110818/7866121_102948241120_2.jpg",
                "http://scimg.jb51.net/allimg/150415/14-15041511223U18.jpg",
                "http://pic.qiantucdn.com/58pic/12/82/31/97C58PIC2fk.jpg",
                "http://pic39.nipic.com/20140312/18085061_092729513131_2.jpg",};//需要加载的网络图片

        urlList = new ArrayList<>();
        Collections.addAll(urlList, urls);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tv_indicator = (TextView) findViewById(R.id.tv_indicator);

        viewPager.setAdapter(new PictureSlidePagerAdapter(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                tv_indicator.setText(String.valueOf(position+1)+"/"+urlList.size());//<span style="white-space: pre;">在当前页面滑动至其他页面后，获取position值</span>
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    private  class PictureSlidePagerAdapter extends FragmentStatePagerAdapter {

        public PictureSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PictureSlideFragment.newInstance(urlList.get(position));//<span style="white-space: pre;">返回展示不同网络图片的PictureSlideFragment</span>
        }

        @Override
        public int getCount() {
            return urlList.size();//<span style="white-space: pre;">指定ViewPager的总页数</span>
        }
    }
}
