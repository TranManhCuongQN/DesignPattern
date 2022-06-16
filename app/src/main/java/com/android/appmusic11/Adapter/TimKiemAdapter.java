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

import java.util.ArrayList;

public class TimKiemAdapter extends RecyclerView.Adapter<TimKiemAdapter.ViewHolder> {
    Context context;
    ArrayList<BaiHatModel> arrayBaiHat;

    public TimKiemAdapter(Context context, ArrayList<BaiHatModel> arrayBaiHat) {
        this.context = context;
        this.arrayBaiHat = arrayBaiHat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.dong_tim_kiem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaiHatModel baiHat = arrayBaiHat.get(position);
        holder.txttentimkiem.setText(baiHat.getTenBaiHat());
        holder.txtcasitimkiem.setText(baiHat.getTenCaSi());
        Picasso.get().load(baiHat.getHinhBaiHat()).into(holder.imganhtimkiem);
    }

    @Override
    public int getItemCount() {
        return arrayBaiHat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txttentimkiem, txtcasitimkiem;
        ImageView imganhtimkiem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txttentimkiem = itemView.findViewById(R.id.txttennhac);
            txtcasitimkiem = itemView.findViewById(R.id.txtcasinhac);
            imganhtimkiem = itemView.findViewById(R.id.imgnhac);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PlayNhacActivity.class);
                    intent.putExtra("cakhuc", (Parcelable) arrayBaiHat.get(getBindingAdapterPosition()));
                    context.startActivity(intent);
                }
            });

        }
    }
}
