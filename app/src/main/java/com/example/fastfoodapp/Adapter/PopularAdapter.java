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

import java.util.ArrayList;

public class PopularAdapter extends ArrayAdapter<MonAn> {


    public PopularAdapter(@NonNull Context context, ArrayList<MonAn> monAnArrayList) {
        super(context,  R.layout.row_recycler,monAnArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        MonAn monAn = getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_recycler,parent,false);
        }

        //Anh xa
        ImageView imgHinh = convertView.findViewById(R.id.Product1);
        TextView txtTen = convertView.findViewById(R.id.txtTen);
        TextView txtGia = convertView.findViewById(R.id.txtGia);
        TextView txtSao = convertView.findViewById(R.id.txtSao);

        imgHinh.setImageResource(monAn.getHinhMon());
        txtTen.setText(monAn.getTenMon());
        txtGia.setText(monAn.getGia());
        txtSao.setText(monAn.getSao().toString());

        return convertView;
    }
}
