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

public class OrderAdapter extends ArrayAdapter<MonAn> {
public String giaformat;
    public OrderAdapter(@NonNull Context context, ArrayList<MonAn> monAnArrayList) {
        super(context, R.layout.product_myorder,monAnArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        MonAn monAn = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.product_myorder,parent,false);
        }

        // ánh xạ
        TextView ten = convertView.findViewById(R.id.ten);
        TextView gia = convertView.findViewById(R.id.gia);
        TextView soluong = convertView.findViewById(R.id.soluong);
        ImageView anh = convertView.findViewById(R.id.imageviewAnh);

        ten.setText(monAn.getTenMon());
        giaformat=NumberFormat.getNumberInstance(Locale.US).format(Integer.parseInt(monAn.getGia()));
        gia.setText(giaformat);

        soluong.setText(monAn.getQuantity()+"");
        anh.setImageResource(monAn.getHinhMon());

        return convertView;
    }
}