package com.android.appmusic11.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.appmusic11.Activity.DanhSachBaiHatActivity;
import com.android.appmusic11.Model.NgheSiModel;
import com.android.appmusic11.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NgheSiAdapter extends RecyclerView.Adapter<NgheSiAdapter.ViewHolder>{
    Context context;
    ArrayList<NgheSiModel> arrayNgheSi;
    View view;

    public NgheSiAdapter(Context context, ArrayList<NgheSiModel> arrayNgheSi) {
        this.context = context;
        this.arrayNgheSi = arrayNgheSi;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.dong_nghesi,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NgheSiModel ngheSi = arrayNgheSi.get(position);
        holder.txttennghesi.setText(ngheSi.getTenNgheSi());
        String url = ngheSi.getHinhNgheSi();
        Picasso.get()
                .load(url)
                .into(holder.imgnghesi);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DanhSachBaiHatActivity.class);
                intent.putExtra("intentnghesi",arrayNgheSi.get(holder.getBindingAdapterPosition()));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayNgheSi != null ? arrayNgheSi.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        de.hdodenhof.circleimageview.CircleImageView imgnghesi;
        TextView txttennghesi;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgnghesi = itemView.findViewById(R.id.imageviewnghesi);
            txttennghesi = itemView.findViewById(R.id.textviewnghesi);
        }
    }
}
