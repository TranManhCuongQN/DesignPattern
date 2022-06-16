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
import com.android.appmusic11.Model.PlayListModel;
import com.android.appmusic11.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.ViewHolder>{

    Context context;
    ArrayList<PlayListModel> mangplaylist;
    View view;

    public PlaylistAdapter(Context context, ArrayList<PlayListModel> mangplaylist) {
        this.context = context;
        this.mangplaylist = mangplaylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.dong_playlist,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PlayListModel playlist = mangplaylist.get(position);
        holder.txttenplaylist.setText(playlist.getTenPlayList());
        Picasso.get().load(playlist.getHinhPlayList()).into(holder.imgplaylist);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DanhSachBaiHatActivity.class);
                intent.putExtra("intentplaylist", mangplaylist.get(holder.getBindingAdapterPosition()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mangplaylist != null ? mangplaylist.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgplaylist;
        TextView txttenplaylist;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgplaylist = itemView.findViewById(R.id.imageviewplaylist);
            txttenplaylist = itemView.findViewById(R.id.textviewplaylist);
        }
    }
}
