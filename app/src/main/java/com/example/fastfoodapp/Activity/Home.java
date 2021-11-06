package com.example.fastfoodapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fastfoodapp.Adapter.PopularAdapter;
import com.example.fastfoodapp.Adapter.VPAdapter;
import com.example.fastfoodapp.Object.MonAn;
import com.example.fastfoodapp.R;
import com.example.fastfoodapp.databinding.ActivityHomeBinding;
import com.example.fastfoodapp.tabHome.Breakfast;
import com.example.fastfoodapp.tabHome.Dinner;
import com.example.fastfoodapp.tabHome.Lunch;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    ActivityHomeBinding binding;

    private TabLayout tabLayout;
    private ViewPager viewPager;

    TextView myCart;
    RelativeLayout btnProfile,btnHistory,btnProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        cainaylaViewPager();
        cainaylaNut();
        CainaylaListView();

    }

    private void CainaylaListView() {

        String[] ten ={"Bánh mì kẹp","Bánh pizza","Bánh donut"};
        int[] hinh ={R.drawable.burger3,R.drawable.pizza,R.drawable.donut1};
        String[] calo ={"200","200","200"};
        Double[] sao = {4.9,4.9,4.9};
        String[] size= {"S","S","S"};
        String[] gia = {"150.000đ","150.000đ","150.000đ"};
        String[] tong= {"0đ","0đ","0đ"};
        String[] Mota={"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus.",
                "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus.",
                "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus."};

        int[] anhMot ={R.drawable.dualeo,R.drawable.dualeo,R.drawable.dualeo};
        int[] anhHai={R.drawable.cachua,R.drawable.cachua,R.drawable.cachua};
        int[] anhBa={R.drawable.thitbo,R.drawable.thitbo,R.drawable.thitbo};
        int[] anhBon={R.drawable.xalach,R.drawable.xalach,R.drawable.xalach};
        String[] ingredient={"hoa","la","canh"};
        int[] quantity={1,3,2};

        ArrayList<MonAn> monAnArrayList =new ArrayList<>();

        for (int i=0;i<hinh.length;i++){
            MonAn monAn = new MonAn(ten[i],hinh[i],calo[i],sao[i],size[i],gia[i],tong[i],Mota[i],ingredient[i],anhMot[i],anhHai[i],anhBa[i],anhBon[i],quantity[i]);
            monAnArrayList.add(monAn);
        }
        PopularAdapter popularAdapter =new PopularAdapter(Home.this,monAnArrayList) ;
        binding.listViewHome.setAdapter(popularAdapter);

        binding.listViewHome.setClickable(true);
        binding.listViewHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Home.this,ShowDetail.class);
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

    private void cainaylaViewPager() {

        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewPage);
        tabLayout.setupWithViewPager(viewPager);
        VPAdapter vpAdapter=new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new Breakfast(),"Bữa sáng");
        vpAdapter.addFragment(new Lunch(),"Bữa trưa");
        vpAdapter.addFragment(new Dinner(),"Bữa tối");
        viewPager.setAdapter(vpAdapter);

    }

    private void cainaylaNut() {

        myCart=(TextView) findViewById(R.id.myCart);
        myCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, MyCart.class));
            }
        });

        btnProfile=(RelativeLayout) findViewById(R.id.btnProfile1);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Profile.class));
            }
        });

        btnProduct=(RelativeLayout) findViewById(R.id.btnProduct);
        btnProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, ListProduct.class));
            }
        });

        btnHistory=(RelativeLayout) findViewById(R.id.btnHistory);
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, History.class));
            }
        });
    }


}