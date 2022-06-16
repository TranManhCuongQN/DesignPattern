package com.android.appmusic11.Fragment;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.android.appmusic11.Activity.TrangChuActivity;
import com.android.appmusic11.Adapter.BangXepHangAdapter;
import com.android.appmusic11.Database.DatabaseHelper;
import com.android.appmusic11.Model.BangXepHangModel;
import com.android.appmusic11.Model.NgheSiModel;
import com.android.appmusic11.R;

import java.util.ArrayList;
import java.util.List;



public class Fragment_BangXepHang extends Fragment {
    View view;
    BangXepHangAdapter bangXepHangAdapter;
    RecyclerView recyclerViewbangxephang;
    TextView tenbangxephang;
    ArrayList<BangXepHangModel> arrayBangXepHang;
    Context context;
    private DatabaseHelper databaseHelper = DatabaseHelper.getInstance(context);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bangxephang, container, false);
        recyclerViewbangxephang = view.findViewById(R.id.recyclerviewbangxephang);
        tenbangxephang = view.findViewById(R.id.txtbangxephang);
        GetData();
        return view;
    }

    private void GetData() {
        arrayBangXepHang = new ArrayList<>();
        Cursor dataBangXepHang= databaseHelper.getData("SELECT * FROM BangXepHang");
        arrayBangXepHang.clear();
        while (dataBangXepHang.moveToNext()) {
                 String MaBangXepHang =dataBangXepHang.getString(0);
                 String TenBangXepHang = dataBangXepHang.getString(1);
                 String HinhBangXepHang = dataBangXepHang.getString(2);
                 arrayBangXepHang.add(new BangXepHangModel(MaBangXepHang,TenBangXepHang,HinhBangXepHang));
              }
               bangXepHangAdapter = new BangXepHangAdapter(getActivity(),arrayBangXepHang);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewbangxephang.setLayoutManager(linearLayoutManager);
                recyclerViewbangxephang.setAdapter(bangXepHangAdapter);
            }
    }
