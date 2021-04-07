package com.example.protomap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class BikeDetails extends AppCompatActivity {

    TextView markertxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike_details);
        markertxt = findViewById(R.id.marker);

        String title = getIntent().getStringExtra("title");
        markertxt.setText(title);
    }
}