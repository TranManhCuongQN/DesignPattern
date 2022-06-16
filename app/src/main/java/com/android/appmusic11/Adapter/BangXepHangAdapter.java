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
import com.android.appmusic11.Model.BangXepHangModel;
import com.android.appmusic11.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BangXepHangAdapter extends RecyclerView.Adapter<BangXepHangAdapter.ViewHolder> {
    Context context;
    ArrayList<BangXepHangModel> arrayBangXepHang;
    View view;

    public BangXepHangAdapter(Context context, ArrayList<BangXepHangModel> arrayBangXepHang) {
        this.context = context;
        this.arrayBangXepHang = arrayBangXepHang;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.dong_bangxephang,parent, false);
        return new BangXepHangAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BangXepHangModel bangXepHang = arrayBangXepHang.get(position);
        holder.txtbangxephang.setText(bangXepHang.getTenBangXepHang());
        Picasso.get(/*context*/).load(bangXepHang.getHinhBangXepHang()).into(holder.imgbangxephang);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DanhSachBaiHatActivity.class);
                intent.putExtra("intentbangxephang",arrayBangXepHang.get(holder.getBindingAdapterPosition()));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayBangXepHang != null ? arrayBangXepHang.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgbangxephang;
        TextView txtbangxephang;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgbangxephang = itemView.findViewById(R.id.imageviewbangxephang);
            txtbangxephang = itemView.findViewById(R.id.textviewbangxephang);
        }
    }
}
