package com.example.foodpoint;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;


public class MainActivity extends AppCompatActivity {

    LottieAnimationView lottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lottie=findViewById(R.id.lottie);

        getSupportActionBar().hide();
        Window window=getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.mycolor1));

        lottie.animate();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                    Intent in= new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(in);
                    finish();
            }
        },5000);

    }
}