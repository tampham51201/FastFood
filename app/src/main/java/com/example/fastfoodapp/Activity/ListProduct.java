package com.example.fastfoodapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.fastfoodapp.Adapter.MonAnListAdapter;
import com.example.fastfoodapp.Object.MonAn;
import com.example.fastfoodapp.R;
import com.example.fastfoodapp.databinding.ActivityListProductBinding;

import java.util.ArrayList;

public class ListProduct extends AppCompatActivity {

    ActivityListProductBinding binding;

    TextView btnBackList;
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        cainaylaNut();

        String[] ten ={"Bánh mì kẹp","Gà rán","Bánh mì","Khoai tây","Xúc xích","Bánh pizza", "Bánh donut","Bánh sandwich","Combo"};
        int[] hinh = {R.drawable.buger,R.drawable.ga,R.drawable.hotdog,R.drawable.chip,R.drawable.xucxich,R.drawable.pizza1,
                R.drawable.donut,R.drawable.sw,R.drawable.combo};
        String[] calo ={"250","400","300","220","200","160","150","150","220"};
        String[] size= {"S","M","L","S","XXL","S","M","S","L"};
        String[] gia= {"50.000đ","50.000đ","50.000đ","50.000đ","50.000đ","50.000đ","50.000đ","50.000đ","50.000đ"};
        String[] tong= {"0đ","0đ","0đ","0đ","0đ","0đ","0đ","0đ","0đ"};
        Double[] sao={4.6,4.6,4.6,4.6,4.6,4.6,4.6,4.6,4.6};
        String[] Mota={"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus.",
                "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus.",
                "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus.",
                "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus.",
                "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus.",
                "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus.",
                "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus.",
                "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus.",
                "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus."};
        int[] anhMot={R.drawable.dualeo,R.drawable.dualeo,R.drawable.dualeo,R.drawable.dualeo,R.drawable.dualeo,R.drawable.dualeo,R.drawable.dualeo,R.drawable.dualeo,R.drawable.dualeo};
        int[] anhHai={R.drawable.cachua,R.drawable.cachua,R.drawable.cachua,R.drawable.cachua,R.drawable.cachua,R.drawable.cachua,R.drawable.cachua,R.drawable.cachua,R.drawable.cachua};
        int[] anhBa={R.drawable.thitbo,R.drawable.thitbo,R.drawable.thitbo,R.drawable.thitbo,R.drawable.thitbo,R.drawable.thitbo,R.drawable.thitbo,R.drawable.thitbo,R.drawable.thitbo};
        int[] anhBon={R.drawable.xalach,R.drawable.xalach,R.drawable.xalach,R.drawable.xalach,R.drawable.xalach,R.drawable.xalach,R.drawable.xalach,R.drawable.xalach,R.drawable.xalach};
        String[] ingredient={"hoa","la","canh","hoa","la","canh","hoa","la","canh"};
        int[] quantity={1,3,2,7,8,0,1,3,6};



        ArrayList<MonAn> monAnArrayList = new ArrayList<>();

        for(int i=0;i<hinh.length;i++){

            MonAn monAn = new MonAn(ten[i],hinh[i],calo[i],sao[i],size[i],gia[i],tong[i],Mota[i],ingredient[i],anhMot[i],anhHai[i],anhBa[i],anhBon[i],quantity[i]);
            monAnArrayList.add(monAn);
        }

        MonAnListAdapter monAnListAdapter = new MonAnListAdapter(ListProduct.this,monAnArrayList);

        binding.lvmonan.setAdapter(monAnListAdapter);

        binding.lvmonan.setClickable(true);
        binding.lvmonan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent =new Intent(ListProduct.this,ShowDetail.class);
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

    private void cainaylaNut() {
        btnBackList=(TextView) findViewById(R.id.btnBackList);
        btnBackList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListProduct.this, Home.class));
            }
        });
        cardView=(CardView) findViewById(R.id.cardView);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListProduct.this, MyCart.class));
            }
        });
    }
}