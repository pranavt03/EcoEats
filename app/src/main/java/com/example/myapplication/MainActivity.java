package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button but1 = (Button)findViewById(R.id.txtScan);
        Button but2 = (Button)findViewById(R.id.txtManually);
        Button but3 = (Button)findViewById(R.id.txtHistory);
        Button but4 = (Button)findViewById(R.id.txtRestrictions);
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
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                Intent int3 = new Intent(MainActivity.this, past_history.class);
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
        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v3) {
                Intent int4 = new Intent(MainActivity.this, AboutUs.class);
                startActivity(int4);
            }
        });
    }
}





