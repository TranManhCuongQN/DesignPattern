package com.android.appmusic11.Model;

import java.io.Serializable;

public class ChuDeModel implements Serializable {
    private String MaChuDe;
    private String TenChuDe;
    private String HinhChuDe;

    public ChuDeModel(String maChuDe, String tenChuDe, String hinhChuDe) {
        MaChuDe = maChuDe;
        TenChuDe = tenChuDe;
        HinhChuDe = hinhChuDe;
    }

    public String getMaChuDe() {
        return MaChuDe;
    }

    public void setMaChuDe(String maChuDe) {
        MaChuDe = maChuDe;
    }

    public String getTenChuDe() {
        return TenChuDe;
    }

    public void setTenChuDe(String tenChuDe) {
        TenChuDe = tenChuDe;
    }

    public String getHinhChuDe() {
        return HinhChuDe;
    }

    public void setHinhChuDe(String hinhChuDe) {
        HinhChuDe = hinhChuDe;
    }
}
