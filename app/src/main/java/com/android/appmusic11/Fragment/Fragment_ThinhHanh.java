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
import com.android.appmusic11.Adapter.PlaylistAdapter;
import com.android.appmusic11.Adapter.ThinhHanhAdapter;
import com.android.appmusic11.Database.DatabaseHelper;
import com.android.appmusic11.Model.PlayListModel;
import com.android.appmusic11.Model.ThinhHanhModel;
import com.android.appmusic11.R;

import java.util.ArrayList;


public class Fragment_ThinhHanh extends Fragment {

    View view;
    ThinhHanhAdapter thinhHanhAdapter;
    RecyclerView recyclerViewthinhhanh;
    TextView tenThinhHanh;
    ArrayList<ThinhHanhModel> arrayThinhHanh;
    Context context;
    private DatabaseHelper databaseHelper = DatabaseHelper.getInstance(context);
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_thinhhanh, container, false);
        recyclerViewthinhhanh = view.findViewById(R.id.recyclerviewthinhhanh);
        tenThinhHanh = view.findViewById(R.id.txtthinhhanh);
         GetData();
        return view;
    }

    private void GetData() {
        arrayThinhHanh = new ArrayList<>();
        Cursor dataThinhHanh= databaseHelper.getData("SELECT * FROM ThinhHanh");
        arrayThinhHanh.clear();
        while (dataThinhHanh.moveToNext()) {
            String MaThinhHanh = dataThinhHanh.getString(0);
            String TenThinhHanh = dataThinhHanh.getString(1);
            String HinhThinhHanh = dataThinhHanh.getString(2);
            arrayThinhHanh.add(new ThinhHanhModel(MaThinhHanh, TenThinhHanh, HinhThinhHanh));
        }
              thinhHanhAdapter = new ThinhHanhAdapter(getActivity(),arrayThinhHanh);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewthinhhanh.setLayoutManager(linearLayoutManager);
                recyclerViewthinhhanh.setAdapter(thinhHanhAdapter);
                dataThinhHanh.close();
            }


}
