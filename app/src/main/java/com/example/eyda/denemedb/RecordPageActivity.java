package com.example.eyda.denemedb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RecordPageActivity extends AppCompatActivity {

    /*
    * Nesne ve bileşenlerin tanımlamalarını yapıyoruz.
    * */

    DatabaseHelper myDb;

    EditText editName, editUsername, editParola, editParolaTekrar;
    Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record_layout_);

        /*
        * myDb nesnemizin initialize işlemini yapıyoruz ve içerik(context)
        * olarak bulunduğumuz yani kullanacağımız activity'i giriyoruz.
        * */
        myDb = new DatabaseHelper(RecordPageActivity.this);

        /*
        * init() metodu ile view nesnelerimizi activity'e bağlıyoruz
        * findViewById metodu ile id isimleriyle çekiyoruz.
        * */
        init();
    }

    private void init() {
        editName = findViewById(R.id.edtAd);
        editUsername = findViewById(R.id.edtKulAd);
        editParola = findViewById(R.id.edtParola);
        editParolaTekrar = findViewById(R.id.edtParolaTekrar);
        buttonAdd = findViewById(R.id.btn_kayit);
    }


    /*
    * buttonAdd isimli butonumuzun onClick ismini "Ekle" olarak belirledik.
    * İlk olarak koşul ifadeleri içerisinde bileşenlerin doğru bir şekilde
    * doldurulup doldurulmadığını kontrol ediyoruz.
    * Eğer bir sıkıntı yoksa boolean bir değişken olan isAdd değişkeni oluşturup
    * myDb nesnesi üzerinden DatabaseHelper sınıfında bulunan "insertData" metodunu
    * çalıştırıyoruz.
    * */

    public void Ekle(View view){
        if(editName.getText().toString().equalsIgnoreCase("") || editUsername.getText().toString().equalsIgnoreCase("") ||
                editParola.getText().toString().equalsIgnoreCase("") || editParolaTekrar.getText().toString().equalsIgnoreCase("")){

            Toast.makeText(RecordPageActivity.this, "Boş Alan var!!!", Toast.LENGTH_SHORT).show();
        }else if(editParola.length() < 6){
            Toast.makeText(RecordPageActivity.this, "Parola min 6 karakterli olmalı!!!", Toast.LENGTH_SHORT).show();
        }else if(!editParolaTekrar.getText().toString().equalsIgnoreCase(editParola.getText().toString())){
            Toast.makeText(RecordPageActivity.this, "Parolalar uyuşmuyor!!!", Toast.LENGTH_SHORT).show();
        }else{
            boolean isAdd = myDb.insertData(editName.getText().toString(),
                    editUsername.getText().toString(),
                    editParola.getText().toString(), editParolaTekrar.getText().toString());
            if(isAdd){
                Toast.makeText(RecordPageActivity.this, "Eklendi!!!", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(RecordPageActivity.this, "Hata!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // Çalışmasını istediğiniz kodu buraya yazacağız

        Intent i = new Intent(RecordPageActivity.this, WelcomeActivity.class);
        startActivity(i);
        finish();
        super.onBackPressed();

    }
}
