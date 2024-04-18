package com.example.foodpoint;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class adapter2 extends RecyclerView.Adapter<adapter2.ViewHolder> {
    Context mContext;
    ArrayList<modal2> mList;

    public adapter2(Context context,ArrayList<modal2>list){
        this.mContext=context;
        this.mList=list;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View v=LayoutInflater.from(mContext).inflate(R.layout.list2,parent,false);
         return  new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull  ViewHolder holder, int position) {
        final modal2 temp=mList.get(position);
        holder.txt1.setText(mList.get(position).getName());
        holder.txt2.setText(mList.get(position).getRating());
        holder.txt3.setText(mList.get(position).getPrice());
        holder.txt4.setText(mList.get(position).getUnique());
        Glide.with(mContext).load(mList.get(position).getImage()).into(holder.imgUrl);

        holder.imgUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(mContext,Bhojnalaya.class);
                in.putExtra("name",temp.getName());
                mContext.startActivity(in);
            }
        });
    }
    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgUrl;
        TextView txt1,txt2,txt3,txt4;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgUrl=itemView.findViewById(R.id.list2_img);
            txt1=itemView.findViewById(R.id.list2_txt1);
            txt2=itemView.findViewById(R.id.list2_txt2);
            txt3=itemView.findViewById(R.id.list2_txt3);
            txt4=itemView.findViewById(R.id.list2_txt4);
        }


    }
}
