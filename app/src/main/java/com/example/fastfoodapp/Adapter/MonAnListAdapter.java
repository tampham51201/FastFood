package com.example.fastfoodapp.Adapter;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.fastfoodapp.Activity.MainActivity;
import com.example.fastfoodapp.Object.MonAn;
import com.example.fastfoodapp.R;

import java.util.ArrayList;

public class MonAnListAdapter extends ArrayAdapter<MonAn> {


    public MonAnListAdapter(@NonNull Context context, ArrayList<MonAn> monAnListArrayList) {
        super(context, R.layout.layout_monan,monAnListArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        MonAn monAn = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_monan,parent,false);
        }

        // ánh xạ
        TextView ten = convertView.findViewById(R.id.ten);
        TextView size = convertView.findViewById(R.id.size);
        TextView gia = convertView.findViewById(R.id.gia);
        Button add = convertView.findViewById(R.id.btn_add);

        ImageView anh = convertView.findViewById(R.id.imageviewAnh);

        ten.setText(monAn.getTenMon());
        size.setText(monAn.getSize());
        gia.setText(monAn.getGia());

        anh.setImageResource(monAn.getHinhMon());
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable add2=(Drawable) add.getResources().getDrawable(R.drawable.add_active);
                add.setBackground(add2);
            }
        });

        return convertView;
    }
}
