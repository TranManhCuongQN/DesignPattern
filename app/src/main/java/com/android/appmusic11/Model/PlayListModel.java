package com.android.appmusic11.Model;

import java.io.Serializable;

public class PlayListModel implements Serializable {
    private String MaPlayList;
    private String TenPlayList;
    private String HinhPlayList;

    public PlayListModel(String maPlayList, String tenPlayList, String hinhPlayList) {
        MaPlayList = maPlayList;
        TenPlayList = tenPlayList;
        HinhPlayList = hinhPlayList;
    }

    public String getMaPlayList() {
        return MaPlayList;
    }

    public void setMaPlayList(String maPlayList) {
        MaPlayList = maPlayList;
    }

    public String getTenPlayList() {
        return TenPlayList;
    }

    public void setTenPlayList(String tenPlayList) {
        TenPlayList = tenPlayList;
    }

    public String getHinhPlayList() {
        return HinhPlayList;
    }

    public void setHinhPlayList(String hinhPlayList) {
        HinhPlayList = hinhPlayList;
    }
}
