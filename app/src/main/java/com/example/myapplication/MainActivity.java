package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button but1 = (Button)findViewById(R.id.txtScan);
        Button but2 = (Button)findViewById(R.id.txtManually);
        Button but3 = (Button)findViewById(R.id.txtHistory);
        Button but4 = (Button)findViewById(R.id.txtRestrictions);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(MainActivity.this, Scan.class);
                startActivity(int1);
            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent int2 = new Intent(MainActivity.this, ManuallySelect.class);
                startActivity(int2);
            }
        });
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                Intent int3 = new Intent(getApplicationContext(), past_history.class);
                startActivity(int3);
            }
        });
        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v3) {
                Intent int4 = new Intent(MainActivity.this, DietaryRestrictions.class);
                startActivity(int4);
            }
        });
    }
}





