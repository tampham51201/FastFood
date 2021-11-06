package com.example.fastfoodapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.fastfoodapp.R;

public class MainActivity extends AppCompatActivity {
    private Handler handler;
    private Runnable myRunnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler handler =  new Handler();

        Runnable myRunnable = new Runnable() {
            public void run() {
                startActivity(new Intent(MainActivity.this, Signin.class));
            }
        };
        handler.postDelayed(myRunnable,3000);

    }
}