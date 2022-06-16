package com.android.appmusic11.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class BaiHatThuVienPlayListModel implements Parcelable,BaiHat {
   private int MaBaiHatThuVienPlayList;
   private int MaThuVienPlayList;
   private int MaBaiHat;
   private String TenBaiHat;
   private String HinhBaiHat;
   private String TenCaSi;
   private String LinkBaiHat;

    public BaiHatThuVienPlayListModel(int maBaiHatThuVienPlayList, int maThuVienPlayList, int maBaiHat, String tenBaiHat, String hinhBaiHat, String tenCaSi, String linkBaiHat) {
        MaBaiHatThuVienPlayList = maBaiHatThuVienPlayList;
        MaThuVienPlayList = maThuVienPlayList;
        MaBaiHat = maBaiHat;
        TenBaiHat = tenBaiHat;
        HinhBaiHat = hinhBaiHat;
        TenCaSi = tenCaSi;
        LinkBaiHat = linkBaiHat;
    }
    public BaiHatThuVienPlayListModel(){

    };
    protected BaiHatThuVienPlayListModel(Parcel in) {
        MaBaiHatThuVienPlayList = in.readInt();
        MaThuVienPlayList = in.readInt();
        MaBaiHat = in.readInt();
        TenBaiHat = in.readString();
        HinhBaiHat = in.readString();
        TenCaSi = in.readString();
        LinkBaiHat = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(MaBaiHatThuVienPlayList);
        dest.writeInt(MaThuVienPlayList);
        dest.writeInt(MaBaiHat);
        dest.writeString(TenBaiHat);
        dest.writeString(HinhBaiHat);
        dest.writeString(TenCaSi);
        dest.writeString(LinkBaiHat);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BaiHatThuVienPlayListModel> CREATOR = new Creator<BaiHatThuVienPlayListModel>() {
        @Override
        public BaiHatThuVienPlayListModel createFromParcel(Parcel in) {
            return new BaiHatThuVienPlayListModel(in);
        }

        @Override
        public BaiHatThuVienPlayListModel[] newArray(int size) {
            return new BaiHatThuVienPlayListModel[size];
        }
    };

    public int getMaBaiHatThuVienPlayList() {
        return MaBaiHatThuVienPlayList;
    }

    public void setMaBaiHatThuVienPlayList(int maBaiHatThuVienPlayList) {
        MaBaiHatThuVienPlayList = maBaiHatThuVienPlayList;
    }

    public int getMaThuVienPlayList() {
        return MaThuVienPlayList;
    }

    public void setMaThuVienPlayList(int maThuVienPlayList) {
        MaThuVienPlayList = maThuVienPlayList;
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

    public String getLinkBaiHat() {
        return LinkBaiHat;
    }

    public void setLinkBaiHat(String linkBaiHat) {
        LinkBaiHat = linkBaiHat;
    }
}
