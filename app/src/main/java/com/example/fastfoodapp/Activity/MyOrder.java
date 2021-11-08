package com.example.fastfoodapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fastfoodapp.Adapter.GiohangAdapter;
import com.example.fastfoodapp.Adapter.OrderAdapter;
import com.example.fastfoodapp.Object.MonAn;
import com.example.fastfoodapp.R;
import com.example.fastfoodapp.databinding.ActivityMyCartBinding;
import com.example.fastfoodapp.databinding.ActivityMyOrderBinding;

import java.util.ArrayList;

public class MyOrder extends AppCompatActivity {

    ActivityMyOrderBinding binding;
    LinearLayout btnAddress,btnCheckOut;
    TextView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMyOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        String[] ten ={"Bánh donut","Bánh sandwich","Xúc xích"};
        int[] hinh = {R.drawable.donut,R.drawable.xucxich,R.drawable.donut};
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

        btnAddress=(LinearLayout) findViewById(R.id.btnAddress);
        btnAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyOrder.this, Address.class));
            }
        });
        btnCheckOut=(LinearLayout) findViewById(R.id.btnCheckOut);
        btnCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyOrder.this, CheckOut.class));
            }
        });
        btnBack=(TextView) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyOrder.this, MyCart.class));
            }
        });
        OrderAdapter orderApdapter = new OrderAdapter(MyOrder.this,monAnArrayList);
        binding.myOrder.setAdapter(orderApdapter);
    }
}