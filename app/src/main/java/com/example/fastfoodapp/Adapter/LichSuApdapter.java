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

import com.example.fastfoodapp.Object.LichSu;
import com.example.fastfoodapp.Object.MonAn;
import com.example.fastfoodapp.R;

import java.util.ArrayList;

public class LichSuApdapter extends ArrayAdapter<LichSu> {

    public LichSuApdapter(@NonNull Context context, ArrayList<LichSu> lichSuArrayList) {
        super(context, R.layout.layout_dong,lichSuArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LichSu lichSu = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_dong,parent,false);
        }

        // ánh xạ
        TextView ten = convertView.findViewById(R.id.name);
        TextView time = convertView.findViewById(R.id.time);
        TextView description = convertView.findViewById(R.id.description);
        TextView price = convertView.findViewById(R.id.price);
        ImageView hinh = convertView.findViewById(R.id.hinh);

        ten.setText(lichSu.getTen());
        time.setText(lichSu.getThoiGian());
        description.setText(lichSu.getIngredient());
        price.setText(lichSu.getGia());
        hinh.setImageResource(lichSu.getAnh());

        return convertView;
    }
}
