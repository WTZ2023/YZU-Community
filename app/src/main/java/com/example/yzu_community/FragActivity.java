package com.example.yzu_community;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

public class FragActivity extends Fragment{

    private HuoDongListAdapter  huoDongListAdapter;
    private List<HuodongListInfo> mData;
    private RecyclerView recyclerView;

    private SwipeRefreshLayout swipeRefresh;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //1.创建View视图
        //2.返回view视图
        View view = inflater.inflate(R.layout.fragment_activity, container, false);
        initActivityPage(view);
        return view;
    }
    @SuppressLint("ResourceAsColor")
    private void initActivityPage(View view) {
        recyclerView = view.findViewById(R.id.recycler_view_activity);
        mData = new ArrayList<>();
        for(int i = 0; i < 50; i++) {
            if(i % 3 == 0) {
                mData.add(new HuodongListInfo(R.drawable.apple, HuodongListInfo.StatusCode.Preparing, "蓝桥杯软件赛"));
            }else if (i % 4 == 0) {
                mData.add(new HuodongListInfo(R.drawable.pic_huodongtest, HuodongListInfo.StatusCode.Registering, "新生杯蓝球赛"));
            }else if (i % 5 == 0) {
                mData.add(new HuodongListInfo(R.drawable.banana, HuodongListInfo.StatusCode.EndRegistration, "计算机设计大赛"));
            }else if (i % 7 == 0) {
                mData.add(new HuodongListInfo(R.drawable.cherry, HuodongListInfo.StatusCode.Ended, "计科12000班团会"));
            }else {
                mData.add(new HuodongListInfo(R.drawable.grape, HuodongListInfo.StatusCode.Doing, "计科学院升旗仪式"));
            }
        }

        huoDongListAdapter = new HuoDongListAdapter(mData);
        recyclerView.setAdapter(huoDongListAdapter);


        StaggeredGridLayoutManager manager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //下拉刷新功能实现
        swipeRefresh=view.findViewById(R.id.swipe_refresh_activity);
        swipeRefresh.setColorSchemeColors(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefresh.setRefreshing(false);
            }
        });
    }
}
