package com.example.yzu_community;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyHomeActivity extends AppCompatActivity {

    private ArrayList<MyListFunc> myFuncList;
    private MyFuncListAdapter myFuncListAdapter;
    private ListView lv_myHomeFunc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_home);
        Toolbar toolbarLogTop=(Toolbar) findViewById(R.id.MyHometoolbar);
        toolbarLogTop.setTitle("");
        setSupportActionBar(toolbarLogTop);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//添加默认的返回图标
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用

        myFuncList = new ArrayList<>();
        lv_myHomeFunc = (ListView) findViewById(R.id.lv_myHomeFunc);
        myFuncListAdapter = new MyFuncListAdapter();
        lv_myHomeFunc.setAdapter(myFuncListAdapter);

        initUiData();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return true;
    }


    protected void initUiData() {
        myFuncList.clear();
        myFuncList.add(new MyListFunc(R.drawable.icon_account, "账号管理"));
        myFuncList.add(new MyListFunc(R.drawable.icon_privacy, "隐私"));
        myFuncList.add(new MyListFunc(R.drawable.icon_nightmode, "夜间模式"));
        myFuncList.add(new MyListFunc(R.drawable.icon_about, "关于"));
        myFuncList.add(new MyListFunc(R.drawable.icon_update, "检查更新"));
        myFuncListAdapter.notifyDataSetChanged();
        setListViewHeightBasedOnChildren(lv_myHomeFunc);
    }

    //自适应高度
    public void setListViewHeightBasedOnChildren(ListView listView) {


        if (myFuncListAdapter == null) {
            return;
        }

        int totalHeight = 0;

        for (int i = 0; i < myFuncListAdapter.getCount()-1; i++) {
            View listItem = myFuncListAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();

        params.height = totalHeight
                + (listView.getDividerHeight() * (myFuncListAdapter.getCount() - 1))+dp2px(this,50);

        ((ViewGroup.MarginLayoutParams) params).setMargins(10, 20, 10, 20);

        listView.setLayoutParams(params);
    }

    //像素转换dp到px
    private int dp2px(Context context, float dpValue){
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round(dpValue * density);
    }

    class MyFuncListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return myFuncList.size();
        }

        @Override
        public Object getItem(int i) {
            return myFuncList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder holder = null;
            if(view == null)
            {
                view = View.inflate(MyHomeActivity.this,R.layout.myhome_func_elem,null);
                holder = new ViewHolder();
                holder.img = view.findViewById(R.id.img_myHomeElemShow);
                holder.des = view.findViewById(R.id.tv_myHomeElemDes);
                view.setTag(holder);
            }
            else
            {
                holder = (ViewHolder) view.getTag();
            }
            holder.img.setBackgroundResource(myFuncList.get(i).getImageId());
            holder.des.setText((myFuncList.get(i).getDescribe()));
            return view;
        }
    }
    static class ViewHolder
    {
        ImageView img;
        TextView des;
    }
}




class MyListFunc {
    private int imageId;        //图片id
    private String describe;    //选项描述

    public MyListFunc(int id, String des)  {
        this.imageId = id;
        this.describe = des;
    }

    public int getImageId() {
        return imageId;
    }

    public String getDescribe() {
        return describe;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}