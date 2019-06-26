package com.example.eyda.denemedb;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    DatabaseHelper mDb;
    EditText editUserName, editPar;
    Button btnGiris;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mDb = new DatabaseHelper(LoginActivity.this);
        editUserName = findViewById(R.id.edtUser);
        editPar = findViewById(R.id.edtPar);
        btnGiris = findViewById(R.id.btn_giris);
    }

    public void Giris(View view){

        String kullaniciAdi = editUserName.getText().toString();
        String parolaGir = editPar.getText().toString();

       // Cursor liste = mDb.getAllData(kullaniciAdi, parolaGir);

        boolean result = mDb.GirisOlsunmu(kullaniciAdi, parolaGir);

        if(result){
            Intent i = new Intent(LoginActivity.this, Page1.class);
            startActivity(i);
            finish();
        }else{
            Toast.makeText(LoginActivity.this, "hataa", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        // Çalışmasını istediğiniz kodu buraya yazacağız

        Intent i = new Intent(LoginActivity.this, WelcomeActivity.class);
        startActivity(i);
        finish();
        super.onBackPressed();

    }
}
