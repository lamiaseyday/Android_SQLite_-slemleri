package com.example.eyda.denemedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    //DATABASE_PATH

    public static final String DATABASE_NAME = "stu.db";
    public static final String TABLE_NAME = "student_table";
    public static final String COL_1 = "ID";
    public String COL_2 = "NAME";
    public String COL_3 = "USERNAME";
    public static final String COL_4 = "PAROLA";
    public static final String COL_5 = "PAROLATEKRAR";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        // SQLiteDatabase db = this.getWritableDatabase();

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, USERNAME TEXT, PAROLA TEXT, PAROLATEKRAR TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public boolean insertData(String name, String username, String parola, String parolatekrar) {

        /*SQLiteOpenHelper sınıfı getReadableDatabase() ve getWriteableDatabase() methodları
        ile SQLiteDatabase objelerinde okuma ya da yazma işlemini yapmayı sağlar.
        getWritableDatabase() metodu ile veritabanını yazılabilir hale getiriyoruz.!!!*/

        SQLiteDatabase db = this.getWritableDatabase();

        //HashMap formatında çalışan ContentValues objesi oluşturuyoruz.
        //Bu obje içerisine sabit değerlerine göre aldığımız parametreleri gönderiyoruz.


        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name.trim());
        contentValues.put(COL_3, username.trim());
        contentValues.put(COL_4, parola.trim());
        contentValues.put(COL_5, parolatekrar.trim());

        long result = db.insert(TABLE_NAME, null, contentValues);

        return result != -1;
    }


    public boolean GirisOlsunmu(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();

        //Veritabanımda ki username ve parola colonlarımı listeliyorum.

        String selectQuery = " select * from " + TABLE_NAME + " WHERE USERNAME = '" + username + "' AND PAROLA = '" + password + "'";
        Cursor cursor = db.rawQuery(selectQuery, null);

        //Çektiğim değerleri bir liste oluşturup cursor nesnesi ile listeye ekliyorum.

        List<Boolean> degerler = new ArrayList<>();
        degerler.add(cursor.moveToNext());


        if (cursor.getCount() > 0)
            selectQuery = "select * from " + TABLE_NAME + " WHERE USERNAME = '" + cursor.getString(2)
                    + "' AND PAROLA = " + cursor.getString(3);

        else return false;

        Cursor cv = db.rawQuery(selectQuery, null);
        if (cv.getCount() == 1) {
            cv.close();
            return true;
        } else {
            return false;
        }
    }

    public Cursor getContent(){

        //Cursor sayesinde tüm elemanların üzerinde gezebiliyoruz.

        //Veri tabanını okunabilir hale getiriyoruz.
        SQLiteDatabase db = this.getReadableDatabase();

        //sql sorgusu ile istediğimiz kolonları listeliyoruz.
        Cursor data = db.rawQuery("select ID, NAME, USERNAME FROM " + TABLE_NAME, null);
        return data;
    }

    /*
    * Güncellemek istediğim kolonları metoda parametre olarak veriyorum.
    * */
    public boolean UpdateData(String id, String adSoyad, String kullaniciAd){

        /*
        * Veri tabanını okunabilir hale getiriyoruz.
        * */
        SQLiteDatabase db = this.getWritableDatabase();

        /*
        * ContentValues ile değereler üzerinde gezip işlem yapıyoruz.
        * */
        ContentValues degerler = new ContentValues();
        degerler.put(COL_1, id.trim());
        degerler.put(COL_2, adSoyad.trim());
        degerler.put(COL_3, kullaniciAd.trim());

        db.update(TABLE_NAME, degerler, "ID = ?", new String[] {id});
         return true;
    }

    public boolean DeleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COL_1, id.trim());

        db.delete(TABLE_NAME, "ID = ?", new String[] {id});

        return true;
    }



    //1.Yol....
   /* public List<String> tumKayitlar() {
        List<String> liste = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            //String sec = " select * from " + TABLE_NAME + " where NAME  AND USERNAME ";
            //String sec = String.format("select * from %s where %s and %s", TABLE_NAME, COL_2, COL_3);
            String sql = " select NAME, USERNAME FROM " + TABLE_NAME;
            Cursor cr = db.rawQuery(sql, null);
            while (cr.moveToNext()) {
                //ContentValues contentValues = new ContentValues();
                // contentValues.put(" ", cr.getString(cr.getColumnIndex(COL_2)));
                // contentValues.put("", cr.getString(cr.getColumnIndex(COL_3)));
                liste.add(cr.getString(cr.getColumnIndex(COL_2)) + "     " + cr.getString(cr.getColumnIndex(COL_3)));
            }
            db.close();
            cr.close();
            return liste;
        } catch (Exception e) {
            return liste;
        }
    }*/



   /* public List<String> TamAdKullaniciAd(){

        List<String> küme = new ArrayList<>();
        try{
            SQLiteDatabase db = this.getWritableDatabase();
            String sql = " select NAME, USERNAME FROM " + TABLE_NAME;
            Cursor c = db.rawQuery(sql, null);

            while (!c.isAfterLast()){
                String fullNames = c.getString(1);
                String userNames = c.getString(2);
                KullanıcıBilgi kb = new KullanıcıBilgi(fullNames, userNames);
                küme.add(kb.toString());
                c.moveToNext();
            }
            db.close();
            c.close();
            return  küme;
        }catch (Exception e){
            return küme;
        }

}*/
    //2.Yol..
   /* public List<ContentValues> tumKayitlar(){
        List<ContentValues> liste = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            //String sec = " select * from " + TABLE_NAME + " where NAME  AND USERNAME ";
            //String sec = String.format("select * from %s where %s and %s", TABLE_NAME, COL_2, COL_3);
            String sql = " select NAME, USERNAME FROM " + TABLE_NAME;
            Cursor cr = db.rawQuery(sql, null);
            while (cr.moveToNext()){
                ContentValues contentValues = new ContentValues();
                contentValues.put(" ", cr.getString(cr.getColumnIndex(COL_2)));
                contentValues.put("", cr.getString(cr.getColumnIndex(COL_3)));
                liste.add(contentValues);
            }
            db.close();
            cr.close();
            return liste;
        }catch (Exception e){
            return liste;
        }
    }*/

 /*   public Cursor getAllData(String username, String password){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery(" select * from "+TABLE_NAME + " WHERE USERNAME = '" + username + "' AND PAROLA = '" + password + "'", null);
        //Cursor objesi gönderilen query değerine göre istenilen verileri tutmaya yarıyor
        if (res!= null) {
            res.moveToFirst();
        }
        return res;
    }*/

    /*public Cursor getAllData(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        //Cursor objesi gönderilen query değerine göre istenilen verileri tutmaya yarıyor
        return res;
    }

    public boolean updateData(String id, String name, String surname, String age){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, surname);
        contentValues.put(COL_4, age);
        db.update(TABLE_NAME, contentValues, "ID= ?", new String[] { id });
        return true;
    }

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[] { id });
    }*/

  /*  TextView textFullName = lineViews.findViewById(R.id.txtFullName);
    TextView textUsername = lineViews.findViewById(R.id.txtUsername);
    String[] bilgiler = dbHelper.TamAdKullaniciAd().get(position).split("-");
            textFullName.setText(bilgiler[0]);
            textUsername.setText(bilgiler[1]);
            return lineViews;*/
}
