package com.android.appmusic11.Model;

import java.io.Serializable;

public class ThinhHanhModel implements Serializable {
    private String MaThinhHanh;
    private String TenThinhHanh;
    private String HinhThinhHanh;

    public ThinhHanhModel(String maThinhHanh, String tenThinhHanh, String hinhThinhHanh) {
        MaThinhHanh = maThinhHanh;
        TenThinhHanh = tenThinhHanh;
        HinhThinhHanh = hinhThinhHanh;
    }

    public String getMaThinhHanh() {
        return MaThinhHanh;
    }

    public void setMaThinhHanh(String maThinhHanh) {
        MaThinhHanh = maThinhHanh;
    }

    public String getTenThinhHanh() {
        return TenThinhHanh;
    }

    public void setTenThinhHanh(String tenThinhHanh) {
        TenThinhHanh = tenThinhHanh;
    }

    public String getHinhThinhHanh() {
        return HinhThinhHanh;
    }

    public void setHinhThinhHanh(String hinhThinhHanh) {
        HinhThinhHanh = hinhThinhHanh;
    }
}
