package com.android.appmusic11.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.appmusic11.Activity.DanhSachBaiHatActivity;
import com.android.appmusic11.Model.ThinhHanhModel;
import com.android.appmusic11.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ThinhHanhAdapter extends RecyclerView.Adapter<ThinhHanhAdapter.ViewHolder> {
    Context context;
    ArrayList<ThinhHanhModel> arrayThinhHanh;
    View view;

    public ThinhHanhAdapter(Context context, ArrayList<ThinhHanhModel> arrayThinhHanh) {
        this.context = context;
        this.arrayThinhHanh = arrayThinhHanh;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.dong_thinhhanh,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ThinhHanhModel thinhHanh = arrayThinhHanh.get(position);
        holder.txttenthinhhanh.setText(thinhHanh.getTenThinhHanh());
        String url = thinhHanh.getHinhThinhHanh();
        Picasso.get()
                .load(url)
                .into(holder.imgpthinhhanh);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DanhSachBaiHatActivity.class);
                intent.putExtra("intentthinhhanh",arrayThinhHanh.get(holder.getBindingAdapterPosition()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayThinhHanh != null ? arrayThinhHanh.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgpthinhhanh;
        TextView txttenthinhhanh;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgpthinhhanh = itemView.findViewById(R.id.imageviewthinhhanh);
            txttenthinhhanh = itemView.findViewById(R.id.textviewthinhhanh);
        }
    }
}
