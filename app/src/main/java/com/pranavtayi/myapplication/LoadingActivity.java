package com.pranavtayi.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        // Simulate loading time with a delay
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the DisplayResponseActivity
                Intent intent = new Intent(LoadingActivity.this, DisplayResponseActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000); // Delay of 2 seconds (adjust as needed)
    }
}
