package com.example.foodpoint;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class adapter1 extends RecyclerView.Adapter<adapter1.adapter1ViewHolder> {


    List<modal1> list;

    public adapter1(List<modal1> list) {
        this.list=list;
    }


    @NonNull
    @Override
    public adapter1ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list1,parent,false);
        return new adapter1ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter1ViewHolder holder, int position) {

        holder.image.setImageResource(list.get(position).getImage());
        holder.text.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static final class adapter1ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView text;

        public adapter1ViewHolder(@NonNull View itemView) {
            super(itemView);

            image=itemView.findViewById(R.id.list1_img);
            text=itemView.findViewById(R.id.list1_text);

        }
    }
}
