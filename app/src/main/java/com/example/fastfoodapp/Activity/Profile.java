package com.example.fastfoodapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fastfoodapp.R;

public class Profile extends AppCompatActivity {
    TextView back;
    RelativeLayout btnHome;
    RelativeLayout btnProduct,btnHistory;
    Button edit,btnSignOut;
    EditText name,birth,phone,facebook,password;

    boolean isEdit=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        edit=(Button) findViewById(R.id.edit);
        btnSignOut=(Button) findViewById(R.id.btnSignOut);
        name=(EditText) findViewById(R.id.name);
        birth=(EditText) findViewById(R.id.birth);
        phone=(EditText) findViewById(R.id.phone);
        facebook=(EditText) findViewById(R.id.facebook);
        password=(EditText) findViewById(R.id.password);



        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isEdit)
                {

//                    phone.getFocusable();
//                    phone.setFocusable(true);
//                    facebook.setFocusable(true);
//                    password.setFocusable(true);
                    isEdit=true;

                    edit.setText("Lưu");

                }
                else
                {
//                    name.setFocusable(false);
//                    birth.setFocusable(true);
//                    phone.setFocusable(true);
//                    facebook.setFocusable(true);
//                    password.setFocusable(true);
                    isEdit=false;
                    edit.setText("Chỉnh Sửa");
                }

            }
        });

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Profile.this, Signin.class));
            }
        });


        back=(TextView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Profile.this, Home.class));
            }
        });

        btnHome=(RelativeLayout) findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Profile.this, Home.class));
            }
        });

        btnProduct=(RelativeLayout) findViewById(R.id.btnProduct);
        btnProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Profile.this, ListProduct.class));
            }
        });

        btnHistory=(RelativeLayout) findViewById(R.id.btnHistory);
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Profile.this, History.class));
            }
        });
    }
}