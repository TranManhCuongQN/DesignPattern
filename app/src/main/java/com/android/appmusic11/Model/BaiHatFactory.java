package com.android.appmusic11.Model;


public class BaiHatFactory  {


    public BaiHat getBaiHat (String baiHat)
    {
        if(baiHat == null)
        {
            return  null;
        }
        if(baiHat.equalsIgnoreCase("BaiHatModel"))
        {

            return new BaiHatModel();
        }

        if(baiHat.equalsIgnoreCase("BaiHatYeuThichModel"))
        {
            return new BaiHatYeuThichModel();
        }

        if(baiHat.equalsIgnoreCase("BaiHatThuVienPlayListModel"))
        {
            return new BaiHatThuVienPlayListModel();
        }

        return null;

    }


}
