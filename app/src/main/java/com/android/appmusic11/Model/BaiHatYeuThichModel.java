package com.android.appmusic11.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class BaiHatYeuThichModel implements Parcelable,BaiHat {
private int MaYeuThich;
private int MaBaiHat;
private String TenBaiHat;
private String HinhBaiHat;
private String TenCaSi;
private String LinkBaiNhac;

    public BaiHatYeuThichModel(int maYeuThich, int maBaiHat, String tenBaiHat, String hinhBaiHat, String tenCaSi, String linkBaiNhac) {
        MaYeuThich = maYeuThich;
        MaBaiHat = maBaiHat;
        TenBaiHat = tenBaiHat;
        HinhBaiHat = hinhBaiHat;
        TenCaSi = tenCaSi;
        LinkBaiNhac = linkBaiNhac;
    }
    public BaiHatYeuThichModel(){

    };

    protected BaiHatYeuThichModel(Parcel in) {
        MaYeuThich = in.readInt();
        MaBaiHat = in.readInt();
        TenBaiHat = in.readString();
        HinhBaiHat = in.readString();
        TenCaSi = in.readString();
        LinkBaiNhac = in.readString();
    }

    public static final Creator<BaiHatYeuThichModel> CREATOR = new Creator<BaiHatYeuThichModel>() {
        @Override
        public BaiHatYeuThichModel createFromParcel(Parcel in) {
            return new BaiHatYeuThichModel(in);
        }

        @Override
        public BaiHatYeuThichModel[] newArray(int size) {
            return new BaiHatYeuThichModel[size];
        }
    };

    public int getMaYeuThich() {
        return MaYeuThich;
    }

    public void setMaYeuThich(int maYeuThich) {
        MaYeuThich = maYeuThich;
    }

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

    @Override
    public String getLinkBaiHat() {
        return null;
    }

    @Override
    public void setLinkBaiHat(String linkBaiHat) {

    }

    public String getLinkBaiNhac() {
        return LinkBaiNhac;
    }

    public void setLinkBaiNhac(String linkBaiNhac) {
        LinkBaiNhac = linkBaiNhac;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(MaYeuThich);
        parcel.writeInt(MaBaiHat);
        parcel.writeString(TenBaiHat);
        parcel.writeString(HinhBaiHat);
        parcel.writeString(TenCaSi);
        parcel.writeString(LinkBaiNhac);
    }
}
