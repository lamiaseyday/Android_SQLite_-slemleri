package com.example.eyda.denemedb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    /*
    * Her activity onCreate metodu ile başlar!!
    * */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        /*
        * setContenView metodu ile bu activity'de hangi
        * layout görünecek onu belirliyoruz.
        * */
    }

    @Override
    /*Menu elemanlarımızı yazdığımız xml dosyasını
    onCreateOptionsMenu metodunu override ederek activity'e ekliyoruz.*/
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menuler_items, menu);
        return true;
    }

    @Override
    /*onOptionsItemSelected metodunu override ederekte
    her menüyü seçtiğimizde(tıkladığımızda) neler olacak
    belirliyoruz.*/
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.itemRecord:

                //RecordPageActivity activity'ne geçiş yaptırıyoruz.
                Intent intent_1 = new Intent(WelcomeActivity.this, RecordPageActivity.class);
                startActivity(intent_1);
                finish();
                break;
            case R.id.itemLogin:

                //LoginActivity activity'ne geçiş yaptırıyoruz.
                Intent intent_2 = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent_2);
                finish();
                break;
            case R.id.itemHelp:
                Toast.makeText(WelcomeActivity.this, "Help", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemExit:
                Toast.makeText(WelcomeActivity.this, "Çıkış", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
