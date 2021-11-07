package com.example.fastfoodapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fastfoodapp.R;

public class Signin extends AppCompatActivity {
    TextView btnSignup;
    TextView btnSignin;
    EditText txtEmaillLogin;
    EditText txtPassLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        btnSignup=(TextView) findViewById(R.id.btnSignup);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Signin.this, SignUp.class));
            }
        });

        btnSignin=(TextView) findViewById(R.id.Signin);
        txtEmaillLogin=(EditText) findViewById(R.id.txtEmaillLogin);
        txtPassLogin=(EditText) findViewById(R.id.txtPassLogin);
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtEmail=txtEmaillLogin.getText().toString();
                String txtPassword=txtPassLogin.getText().toString();
                if(txtEmail.equals("admin@gmail.com")  && txtPassword.equals("admin"))
                {
                    startActivity(new Intent(Signin.this, Home.class));
                }
                else{
                    Toast.makeText(Signin.this, "Email or Password is incorrect!", Toast.LENGTH_SHORT).show();
                }
//                Intent intent =new Intent(Signin.this,Home.class);
//                startActivity(intent);
            }
        });



    }
}