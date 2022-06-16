package com.android.appmusic11.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class BaiHatModel implements Parcelable,BaiHat {
    private int MaBaiHat;
    private String TenBaiHat;
    private String HinhBaiHat;
    private String TenCaSi;
    private String LinkBaiHat;

    public BaiHatModel(int maBaiHat, String tenBaiHat, String hinhBaiHat, String tenCaSi, String linkBaiHat) {
        MaBaiHat = maBaiHat;
        TenBaiHat = tenBaiHat;
        HinhBaiHat = hinhBaiHat;
        TenCaSi = tenCaSi;
        LinkBaiHat = linkBaiHat;
    }
    public BaiHatModel(){

    }

    protected BaiHatModel(Parcel in) {
        MaBaiHat = in.readInt();
        TenBaiHat = in.readString();
        HinhBaiHat = in.readString();
        TenCaSi = in.readString();
        LinkBaiHat = in.readString();
    }

    public static final Creator<BaiHatModel> CREATOR = new Creator<BaiHatModel>() {
        @Override
        public BaiHatModel createFromParcel(Parcel in) {
            return new BaiHatModel(in);
        }

        @Override
        public BaiHatModel[] newArray(int size) {
            return new BaiHatModel[size];
        }
    };

    public int getMaBaiHat() {
        return MaBaiHat;
    }

    public void setMaBaiHat(int maBaiHat) {
        MaBaiHat = maBaiHat;
    }

    public String getTenBaiHat() {
        return TenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        TenBaiHat = tenBaiHat;
    }

    public String getHinhBaiHat() {
        return HinhBaiHat;
    }

    public void setHinhBaiHat(String hinhBaiHat) {
        HinhBaiHat = hinhBaiHat;
    }

    public String getTenCaSi() {
        return TenCaSi;
    }

    public void setTenCaSi(String tenCaSi) {
        TenCaSi = tenCaSi;
    }

    public String getLinkBaiHat() {
        return LinkBaiHat;
    }

    public void setLinkBaiHat(String linkBaiHat) {
        LinkBaiHat = linkBaiHat;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(MaBaiHat);
        parcel.writeString(TenBaiHat);
        parcel.writeString(HinhBaiHat);
        parcel.writeString(TenCaSi);
        parcel.writeString(LinkBaiHat);
    }
}
