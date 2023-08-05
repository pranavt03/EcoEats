package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ResponseActivity extends Activity {

    public static final String EXTRA_API_RESPONSE = "extra_api_response";

    private TextView tvResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);

        tvResponse = findViewById(R.id.tvResponse);

        // Get the API response from the intent
        String apiResponse = getIntent().getStringExtra(EXTRA_API_RESPONSE);

        // Update the TextView with the API response
        if (apiResponse != null) {
            tvResponse.setText(apiResponse);
        }
    }
}