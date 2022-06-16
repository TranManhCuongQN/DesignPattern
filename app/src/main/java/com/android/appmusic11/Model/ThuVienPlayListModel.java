package com.android.appmusic11.Model;

import java.io.Serializable;

public class ThuVienPlayListModel implements Serializable {
    private int MaThuVienPlayList;
    private String TenThuVienPlayList;
    private String HinhThuVienPlayList;

    public ThuVienPlayListModel(int maThuVienPlayList, String tenThuVienPlayList, String hinhThuVienPlayList) {
        MaThuVienPlayList = maThuVienPlayList;
        TenThuVienPlayList = tenThuVienPlayList;
        HinhThuVienPlayList = hinhThuVienPlayList;
    }

    public int getMaThuVienPlayList() {
        return MaThuVienPlayList;
    }

    public void setMaThuVienPlayList(int maThuVienPlayList) {
        MaThuVienPlayList = maThuVienPlayList;
    }

    public String getTenThuVienPlayList() {
        return TenThuVienPlayList;
    }

    public void setTenThuVienPlayList(String tenThuVienPlayList) {
        TenThuVienPlayList = tenThuVienPlayList;
    }

    public String getHinhThuVienPlayList() {
        return HinhThuVienPlayList;
    }

    public void setHinhThuVienPlayList(String hinhThuVienPlayList) {
        HinhThuVienPlayList = hinhThuVienPlayList;
    }
}
