package com.example.yzu_community;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    private Context mContext;
    private final List<ListCardView> mCardList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView listImage;
        TextView listTittle;
        TextView listAuthor;
        TextView listDate;

        public ViewHolder(View view){
            super(view);
            cardView=(CardView) view;
            listImage= view.findViewById(R.id.list_image);
            listTittle= view.findViewById(R.id.list_tittle);
            listAuthor= view.findViewById(R.id.list_author);
            listDate=view.findViewById(R.id.list_date);
        }
    }
    public CardAdapter(List<ListCardView> CardList){mCardList= CardList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_cardview, parent, false);
        final ViewHolder holder=new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                ListCardView lcvs=mCardList.get(position);
                Intent intent=new Intent(mContext, LogActivity.class);
                intent.putExtra(LogActivity.LOG_TITLE,lcvs.getTittle());
                intent.putExtra(LogActivity.LOG_IMAGE,lcvs.getImageId());
                intent.putExtra(LogActivity.LOG_AUTHOR,lcvs.getAuthor());
                intent.putExtra(LogActivity.LOG_DATE,lcvs.getDate());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        ListCardView card=mCardList.get(position);
        holder.listTittle.setText(card.getTittle());
        holder.listAuthor.setText(card.getAuthor());
        holder.listDate.setText(card.getDate());
        Glide.with(mContext).load(card.getImageId()).into(holder.listImage);
    }
    @Override
    public int getItemCount(){
        return mCardList.size();
    }
}

