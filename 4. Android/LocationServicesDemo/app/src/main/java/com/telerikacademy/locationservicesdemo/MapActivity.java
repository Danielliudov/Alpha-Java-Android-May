package com.telerikacademy.locationservicesdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity {

    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Intent intent = getIntent();
        LatLng coordinates = new LatLng(
                intent.getDoubleExtra("lat", 0.0),
                intent.getDoubleExtra("lng", 0.0));

        try {
            initializeMap(coordinates);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void initializeMap(LatLng coordinates) {
        if (googleMap == null) {
            ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
                    .getMapAsync(googleMap1 -> {
                        googleMap = googleMap1;
                        if (googleMap == null) {
                            Toast.makeText(getApplicationContext(),
                                    "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                                    .show();
                        } else {
                            MarkerOptions marker = new MarkerOptions().position(coordinates).title("Your current location");
                            googleMap.addMarker(marker);

                            CameraPosition cameraPosition = new CameraPosition.Builder().target(
                                    coordinates).zoom(6).build();

                            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                        }
                    });
        }
    }
}
