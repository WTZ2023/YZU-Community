package com.example.yzu_community;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class FragRecommend extends Fragment {
    private SwipeRefreshLayout swipeRefresh;

    private final ListCardView[] lcv={new ListCardView("标题测试1",R.drawable.apple,"张小米","2023/01/01"),
            new ListCardView("标题测试1",R.drawable.apple,"张小米","2023/01/01"),
            new ListCardView("标题测试2",R.drawable.banana,"张小米","2023/01/01"),
            new ListCardView("标题测试3",R.drawable.watermelon,"张小米","2023/01/01"),
            new ListCardView("标题测试4",R.drawable.grape,"张小米","2023/01/01"),
            new ListCardView("标题测试5",R.drawable.pear,"张小米","2023/01/01"),
            new ListCardView("标题测试6",R.drawable.cherry,"张小米","2023/01/01"),
            new ListCardView("标题测试7",R.drawable.apple,"张小米","2023/01/01"),
            new ListCardView("标题测试8",R.drawable.banana,"张小米","2023/01/01"),
            new ListCardView("标题测试9",R.drawable.watermelon,"张小米","2023/01/01"),
            new ListCardView("标题测试10",R.drawable.grape,"张小米","2023/01/01"),};
    private final List<ListCardView> cardViewList=new ArrayList<>();


    @SuppressLint("ResourceAsColor")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //1.创建View视图
        //2.返回view视图
        View view=inflater.inflate(R.layout.fragment_recommend, container, false);
        initCards();
        RecyclerView recommend_rv;
        recommend_rv=view.findViewById(R.id.recycler_view);
        CardAdapter adapter = new CardAdapter(cardViewList);
        StaggeredGridLayoutManager manager=new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        recommend_rv.setLayoutManager(manager);
        recommend_rv.setAdapter(adapter);

        //下拉刷新功能实现
        swipeRefresh=view.findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeColors(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initCards();
                adapter.notifyDataSetChanged();
                swipeRefresh.setRefreshing(false);
            }
        });

        return view;
    }
    private void initCards(){
        cardViewList.clear();
        for (int i=0;i<50;i++){
            Random random=new Random();
            int index=random.nextInt(lcv.length);
            cardViewList.add(lcv[index]);
        }
    }
}