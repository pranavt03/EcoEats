package com.pranavtayi.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class DisplayResponseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_response);

        // Get the API response data from the intent
        String responseData = getIntent().getStringExtra("responseData");

        // Set the API response data to a TextView in the layout
        TextView responseTextView = findViewById(R.id.responseTextView);
        responseTextView.setText(responseData);
    }
}