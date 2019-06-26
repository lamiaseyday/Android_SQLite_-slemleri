package com.example.eyda.denemedb;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Page1 extends AppCompatActivity {
    /*
    * ViewPager ve Adapter tipinde
    * nesne oluşturuyoruz.
    * */
    ViewPager viewPager;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);
        /*
        * Çalışacak metodları sırayla çağırıyoruz.
        * */
        ViewPagerCagir();
        AktifOlan();
    }

    private void ViewPagerCagir() {
        viewPager = findViewById(R.id.view);
        adapter = new Adapter(getApplicationContext(), getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
    }

    private void AktifOlan() {

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }
            /*
            * İşimize yarayan metod...
            * */

            @Override
            public void onPageSelected(int i) {
                /*
                * i'nin değeri neye eşitse o indise
                * sahip olan sayfa visible olur yani
                * bi nevi aktif olur.
                * */
                switch (i){
                    case 0:
                        findViewById(R.id.baslik1).setVisibility(View.VISIBLE);
                        findViewById(R.id.baslik2).setVisibility(View.INVISIBLE);
                        findViewById(R.id.baslik3).setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        findViewById(R.id.baslik1).setVisibility(View.INVISIBLE);
                        findViewById(R.id.baslik2).setVisibility(View.VISIBLE);
                        findViewById(R.id.baslik3).setVisibility(View.INVISIBLE);
                        break;

                    case 2:
                        findViewById(R.id.baslik1).setVisibility(View.INVISIBLE);
                        findViewById(R.id.baslik2).setVisibility(View.INVISIBLE);
                        findViewById(R.id.baslik3).setVisibility(View.VISIBLE);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    public void ekran1(View view){
        Intent intent = new Intent(Page1.this, ListUsers.class);
        startActivity(intent);
        finish();
    }

    public void ekran2(View view){
        Intent intent = new Intent(Page1.this, KullaniciGuncelleActivity.class);
        startActivity(intent);
        finish();
    }

    public void ekran3(View view){
        Intent intent = new Intent(Page1.this, KulSilActivity.class);
        startActivity(intent);
        finish();
    }

}
