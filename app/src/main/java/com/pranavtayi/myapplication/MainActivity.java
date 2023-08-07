package com.pranavtayi.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button but1 = (Button)findViewById(R.id.txtScan);
        Button but2 = (Button)findViewById(R.id.txtManually);
        Button but5 = (Button)findViewById(R.id.txtAboutUs);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(MainActivity.this, Scan.class);
                startActivity(int2);
            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent int2 = new Intent(MainActivity.this, ManuallySelect.class);
                startActivity(int2);
            }
        });
        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v3) {
                Intent int4 = new Intent(MainActivity.this, AboutUs.class);
                startActivity(int4);
            }
        });
    }
}





