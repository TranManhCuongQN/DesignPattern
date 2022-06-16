package com.android.appmusic11.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.appmusic11.Activity.PlayNhacActivity;
import com.android.appmusic11.Model.BaiHatModel;
import com.android.appmusic11.R;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;

public class DanhSachBaiHatAdapter extends RecyclerView.Adapter<DanhSachBaiHatAdapter.ViewHolder> {
    Context context;
    ArrayList<BaiHatModel> arrayBaiHat;

    public DanhSachBaiHatAdapter(Context context, ArrayList<BaiHatModel> arrayBaiHat) {
        this.context = context;
        this.arrayBaiHat = arrayBaiHat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_danh_sach_bai_hat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaiHatModel baiHat = arrayBaiHat.get(position);
        holder.txttenbaihat.setText(baiHat.getTenBaiHat());
        holder.txttencasi.setText(baiHat.getTenCaSi());
        Picasso.get().load(baiHat.getHinhBaiHat()).into(holder.hinhbaihat);
    }

    @Override
    public int getItemCount() {
        return arrayBaiHat.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txttenbaihat, txttencasi;
        ImageView hinhbaihat, tim;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txttenbaihat = itemView.findViewById(R.id.textViewtenbaihat);
            txttencasi = itemView.findViewById(R.id.textViewtencasi);
            hinhbaihat = itemView.findViewById(R.id.imageViewhinhbaihat);
            tim = itemView.findViewById(R.id.imageViewtimdanhsachbaihat);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PlayNhacActivity.class);
                    intent.putExtra("cakhuc", arrayBaiHat.get(getBindingAdapterPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
