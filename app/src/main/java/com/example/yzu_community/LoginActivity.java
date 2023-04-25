package com.example.yzu_community;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void land(View view){//这里的land对应登陆按钮里的onclick，按钮按下便会调用此函数
        EditText account=findViewById(R.id.account);//获取id为account的EditText输入值
        EditText password=findViewById(R.id.password);//获取id为password的EditText输入值
        String got_account=account.getText().toString();//将得到的值转为字符串
        String got_password=password.getText().toString();
        SQLiteOpenHelper helper=MySqliteOpenHelper.getmInstance(this);
        SQLiteDatabase db=helper.getReadableDatabase();//登陆用到的是读操作，这里用写操作也不会有问题
        if (db.isOpen()){//判断数据库是否成功打开
            Cursor cursor=db.rawQuery("select * from users",null);//取users数据表中所有用户数据，cursor是迭代游标，用于遍历操作
            while (cursor.moveToNext()){//遍历所有用户数据
                @SuppressLint("Range") String _account=cursor.getString(cursor.getColumnIndex("_account"));//获取每一个用户的账号
                @SuppressLint("Range") String _password=cursor.getString(cursor.getColumnIndex("_password"));//获取每一个用户的密码
                if (Objects.equals(_account,got_account)&&Objects.equals(_password, got_password)){//判断此次遍历到的用户账号和密码是否和用户输入的账号和密码相同
                    Log.e("land success",_account);
                    Intent ma2 = new Intent(LoginActivity.this, MainActivity.class);//跳转至登陆成功的界面，MainActivity是当前界面的java文件名，MainActivity2是要跳转的界面对应的java文件
                    startActivity(ma2);
                }
            }
            cursor.close();//关闭迭代游标
            db.close();//关闭数据库
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        }
    }
    public void login(View view){//对应注册按钮
        EditText account=findViewById(R.id.account);
        EditText password=findViewById(R.id.password);
        String got_account=account.getText().toString();
        String got_password=password.getText().toString();
        SQLiteOpenHelper helper=MySqliteOpenHelper.getmInstance(this);
        SQLiteDatabase db=helper.getWritableDatabase();
        if (db.isOpen()){
            String sql="insert into users(_account,_password) values(?,?)";//因为注册账号和密码需要获取用户输入的信息，所以我们暂时用问号代替，下面再用Object替代
            db.execSQL(sql,new Object[]{got_account,got_password});
            Log.e("login success",got_account);
        }
        db.close();
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
    }
}