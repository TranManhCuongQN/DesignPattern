package com.android.appmusic11.Model;

import java.io.Serializable;

public class NgheSiModel implements Serializable {
    private String MaNgheSi;
    private String TenNgheSi;
    private String HinhNgheSi;

    public NgheSiModel(String maNgheSi, String tenNgheSi, String hinhNgheSi) {
        MaNgheSi = maNgheSi;
        TenNgheSi = tenNgheSi;
        HinhNgheSi = hinhNgheSi;
    }

    public String getMaNgheSi() {
        return MaNgheSi;
    }

    public void setMaNgheSi(String maNgheSi) {
        MaNgheSi = maNgheSi;
    }

    public String getTenNgheSi() {
        return TenNgheSi;
    }

    public void setTenNgheSi(String tenNgheSi) {
        TenNgheSi = tenNgheSi;
    }

    public String getHinhNgheSi() {
        return HinhNgheSi;
    }

    public void setHinhNgheSi(String hinhNgheSi) {
        HinhNgheSi = hinhNgheSi;
    }
}
