package com.example.fastfoodapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fastfoodapp.Adapter.LichSuApdapter;
import com.example.fastfoodapp.Object.LichSu;
import com.example.fastfoodapp.Object.MonAn;
import com.example.fastfoodapp.R;
import com.example.fastfoodapp.databinding.ActivityHistoryBinding;

import java.util.ArrayList;

public class History extends AppCompatActivity {

    ActivityHistoryBinding binding;

    RelativeLayout btnProfile,btnProduct,btnHome;
    TextView btnBackList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHistoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        CainaylaNut();

        String[] ten ={"Bánh Donut","Bánh sandwich","Xúc xích"};
        String[] thoigian = {"5/11/2021","5/11/2021","5/11/2021"};
        int[] hinh = {R.drawable.donut,R.drawable.sw,R.drawable.xucxich};
        String[] Mota={"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus.",
                "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus.",
                "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus."};
        String[] gia= {"50.000đ","50.000đ","50.000đ"};
        String[] calo ={"200","200","200"};
        Double[] sao={4.6,4.6,4.6};
        String[] tong= {"0đ","0đ","0đ"};
        String[] ingradient={"1 phần tương cà, nhiều khoai tây","1 phần tương cà, nhiều khoai tây","1 phần tương cà, nhiều khoai tây"};
        String[] size= {"S","S","S"};
        int[] anhMot={R.drawable.dualeo,R.drawable.dualeo,R.drawable.dualeo};
        int[] anhHai={R.drawable.cachua,R.drawable.cachua,R.drawable.cachua};
        int[] anhBa={R.drawable.thitbo,R.drawable.thitbo,R.drawable.thitbo};
        int[] anhBon={R.drawable.xalach,R.drawable.xalach,R.drawable.xalach};

        ArrayList<LichSu> lichSuArrayList = new ArrayList<>();
        for(int i=0;i<hinh.length;i++){

            LichSu lichSu = new LichSu(ten[i],thoigian[i],hinh[i],Mota[i],gia[i],calo[i],sao[i],size[i],ingradient[i],tong[i],anhMot[i],anhHai[i],anhBa[i],anhBon[i]);
            lichSuArrayList.add(lichSu);
        }
        LichSuApdapter lichSuApdapter = new LichSuApdapter(History.this,lichSuArrayList);
        binding.listviewLichSu.setAdapter(lichSuApdapter);

        binding.listviewLichSu.setClickable(true);
        binding.listviewLichSu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent =new Intent(History.this,ShowDetail.class);
                intent.putExtra("ten",ten[i]);
                intent.putExtra("hinh",hinh[i]);
                intent.putExtra("calo",calo[i]);
                intent.putExtra("sao",sao[i]);
                intent.putExtra("size",size[i]);
                intent.putExtra("gia",gia[i]);
                intent.putExtra("tong",tong[i]);
                intent.putExtra("ngaythang",thoigian[i]);
                intent.putExtra("ingredient",ingradient[i]);
                intent.putExtra("Mota",Mota[i]);
                intent.putExtra("anhMot",anhMot[i]);
                intent.putExtra("anhHai",anhHai[i]);
                intent.putExtra("anhBa",anhBa[i]);
                intent.putExtra("anhBon",anhBon[i]);

                startActivity(intent);
            }
        });

    }

    private void CainaylaNut() {

        btnBackList=(TextView) findViewById(R.id.btnBackList);
        btnBackList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(History.this, Home.class));
            }
        });

        btnHome=(RelativeLayout) findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(History.this, Home.class));
            }
        });

        btnProfile=(RelativeLayout) findViewById(R.id.btnProfile1);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(History.this, Profile.class));
            }
        });

        btnProduct=(RelativeLayout) findViewById(R.id.btnProduct);
        btnProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(History.this, ListProduct.class));
            }
        });
    }


}