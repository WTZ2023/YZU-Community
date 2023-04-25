package com.example.yzu_community;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.ViewHolder> {
    private Context mContext;
    private final List<Topic> mTopicList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView topicImage;
        TextView topicName;
        TextView topicHot;

        public ViewHolder(View view){
            super(view);
            cardView=(CardView) view;
            topicImage= view.findViewById(R.id.topic_image);
            topicName= view.findViewById(R.id.topic_name);
            topicHot= view.findViewById(R.id.topic_hot);
        }
    }
    public TopicAdapter(List<Topic> topicList){
        mTopicList=topicList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.topic_cardview, parent, false);
        final ViewHolder holder=new TopicAdapter.ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Topic lcvs=mTopicList.get(position);
                Intent intent=new Intent(mContext, TopicActivity.class);
                intent.putExtra(TopicActivity.TOPIC_TITLE,lcvs.getName());
                intent.putExtra(TopicActivity.TOPIC_IMAGE,lcvs.getImageId());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        Topic topic=mTopicList.get(position);
        holder.topicName.setText(topic.getName());
        holder.topicHot.setText(topic.getHot());
        Glide.with(mContext).load(topic.getImageId()).into(holder.topicImage);
    }
    @Override
    public int getItemCount(){
        return mTopicList.size();
    }
}
