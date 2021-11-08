package com.example.fastfoodapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fastfoodapp.R;
import com.google.android.material.textfield.TextInputEditText;

public class Signin extends AppCompatActivity {
    TextView btnSignup;
    TextView btnSignin,passBtn;
    EditText txtEmaillLogin;
    EditText txtPassLogin;
    public Integer isPass=1;
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
        passBtn=(TextView) findViewById(R.id.passBtn);
        passBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isPass==1){
                    txtPassLogin.setInputType(InputType.TYPE_CLASS_TEXT);
                    isPass=0;

                }
                else
                {
                    txtPassLogin.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    isPass=1;
                }
            }
        });
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtEmail=txtEmaillLogin.getText().toString();
                String txtPassword=txtPassLogin.getText().toString();
//                if(txtEmail.equals("admin@gmail.com")  && txtPassword.equals("admin"))
//                {
//                    startActivity(new Intent(Signin.this, Home.class));
//                }
//                else{
//                    Toast.makeText(Signin.this, "Email or Password is incorrect!", Toast.LENGTH_SHORT).show();
//                }
                Intent intent =new Intent(Signin.this,Home.class);
                startActivity(intent);
            }
        });



    }
}