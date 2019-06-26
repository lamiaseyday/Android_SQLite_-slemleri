package com.example.eyda.denemedb;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListUsers extends AppCompatActivity {

    DatabaseHelper mDb;
    private ArrayList<KullaniciBilgi> listContent = new ArrayList<>();
    ListView liste;
    CustomAdapter adapter;

    //ArrayAdapter dizim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);

        liste = findViewById(R.id.listView1);
        mDb = new DatabaseHelper(this);

        Goster();

        /*
        * oluşturduğumuz custom satırlara CustomAdapter
        * nesnesi üzerinden ulaşıyoruz. Aynı şekilde
        * verilerede..
        * */
        adapter = new CustomAdapter(this,R.layout.customlistview1, listContent);
        liste.setAdapter(adapter);

    }
    private void Goster(){

        /*
        * Butona tıkladığımızda DatabaseHelper sınıfındaki
        * getContent() metodunu çalıştırıp verilerin listelenmesini
        * sağlıyoruz
        * */
        Cursor data = mDb.getContent();

        /*
        * moveToNext() metodu sayesinde sırada yeni
        * bir eleman olduğu sürece döngü devam ediyor
        * ve elemanlar sırayla listeye ekleniyor.
        * */
        while (data.moveToNext()){
            String name = data.getString(1);
            String username = data.getString(2);
            listContent.add(new KullaniciBilgi(name, username));
        }
    }

    @Override
    public void onBackPressed() {
        // Çalışmasını istediğiniz kodu buraya yazacağız

        Intent i = new Intent(ListUsers.this, Page1.class);
        startActivity(i);
        finish();
        super.onBackPressed();

    }
}





