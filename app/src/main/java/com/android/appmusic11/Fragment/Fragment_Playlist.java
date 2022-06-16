package com.android.appmusic11.Fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
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
import com.android.appmusic11.Adapter.PlaylistAdapter;
import com.android.appmusic11.Database.DatabaseHelper;
import com.android.appmusic11.Model.BangXepHangModel;
import com.android.appmusic11.Model.PlayListModel;
import com.android.appmusic11.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;


public class Fragment_Playlist extends Fragment {
    View view;
    PlaylistAdapter playlistAdapter;
    RecyclerView recyclerViewplaylist;
    TextView tenPlaylist;
    ArrayList<PlayListModel> arrayPlayList;
    Context context;
    private DatabaseHelper databaseHelper = DatabaseHelper.getInstance(context);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_playlist, container, false);
        recyclerViewplaylist = view.findViewById(R.id.recyclerviewplaylist);
        tenPlaylist = view.findViewById(R.id.txtplaylist);
        GetData();
        return view;
    }

    private void GetData() {
       arrayPlayList = new ArrayList<>();
        Cursor dataPlayList= databaseHelper.getData("SELECT * FROM PlayList");
        arrayPlayList.clear();
        while (dataPlayList.moveToNext()) {
            String MaPlayList = dataPlayList.getString(0);
            String TenPlayList = dataPlayList.getString(1);
            String HinhPlayList = dataPlayList.getString(2);
            arrayPlayList.add(new PlayListModel(MaPlayList, TenPlayList, HinhPlayList));
        }
              playlistAdapter = new PlaylistAdapter(getActivity(),arrayPlayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewplaylist.setLayoutManager(linearLayoutManager);
                recyclerViewplaylist.setAdapter(playlistAdapter);
                dataPlayList.close();
            }

    }
