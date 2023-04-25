package com.example.yzu_community;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Objects;

public class HuoDongDetailsActivity extends AppCompatActivity {
    public static final String HUODONG_NAME="huodong_name";
    public static final String HUODONG_IMAGE_ID="huodong_image_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huo_dong_details);
        Intent intent=getIntent();
        String huodongName=intent.getStringExtra(HUODONG_NAME);
        int huodongImage=intent.getIntExtra(HUODONG_IMAGE_ID,0);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Toolbar toolbar =findViewById(R.id.toolbar_huodongDetail);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);//添加默认的返回图标
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        ImageView huodongImageView=findViewById(R.id.iv_huodongDetail);
        TextView huodongTextView=findViewById(R.id.tv_huodongDetailTitle);
        Glide.with(this).load(huodongImage).into(huodongImageView);
        huodongTextView.setText(huodongName);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}