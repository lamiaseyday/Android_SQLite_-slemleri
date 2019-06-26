package com.example.eyda.denemedb;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class Adapter extends FragmentPagerAdapter {

    /*
    * Adapter sınıfını FragmentPagerAdapter sınıfından türettik.
    * Context tipinde bir değişken oluşturduk.
    * Bu değişken bize Ekran1.java ve diğerlerinde oluşturduğumuz
    * Context tipinde parametre alan metod için yardımcı olacak.
    * */

    private Context myContext;

    //Yapıcı Metod
    public Adapter(Context myContext, FragmentManager fm){
        super(fm);
        this.myContext = myContext;
    }

    @Override
    public Fragment getItem(int i) {

        /*
        * Fragment sınıfından bir nesne oluşturduk.
        * girdiğimiz i parametresine göre switch case
        * yardımı ile gerekli olan view'ı sınıflardan
        * çektik.
        * */

        Fragment fragment = new Fragment();
        switch (i){
            case 0:
                fragment = Ekran1.newInstance(myContext);
                break;
            case 1:
                fragment = Ekran2.newInstance(myContext);
                break;
            case 2:
                fragment = Ekran3.newInstance(myContext);
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
