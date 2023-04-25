package com.example.yzu_community;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class CreateNewLogActivity extends AppCompatActivity {
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.create_log,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_log);
        Toolbar toolbar_cnl =findViewById(R.id.toolbar_cnl);
        setSupportActionBar(toolbar_cnl);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//添加默认的返回图标
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home){
            finish();
        }

        switch (item.getItemId()){
            case R.id.send:
                Intent intent = new Intent(CreateNewLogActivity.this, LogActivity.class);
                startActivity(intent);
                Toast.makeText(this,"已发送",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return super.onOptionsItemSelected(item);

    }
}