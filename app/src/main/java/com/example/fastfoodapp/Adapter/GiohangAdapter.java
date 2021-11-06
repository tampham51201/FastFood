package com.example.fastfoodapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.fastfoodapp.Object.MonAn;
import com.example.fastfoodapp.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class GiohangAdapter extends ArrayAdapter<MonAn> {

    public GiohangAdapter(@NonNull Context context, ArrayList<MonAn> monAnArrayList) {
        super(context, R.layout.layout_giohang,monAnArrayList);
    }
    public int count ;
    public int txtTong;
    public int txtGia;
    public String tong_format;
    public String gia_format;

    @Nullable


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        MonAn monAn = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_giohang,parent,false);
        }

        // ánh xạ
        TextView ten = convertView.findViewById(R.id.ten);
        TextView size = convertView.findViewById(R.id.size);
        TextView gia = convertView.findViewById(R.id.gia);
        TextView tong = convertView.findViewById(R.id.txttong);
        ImageView anh = convertView.findViewById(R.id.imageviewAnh);

        TextView value = convertView.findViewById(R.id.numberOrderTxt);
        ImageView plus = convertView.findViewById(R.id.plusBtn);
        ImageView minus = convertView.findViewById(R.id.minusBtn);

        ten.setText(monAn.getTenMon());
        size.setText(monAn.getSize());

        anh.setImageResource(monAn.getHinhMon());


        count=monAn.getQuantity();
        value.setText(String.valueOf(count));


        txtTong= Integer.parseInt(monAn.getTong());
        txtGia= Integer.parseInt(monAn.getGia());

        tong_format=NumberFormat.getNumberInstance(Locale.US).format(Integer.parseInt(monAn.getTong()));
        tong.setText(tong_format);
//        gia.setText(String.valueOf(txtGia));
        gia_format=NumberFormat.getNumberInstance(Locale.US).format(Integer.parseInt(monAn.getGia()));
        gia.setText(gia_format);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtTong= Integer.parseInt(monAn.getTong());
                count=monAn.getQuantity();
                count+=1;
                txtTong=txtGia*count;

                monAn.setQuantity(count);
                monAn.setTong((String.valueOf(txtTong)));
                value.setText(String.valueOf(count));
                tong_format=NumberFormat.getNumberInstance(Locale.US).format(Integer.parseInt(monAn.getTong()));
                tong.setText(tong_format);
//                tong.setText(monAn.getTong());
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                count=monAn.getQuantity();
                txtTong= Integer.parseInt(monAn.getTong());


                if(count <= 1) {
                    count = 1;
                    txtTong=txtTong;
                }
                else {
                    count -= 1;
                    txtTong=txtGia*count;
                }
                monAn.setQuantity(count);
                monAn.setTong((String.valueOf(txtTong)));
                value.setText(String.valueOf(count));
                tong_format=NumberFormat.getNumberInstance(Locale.US).format(Integer.parseInt(monAn.getTong()));
                tong.setText(tong_format);
            }
        });



        return convertView;
    }

}
