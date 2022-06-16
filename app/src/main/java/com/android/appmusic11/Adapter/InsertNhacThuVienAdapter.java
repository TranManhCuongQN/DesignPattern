package com.android.appmusic11.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.android.appmusic11.Activity.TrangChuActivity;
import com.android.appmusic11.Database.DatabaseHelper;
import com.android.appmusic11.Model.BaiHatModel;
import com.android.appmusic11.Model.BaiHatThuVienPlayListModel;
import com.android.appmusic11.Model.NgheSiModel;
import com.android.appmusic11.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;



public class InsertNhacThuVienAdapter extends RecyclerView.Adapter<InsertNhacThuVienAdapter.ViewHolder>{
    Context context;
    ArrayList<BaiHatModel> mangbaihat;
    ArrayList<BaiHatThuVienPlayListModel> arrayBaiHatThuVienPlayList;
    int idthuvien;
    private DatabaseHelper databaseHelper = DatabaseHelper.getInstance(context);

    public InsertNhacThuVienAdapter(Context context, ArrayList<BaiHatModel> mangbaihat, int idthuvien) {
        this.context = context;
        this.mangbaihat = mangbaihat;
        this.idthuvien = idthuvien;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.dong_tim_kiem_nhac_thuvien, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaiHatModel baiHat = mangbaihat.get(holder.getBindingAdapterPosition());
        holder.tenbaihat.setText(baiHat.getTenBaiHat());
        holder.temcasi.setText(baiHat.getTenCaSi());
        Picasso.get(/*context*/).load(baiHat.getHinhBaiHat()).into(holder.imgtimkiem);
        holder.imginsertnhac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertDataBaiHatThuVien(idthuvien, baiHat.getMaBaiHat(), baiHat.getTenBaiHat(),baiHat.getTenCaSi(),
                        baiHat.getHinhBaiHat(), baiHat.getLinkBaiHat());
                UpdateHinhThuVien(idthuvien, mangbaihat.get(position).getHinhBaiHat());
                Log.d("ManhCuong","Ten Bai Hat:"+baiHat.getTenBaiHat());
            }
        });

    }
    public void InsertDataBaiHatThuVien(int idtv, int idbh, String tbh, String tcs, String hbh, String lbh) {
        arrayBaiHatThuVienPlayList = new ArrayList<>();
        Cursor dataBaiHatThuVien= databaseHelper.getData("SELECT * FROM BaiHatThuVienPlayList WHERE TenBaiHat='"+tbh+"' AND MaThuVienPlayList='"+idtv+"'");
        arrayBaiHatThuVienPlayList.clear();
        while (dataBaiHatThuVien.moveToNext()) {
             int MaBaiHatThuVien = dataBaiHatThuVien.getInt(0);
             int MaThuVien = dataBaiHatThuVien.getInt(1);
             int MaBaiHat = dataBaiHatThuVien.getInt(2);
             String TenBaiHat = dataBaiHatThuVien.getString(3);
             String HinhBaiHat = dataBaiHatThuVien.getString(4);
             String TenCaSi = dataBaiHatThuVien.getString(5);
             String LinkBaiHat = dataBaiHatThuVien.getString(6);
             arrayBaiHatThuVienPlayList.add(new BaiHatThuVienPlayListModel(MaBaiHatThuVien,MaThuVien,MaBaiHat,TenBaiHat,HinhBaiHat,TenCaSi,LinkBaiHat));
        }
        Log.d("ManhCuong","arrayThuVien:"+arrayBaiHatThuVienPlayList.size());
        if(arrayBaiHatThuVienPlayList.size() > 0){
            Toast.makeText(context,"Bài hát đã được thêm vào",Toast.LENGTH_SHORT).show();
        }
        else {
            databaseHelper.QueryData("INSERT INTO BaiHatThuVienPlayList VALUES (null,'" + idtv + "','" + idbh + "','" + tbh + "','" + hbh + "','" + tcs + "','" + lbh + "')");
            Toast.makeText(context, "Đã thêm bài hát thành công", Toast.LENGTH_SHORT).show();
        }
    }
    public void UpdateHinhThuVien(int idtv, String hbh) {
       databaseHelper.QueryData("UPDATE ThuVienPlayList SET HinhThuVienPlayList='"+hbh+"' WHERE MaThuVienPlayList = '"+idtv+"'");
//        Toast.makeText(context,"Update hình thành công",Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getItemCount() {
        return mangbaihat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tenbaihat, temcasi;
        ImageView imgtimkiem, imginsertnhac;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tenbaihat = itemView.findViewById(R.id.txttennhacthuvien);
            temcasi = itemView.findViewById(R.id.txtcasinhacthuvien);
            imgtimkiem = itemView.findViewById(R.id.imgnhacthuvien);
            imginsertnhac = itemView.findViewById(R.id.imginsertnhacthuvien);

        }
    }
}
