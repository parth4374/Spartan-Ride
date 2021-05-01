package com.csc490.spartanride;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.*;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng campus = new LatLng(36.0689, 79.8102);
        LatLng bike1 = new LatLng(36.069209, -79.809953);
        LatLng bike2 = new LatLng(36.068012, -79.809804);
        LatLng bike3 = new LatLng(36.065975, -79.811569);
        mMap.addMarker(new MarkerOptions().position(bike1).title("Bike 1"));
        mMap.addMarker(new MarkerOptions().position(bike2).title("Bike 2"));
        mMap.addMarker(new MarkerOptions().position(bike3).title("Bike 3"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bike1, 16.0f));

        // Create a LatLngBounds that includes the UNCG campus.
        LatLngBounds campusBounds = new LatLngBounds(
                new LatLng(36.064545, -79.815189), // SW bounds
                new LatLng(36.072995, -79.804083)  // NE bounds
        );

        // Constrain the camera to the UNCG bounds.
        googleMap.setLatLngBoundsForCameraTarget(campusBounds);

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String markerTitle = marker.getTitle();
                Intent i = new Intent(MapsActivity.this, BikeDetails.class);
                i.putExtra("title", markerTitle);
                startActivity(i);

                return false;
            }
        });
    }
}