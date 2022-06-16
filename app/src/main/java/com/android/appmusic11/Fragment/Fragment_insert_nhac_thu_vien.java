package com.android.appmusic11.Fragment;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.appmusic11.Activity.InsertNhacThuVienActivity;
import com.android.appmusic11.Activity.TrangChuActivity;
import com.android.appmusic11.Adapter.InsertNhacThuVienAdapter;
import com.android.appmusic11.Database.DatabaseHelper;
import com.android.appmusic11.Model.BaiHatModel;
import com.android.appmusic11.R;

import java.util.ArrayList;
import java.util.List;



public class Fragment_insert_nhac_thu_vien extends Fragment {
    View view;
    androidx.appcompat.widget.Toolbar toolbar;
    RecyclerView recyclerViewtim;
    TextView textViewnull;
    InsertNhacThuVienAdapter nhacThuVienAdapter;
    ArrayList<BaiHatModel> mangbaihat;
    InsertNhacThuVienActivity intvA;
    Context context;
    private DatabaseHelper databaseHelper = DatabaseHelper.getInstance(context);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_insert_nhac_thu_vien, container, false);
        toolbar = view.findViewById(R.id.toilbartimkiemthuvien);
        recyclerViewtim = view.findViewById(R.id.recyclerviewtimkiemthuvien);
        textViewnull = view.findViewById(R.id.textviewtimkiemnullthuvien);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((AppCompatActivity)getActivity()).finish();
            }
        });
        setHasOptionsMenu(true);
        return  view;
    }
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {

        inflater.inflate(R.menu.menu_timkiem, menu);
        MenuItem menuItem = menu.findItem(R.id.menutimkiem);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                recyclerViewtim.setBackgroundColor(Color.BLACK);
                if (!s.trim().equals("")){
                 TimKiemBaiHat(s);
                }
                return true;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }
    private void TimKiemBaiHat(String query){
        intvA = (InsertNhacThuVienActivity) getActivity();
        mangbaihat = new ArrayList<>();
        Cursor dataBaiHat = databaseHelper.getData("SELECT * FROM BaiHat WHERE TenBaiHat LIKE'%"+query+"%' OR TenCaSi LIKE'%"+query+"%'");
        mangbaihat.clear();
        while (dataBaiHat.moveToNext()) {
            int MaBaiHat = dataBaiHat.getInt(0);
            String TenBaiHat = dataBaiHat.getString(1);
            String HinhBaiHat = dataBaiHat.getString(2);
            String TenNgheSi = dataBaiHat.getString(3);
            String LinkBaiHat = dataBaiHat.getString(4);
            mangbaihat.add(new BaiHatModel(MaBaiHat,TenBaiHat,HinhBaiHat,TenNgheSi,LinkBaiHat));
        }
                if (mangbaihat.size() > 0){
                    nhacThuVienAdapter = new InsertNhacThuVienAdapter(getActivity(), mangbaihat, intvA.getId());
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    recyclerViewtim.setLayoutManager(linearLayoutManager);
                    recyclerViewtim.setAdapter(nhacThuVienAdapter);
                    textViewnull.setVisibility(View.GONE);
                    recyclerViewtim.setVisibility(View.VISIBLE);
                }else {
                    recyclerViewtim.setVisibility(View.GONE);
                    textViewnull.setVisibility(View.VISIBLE);
                }
            }
    }
