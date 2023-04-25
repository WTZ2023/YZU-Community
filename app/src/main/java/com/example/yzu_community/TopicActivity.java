package com.example.yzu_community;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.Objects;

public class TopicActivity extends AppCompatActivity {
    public static final String TOPIC_TITLE ="topic_title";
    public static final String TOPIC_IMAGE ="topic_image_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        Intent intent=getIntent();
        String topicTitle=intent.getStringExtra(TOPIC_TITLE);
        int topicImageId=intent.getIntExtra(TOPIC_IMAGE,0);
        ImageView topicImage=findViewById(R.id.topic_head);
        TextView topic_Title=findViewById(R.id.topic_tittle);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button topic_star= findViewById(R.id.topic_star);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Toolbar toolbar_topic=findViewById(R.id.toolbar_topic);
        setSupportActionBar(toolbar_topic);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);//添加默认的返回图标
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        Glide.with(this).load(topicImageId).into(topicImage);
        topic_Title.setText(topicTitle);

        topic_star.setOnClickListener(view -> Toast.makeText(TopicActivity.this, "已收藏此话题", Toast.LENGTH_SHORT).show());

    }
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return true;
    }
}
