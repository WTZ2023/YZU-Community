package com.example.yzu_community;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FragTopic extends Fragment {
    private SwipeRefreshLayout swipeRefresh;

    private final Topic[] topics={new Topic("话题1",R.drawable.apple,"热度：1万"),
            new Topic("话题2",R.drawable.apple,"热度：1万"),
            new Topic("话题3",R.drawable.banana,"热度：1万"),
            new Topic("话题4",R.drawable.grape,"热度：1万"),
            new Topic("话题5",R.drawable.watermelon,"热度：1万"),
            new Topic("话题6",R.drawable.cherry,"热度：1万"),
            new Topic("话题7",R.drawable.pear,"热度：1万"),
            new Topic("话题8",R.drawable.pineapple,"热度：1万"),
            new Topic("话题9",R.drawable.banana,"热度：1万"),
            new Topic("话题10",R.drawable.apple,"热度：1万"),
            new Topic("话题11",R.drawable.grape,"热度：1万"),
            new Topic("话题12",R.drawable.cherry,"热度：1万")};
    private final List<Topic> topicList=new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //1.创建View视图
        //2.返回view视图
        View view=inflater.inflate(R.layout.fragment_topic, container, false);
        initTopics();
        RecyclerView topic_rv;
        topic_rv=view.findViewById(R.id.recycler_view_topic);
        TopicAdapter adapter = new TopicAdapter(topicList);
        StaggeredGridLayoutManager manager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        topic_rv.setLayoutManager(manager);
        topic_rv.setAdapter(adapter);
        //下拉刷新功能实现
        swipeRefresh=view.findViewById(R.id.swipe_refresh_topic);
        swipeRefresh.setColorSchemeColors(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initTopics();
                adapter.notifyDataSetChanged();
                swipeRefresh.setRefreshing(false);
            }
        });

        return view;
    }
    private void initTopics(){
        topicList.clear();
        for (int i=0;i<50;i++){
            Random random=new Random();
            int index=random.nextInt(topics.length);
            topicList.add(topics[index]);
        }
    }
}
