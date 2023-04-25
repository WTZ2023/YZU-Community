package com.example.yzu_community;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomappbar.BottomAppBar;

public class LogActivity extends AppCompatActivity {

    public static final String LOG_TITLE ="log_title";
    public static final String LOG_IMAGE ="log_image_id";
    public static final String LOG_AUTHOR ="log_author";
    public static final String LOG_DATE ="log_date";

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.log_top_menu,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        Intent intent=getIntent();
        String logTitle=intent.getStringExtra(LOG_TITLE);
        String logAuthor=intent.getStringExtra(LOG_AUTHOR);
        String logDate=intent.getStringExtra(LOG_DATE);
        int logImageId=intent.getIntExtra(LOG_IMAGE,0);
        Toolbar toolbar_log=(Toolbar) findViewById(R.id.toolbar_log);
        TextView log_title=findViewById(R.id.log_title);
        ImageView log_picture=findViewById(R.id.log_image);
        TextView log_author=findViewById(R.id.user_name);
        TextView log_date=findViewById(R.id.time);
        TextView logContentText=findViewById(R.id.log_content_text);
        Button like =(Button)findViewById(R.id.like);
        Button star =(Button)findViewById(R.id.star);
        Button comment=(Button)findViewById(R.id.comment);
        setSupportActionBar(toolbar_log);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//添加默认的返回图标
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        Glide.with(this).load(logImageId).into(log_picture);
        String logContent=generateLogContent(logTitle);
        log_title.setText(logTitle);
        logContentText.setText(logContent);
        log_author.setText(logAuthor);
        log_date.setText(logDate);

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LogActivity.this, "已点赞",Toast.LENGTH_SHORT).show();
            }
        });
        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LogActivity.this, "已收藏",Toast.LENGTH_SHORT).show();
            }
        });
        comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LogActivity.this, "点击评论",Toast.LENGTH_SHORT).show();
            }
        });

    }
    private String generateLogContent(String logTitle){
        StringBuilder logContent=new StringBuilder();
        for (int i=0;i<500;i++){
            logContent.append(logTitle);
        }
        return logContent.toString();
    }
//点击分享按钮出现分享弹窗
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home){
            finish();
        }

        switch (item.getItemId()){
            case R.id.share:
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setIcon(R.drawable.baseline_ios_share_black_36dp)
                        .setTitle("分享").setMessage("将该动态分享到：")
                        .setPositiveButton("分享到QQ", (dialogInterface, i) -> {
                            Toast.makeText(this,"已分享到QQ",Toast.LENGTH_SHORT).show();
                        })
                        .setNegativeButton("分享到微信", (dialogInterface, i) -> {
                            Toast.makeText(this,"已分享到微信",Toast.LENGTH_SHORT).show();
                        })
                        .create().show();
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }

}