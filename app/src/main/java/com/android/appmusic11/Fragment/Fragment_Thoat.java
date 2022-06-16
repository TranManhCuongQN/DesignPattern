package com.android.appmusic11.Fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.appmusic11.Activity.MainActivity;
import com.android.appmusic11.Activity.PlayNhacActivity;
import com.android.appmusic11.Activity.TrangChuActivity;
import com.android.appmusic11.R;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class Fragment_Thoat extends Fragment {
    Button btn;
    View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_thoat, container, false);
        AnhXa();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MainActivity.class);
                startActivity(intent);

                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startMain.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(startMain);
                getActivity().finish();
                System.exit(0);
            }
        });
        return  view;
    }
    private void AnhXa() {
        btn = view.findViewById(R.id.btndangxuat);
    }
}
