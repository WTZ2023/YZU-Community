package com.example.yzu_community;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class HuoDongListAdapter extends RecyclerView.Adapter<MyViewHolder>{
    private LayoutInflater inflater;
    private Context mContext;
    private List<HuodongListInfo> mDatas;

    //创建构造参数
    public HuoDongListAdapter(List<HuodongListInfo> datas){
        this.mDatas = datas;
    }

    //创建ViewHolder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.huodong_item, parent, false);
        final MyViewHolder holder=new MyViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Intent intent=new Intent(mContext, HuoDongDetailsActivity.class);
                HuodongListInfo HLI=mDatas.get(position);
                intent.putExtra(HuoDongDetailsActivity.HUODONG_NAME,HLI.getTitle());
                intent.putExtra(HuoDongDetailsActivity.HUODONG_IMAGE_ID,HLI.getImgId());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    //绑定ViewHolder
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //为textview 赋值
        holder.relativeLayout.setBackgroundResource(mDatas.get(position).getImgId());
        holder.tv_status.setText(mDatas.get(position).getStatus());
        holder.tv_status.setBackgroundColor(mDatas.get(position).getstatusColor());
        holder.tv_title.setText(mDatas.get(position).getTitle());
    }


    @Override
    public int getItemCount() {
        //Log.i("TAG", "mDatas "+mDatas);

        return mDatas.size();

    }

    //新增item
    public void addData(int pos){
        mDatas.add(new HuodongListInfo(R.drawable.grape, HuodongListInfo.StatusCode.Preparing, "测试添加"));
        notifyItemInserted(pos);
    }

    //移除item
    public void deleteData(int pos){
        mDatas.remove(pos);
        notifyItemRemoved(pos);
    }
}
class MyViewHolder extends RecyclerView.ViewHolder{
    CardView cardView;
    RelativeLayout relativeLayout;
    TextView tv_title;
    TextView tv_status;
    public MyViewHolder(View itemView) {
        super(itemView);
        cardView=(CardView) itemView;
        relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relaLayout_huodongListItemBack);
        tv_title = (TextView)itemView.findViewById(R.id.tv_huodongListItemTitle);
        tv_status = (TextView)itemView.findViewById(R.id.tv_huodongListItemStatus);
    }
}