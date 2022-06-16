package com.android.appmusic11.Model;

import java.io.Serializable;

public class BangXepHangModel implements Serializable {
    private String MaBangXepHang;
    private String TenBangXepHang;
    private String HinhBangXepHang;

    public BangXepHangModel(String maBangXepHang, String tenBangXepHang, String hinhBangXepHang) {
        MaBangXepHang = maBangXepHang;
        TenBangXepHang = tenBangXepHang;
        HinhBangXepHang = hinhBangXepHang;
    }

    public String getMaBangXepHang() {
        return MaBangXepHang;
    }

    public void setMaBangXepHang(String maBangXepHang) {
        MaBangXepHang = maBangXepHang;
    }

    public String getTenBangXepHang() {
        return TenBangXepHang;
    }

    public void setTenBangXepHang(String tenBangXepHang) {
        TenBangXepHang = tenBangXepHang;
    }

    public String getHinhBangXepHang() {
        return HinhBangXepHang;
    }

    public void setHinhBangXepHang(String hinhBangXepHang) {
        HinhBangXepHang = hinhBangXepHang;
    }
}
