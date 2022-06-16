package com.android.appmusic11.Fragment;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.android.appmusic11.Activity.TrangChuActivity;
import com.android.appmusic11.Adapter.YeuThichAdapter;
import com.android.appmusic11.Database.DatabaseHelper;
import com.android.appmusic11.Model.BaiHatYeuThichModel;
import com.android.appmusic11.Model.NgheSiModel;
import com.android.appmusic11.R;
import java.util.ArrayList;
import java.util.List;

public class Fragment_ThuVien_YeuThich extends Fragment {
    View view;
    private YeuThichAdapter yeuThichAdapter;
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    ArrayList<BaiHatYeuThichModel> arrayBaiHatYeuThich;
    Context context;
    private DatabaseHelper databaseHelper = DatabaseHelper.getInstance(context);
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_thuvien_yeuthich, container, false);
        recyclerView = view.findViewById(R.id.recyclerviewyeuthich);
        GetData();
        swipeRefreshLayout = view.findViewById(R.id.swipeyeuthich);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                GetData();
                yeuThichAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        return view;
    }
    public void GetData() {
        arrayBaiHatYeuThich = new ArrayList<>();
        arrayBaiHatYeuThich.clear();
        Cursor cursor = databaseHelper.getData("SELECT * FROM BaiHatYeuThich");
        while (cursor.moveToNext()) {
            int MaYeuThich = cursor.getInt(0);
            int MaBaiHat = cursor.getInt(1);
            String TenBaiHat = cursor.getString(2);
            String HinhBaiHat = cursor.getString(3);
            String TenCaSi = cursor.getString(4);
            String LinkBaiHat = cursor.getString(5);
            arrayBaiHatYeuThich.add(new BaiHatYeuThichModel(MaYeuThich,MaBaiHat,TenBaiHat,HinhBaiHat,TenCaSi,LinkBaiHat));
        }
                yeuThichAdapter = new YeuThichAdapter(getActivity(),arrayBaiHatYeuThich );
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(yeuThichAdapter);
            }
    }
