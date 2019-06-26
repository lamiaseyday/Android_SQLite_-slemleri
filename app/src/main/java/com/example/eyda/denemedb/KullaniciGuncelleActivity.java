package com.example.eyda.denemedb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class KullaniciGuncelleActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText edtId, edtNewAdSoyad, edtNewKuladi;
    Button updateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kullanici_guncelle);

        myDb = new DatabaseHelper(this);
        init();
    }

    private void init() {
        edtId = findViewById(R.id.edtId);
        edtNewAdSoyad = findViewById(R.id.edtNewAd);
        edtNewKuladi = findViewById(R.id.edtNewKulAd);
        updateButton = findViewById(R.id.btn_guncelle);
    }

    public void Guncelle(View view){
        boolean isUpdate = myDb.UpdateData(edtId.getText().toString(), edtNewAdSoyad.getText().toString(),
                edtNewKuladi.getText().toString());

        if(!edtId.getText().toString().equalsIgnoreCase("") &&
                !edtNewAdSoyad.getText().toString().equalsIgnoreCase("") &&
                !edtNewKuladi.getText().toString().equalsIgnoreCase("")) {

            Toast.makeText(this, "Güncellendi", Toast.LENGTH_SHORT).show();
        }else {
                Toast.makeText(this, "Güncellemede Hata", Toast.LENGTH_SHORT).show();
            }
    }

    @Override
    public void onBackPressed() {
        // Çalışmasını istediğiniz kodu buraya yazacağız
        Intent i = new Intent(KullaniciGuncelleActivity.this, Page1.class);
        startActivity(i);
        finish();
        super.onBackPressed();
    }
}
