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
import com.android.appmusic11.Model.ChuDeModel;
import com.android.appmusic11.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ChuDeAdapter extends RecyclerView.Adapter<ChuDeAdapter.ViewHolder> {
    Context context;
    ArrayList<ChuDeModel> arrayChuDe;
    View view;

    public ChuDeAdapter(Context context, ArrayList<ChuDeModel> arrayChuDe) {
        this.context = context;
        this.arrayChuDe = arrayChuDe;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.dong_chude,parent, false);
        return new ChuDeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChuDeModel chuDe = arrayChuDe.get(position);
        holder.txttenchude.setText(chuDe.getTenChuDe());
        Picasso.get(/*context*/).load(chuDe.getHinhChuDe()).into(holder.imgchude);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DanhSachBaiHatActivity.class);
                intent.putExtra("intentchude", arrayChuDe.get(holder.getBindingAdapterPosition()));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayChuDe != null ? arrayChuDe.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgchude;
        TextView txttenchude;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgchude = itemView.findViewById(R.id.imageviewchude);
            txttenchude = itemView.findViewById(R.id.textviewchude);
        }
    }
}
