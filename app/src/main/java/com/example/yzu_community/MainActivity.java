package com.example.yzu_community;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private FragRecommend fragRecommend;
    private FragHot fragHot;
    private FragTopic fragTopic;
    private FragDeal fragDeal;
    private FragUseful fragUseful;
    private FragActivity fragActivity;
    //适配器
    private MyAdapter adapter;
    private List<Fragment> fragments;           //fragment集合
    private List<String> titles;                //tab标题集合


    @SuppressLint("NonConstantResourceId")
    BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.home:  //主页事件
                Toast.makeText(MainActivity.this, "欢迎回来", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.add:
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setIcon(R.drawable.round_add_circle_black_24dp)
                        .setTitle("选择你想创建的内容").setMessage("选择一项，开始分享你的生活吧！")
                        .setPositiveButton("创建一个新话题", (dialogInterface, i) -> {
                            Intent intent = new Intent(MainActivity.this,CreateNewTopicActivity.class);
                            startActivity(intent);
                        })
                        .setNegativeButton("创建一条新动态", (dialogInterface, i) -> {
                            Intent intent = new Intent(MainActivity.this, CreateNewLogActivity.class);
                            startActivity(intent);
                        })
                        .setNeutralButton("发布活动",(dialogInterface,i) -> {

                        })
                        .create().show();
                return true;
            case R.id.my: {  //我的事件
                Toast.makeText(MainActivity.this, "查看关于你的信息", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, MyHomeActivity.class));
                return true;
            }
        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TabLayout tabLayout=findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewpager);
        SearchView searchView = findViewById(R.id.searchbar);

        //TabLayout+ViewPager的联动效果的实现
        fragRecommend=new FragRecommend();
        fragHot=new FragHot();
        fragTopic=new FragTopic();
        fragDeal=new FragDeal();
        fragUseful=new FragUseful();
        fragActivity=new FragActivity();
        //1.构造Fragment列表并传入数据
        List<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(fragRecommend);
        fragments.add(fragHot);
        fragments.add(fragTopic);
        fragments.add(fragDeal);
        fragments.add(fragUseful);
        fragments.add(fragActivity);
        titles = new ArrayList<>();
        titles.add("推荐");
        titles.add("热门");
        titles.add("话题");
        titles.add("交易");
        titles.add("干货");
        titles.add("活动");
        //3.构造Fragment适配器
        adapter = new MyAdapter(getSupportFragmentManager(),fragments,titles);
        //4.创建ViewPager实例，并绑定适配器
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        BottomNavigationView bnv = findViewById(R.id.bottomNavigationView);
        bnv.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }


}