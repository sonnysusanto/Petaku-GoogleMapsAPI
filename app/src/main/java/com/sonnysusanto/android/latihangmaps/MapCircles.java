package com.sonnysusanto.android.latihangmaps;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;

public class MapCircles extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap m_map;
    boolean mapReady = false;
    LatLng tmii = new LatLng(-6.3024459, 106.8929672);

    static final CameraPosition MONAS = CameraPosition.builder()
            .target(new LatLng(-6.179254, 106.8252976))
            .zoom(10)
            .bearing(0)
            .tilt(45)
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_circles);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapCircles);
        mapFragment.getMapAsync(this);
    }

    //Develop by sonny.susanto@gmail.com
    @Override
    public void onMapReady(GoogleMap map) {
        mapReady = true;
        map.moveCamera(CameraUpdateFactory.newCameraPosition(MONAS));
        map.addCircle(new CircleOptions()
                .center(tmii)
                .radius(5000)
                .strokeColor(Color.GREEN)
                .fillColor(Color.argb(64, 0, 255, 0)));
    }
}
