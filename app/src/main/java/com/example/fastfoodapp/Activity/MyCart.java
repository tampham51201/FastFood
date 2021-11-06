package com.example.fastfoodapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fastfoodapp.Adapter.GiohangAdapter;
import com.example.fastfoodapp.Object.MonAn;
import com.example.fastfoodapp.R;
import com.example.fastfoodapp.databinding.ActivityMyCartBinding;


import java.util.ArrayList;

public class MyCart extends AppCompatActivity {

    ActivityMyCartBinding binding;

    TextView btnBack,numberOrderTxt;
    private int numberOrder = 1;
    private ImageView plusBtn, minusBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        cainaylaNut();


        String[] ten ={"Bánh donut","Bánh sandwich","Xúc xích"};
        int[] hinh = {R.drawable.donut,R.drawable.sw,R.drawable.xucxich};
        String[] calo ={"200","200","200"};
        String[] size= {"S","S","S"};
        String[] gia= {"50000","50000","50000"};
        String[] tong= {"50000","150000","100000"};
        Double[] sao={4.6,4.6,4.6};
        String[] ingredient={"hoa","la","canh"};

        String[] Mota={"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus.",
                "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus.",
                "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus."};
        int[] anhMot={R.drawable.dualeo,R.drawable.dualeo,R.drawable.dualeo};
        int[] anhHai={R.drawable.cachua,R.drawable.cachua,R.drawable.cachua};
        int[] anhBa={R.drawable.thitbo,R.drawable.thitbo,R.drawable.thitbo};
        int[] anhBon={R.drawable.xalach,R.drawable.xalach,R.drawable.xalach};
        int[] quantity={1,3,2};


        ArrayList<MonAn> monAnArrayList = new ArrayList<>();

        for(int i=0;i<hinh.length;i++){

            MonAn monAn = new MonAn(ten[i],hinh[i],calo[i],sao[i],size[i],gia[i],tong[i],Mota[i],ingredient[i],anhMot[i],anhHai[i],anhBa[i],anhBon[i],quantity[i]);
            monAnArrayList.add(monAn);
        }

        GiohangAdapter giohangAdapter = new GiohangAdapter(MyCart.this,monAnArrayList);
        binding.lvGiohang.setAdapter(giohangAdapter);
        binding.lvGiohang.setClickable(true);
        binding.lvGiohang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent =new Intent(MyCart.this,ShowDetail.class);
                intent.putExtra("ten",ten[i]);
                intent.putExtra("hinh",hinh[i]);
                intent.putExtra("calo",calo[i]);
                intent.putExtra("sao",sao[i]);
                intent.putExtra("size",size[i]);
                intent.putExtra("gia",gia[i]);
                intent.putExtra("tong",tong[i]);
                intent.putExtra("Mota",Mota[i]);
                intent.putExtra("anhMot",anhMot[i]);
                intent.putExtra("anhHai",anhHai[i]);
                intent.putExtra("anhBa",anhBa[i]);
                intent.putExtra("anhBon",anhBon[i]);

                startActivity(intent);

            }
        });

    }

    private void display(int number) {
        numberOrderTxt.setText("number");
    }

    private void cainaylaNut() {
        btnBack=(TextView) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyCart.this, Home.class));
            }
        });
    }
}