package com.example.eyda.denemedb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class KulSilActivity extends AppCompatActivity {

    DatabaseHelper mydb;

    EditText edtDeleteId;
    Button sil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kul_sil);

        mydb = new DatabaseHelper(KulSilActivity.this);
        edtDeleteId = findViewById(R.id.edtSilId);
        sil = findViewById(R.id.btn_sil);
    }

    public void Sil(View view){
        boolean isDelete = mydb.DeleteData(edtDeleteId.getText().toString());

        if(!edtDeleteId.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(this, "Silindi", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Hata!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        // Çalışmasını istediğiniz kodu buraya yazacağız

        Intent i = new Intent(KulSilActivity.this, Page1.class);
        startActivity(i);
        finish();
        super.onBackPressed();

    }
}
