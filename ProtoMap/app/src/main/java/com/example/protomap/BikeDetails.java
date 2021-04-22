package com.example.protomap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.SharedPreferences;

import org.w3c.dom.Text;

public class BikeDetails extends AppCompatActivity {

    TextView markertxt;
    TextView availability;
    Button rentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike_details);
        markertxt = findViewById(R.id.marker);

        String title = getIntent().getStringExtra("title");
        markertxt.setText(title);
        availability = (TextView)findViewById(R.id.availability);

        rentButton = (Button)findViewById(R.id.rentButton);
        rentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                availability.setTextColor(Color.RED);
                availability.setText("Unavailable");
            }
        });
    }
}