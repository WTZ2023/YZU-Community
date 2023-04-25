package com.example.yzu_community;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class CreateNewTopicActivity extends AppCompatActivity {
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.create_topic,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_topic);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Toolbar toolbar_cnt =findViewById(R.id.toolbar_cnt);
        setSupportActionBar(toolbar_cnt);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//添加默认的返回图标
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home){
            finish();
        }

        switch (item.getItemId()){
            case R.id.create:
                Intent intent = new Intent(CreateNewTopicActivity.this, TopicActivity.class);
                startActivity(intent);
                Toast.makeText(this,"已创建",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return super.onOptionsItemSelected(item);

    }
}