package com.pranavtayi.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.us_about);

        Button openEmailButton = findViewById(R.id.openEmailButton);
        openEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to start the EmailActivity
                Intent intent = new Intent(AboutUs.this, EmailActivity.class);
                startActivity(intent);
            }
        });
    }
}
