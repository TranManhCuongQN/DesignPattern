package com.android.appmusic11.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.appmusic11.Activity.PlayNhacActivity;
import com.android.appmusic11.Activity.TrangChuActivity;
import com.android.appmusic11.Database.DatabaseHelper;
import com.android.appmusic11.Model.BaiHatModel;
import com.android.appmusic11.Model.BaiHatThuVienPlayListModel;
import com.android.appmusic11.Model.NgheSiModel;
import com.android.appmusic11.R;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;



public class dsbhthuvienplaylistAdapter extends RecyclerView.Adapter<dsbhthuvienplaylistAdapter.ViewHolder>{

    Context context;
    ArrayList<BaiHatThuVienPlayListModel> mangbaihatthuvienplaylist;
    View view;
    private DatabaseHelper databaseHelper = DatabaseHelper.getInstance(context);

    public dsbhthuvienplaylistAdapter(Context context, ArrayList<BaiHatThuVienPlayListModel> mangbaihatthuvienplaylist) {
        this.context = context;
        this.mangbaihatthuvienplaylist = mangbaihatthuvienplaylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.dong_danh_sach_bai_hat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaiHatThuVienPlayListModel baiHatThuVienPlayList = mangbaihatthuvienplaylist.get(position);
        holder.txttenbaihat.setText(baiHatThuVienPlayList.getTenBaiHat());
        holder.txttencasi.setText(baiHatThuVienPlayList.getTenCaSi());
        Picasso.get(/*context*/).load(baiHatThuVienPlayList.getHinhBaiHat()).into(holder.hinhbaihat);

        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(context)
                        .setTitle("Xóa bài hát")
                        .setMessage("Bạn có muốn xóa bài hát "+baiHatThuVienPlayList.getTenBaiHat()+" ?")
                        .setPositiveButton("Xóa", null)
                        .setNegativeButton("Hủy", null)
                        .show();

                Button pos = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                Button neg = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
                pos.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       deletemotbaihatthuvien(baiHatThuVienPlayList.getMaBaiHatThuVienPlayList());
                        mangbaihatthuvienplaylist.remove(position);
                        if (mangbaihatthuvienplaylist.size() <= 0){
                            UpdateHinhThuVien(baiHatThuVienPlayList.getMaThuVienPlayList(), "https://kenh14cdn.com/thumb_w/660/203336854389633024/2021/12/8/d04735780ac715fd325abffee4627f11-16389696872851695463984.jpg");
                        }else {
                            if (position == mangbaihatthuvienplaylist.size()){
                                UpdateHinhThuVien(baiHatThuVienPlayList.getMaThuVienPlayList(), mangbaihatthuvienplaylist.get(mangbaihatthuvienplaylist.size()-1).getHinhBaiHat());
                            }
                        }
                        alertDialog.dismiss();
                    }
                });
                neg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                return false;
            }
        });
    }

    private void deletemotbaihatthuvien(int idbaihatthuvien) {
        databaseHelper.QueryData("DELETE FROM BaiHatThuVienPlayList WHERE MaBaiHatThuVienPlayList = '"+idbaihatthuvien+"' ");
        Toast.makeText(context,"Đã xoá thành công",Toast.LENGTH_SHORT).show();
    }

    public void UpdateHinhThuVien(int idtv, String hbh) {
        databaseHelper.QueryData("UPDATE BaiHatThuVienPlayList SET HinhBaiHat = '"+hbh+"' Where MaThuVienPlayList = '"+idtv+"'");
         Toast.makeText(context,"Update hình thành công",Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getItemCount() {
        return mangbaihatthuvienplaylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
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
                   intent.putExtra("cakhucthuvien", mangbaihatthuvienplaylist.get(getBindingAdapterPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
