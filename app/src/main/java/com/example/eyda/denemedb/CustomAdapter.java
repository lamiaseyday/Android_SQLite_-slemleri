package com.example.eyda.denemedb;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

        /*
        * BaseAdapter sınıfından türettik.
        * */
        private Context context;
        private int layout;

        //Verileri tutacak KullanıcıBilgi tipinde ArrayList oluşturduk
        private ArrayList<KullaniciBilgi> content;


        public CustomAdapter(Context context,int layout, ArrayList<KullaniciBilgi> content) {
                this.context = context;
                this.content = content;
                this.layout = layout;
                }

        //Gerekli bir kaç override edilmesi gereken metod.
        @Override
        public int getCount() {
                return content.size();
                }

        @Override
        public Object getItem(int position) {
                return content.get(position);
                }

        @Override
        public long getItemId(int position) {
                return position;
                }

        /*
        * Custom olarak oluşturduğumuz bileşenleri tanımlıyoruz bu sınıfta.
        * */
        private class CustList{
            TextView txtN, txtU;
        }
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View row;
                CustList holder;
                LayoutInflater  layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                    row = layoutInflater.inflate(layout, null);
                    holder = new CustList();
                    holder.txtN = row.findViewById(R.id.txtFullName);
                    holder.txtU = row.findViewById(R.id.txtUsername);
                    row.setTag(holder);

                KullaniciBilgi dc = content.get(position);

                /*
                * KullaniciBilgi sınıfı sayesinde name ve username
                * değerlerini alıyoruz bileşenlere yerleştiriyoruz.
                * */
                holder.txtN.setText(dc.getFullName());
                holder.txtU.setText(dc.getUsername());

                return row;
            }
        }