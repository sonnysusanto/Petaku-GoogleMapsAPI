package com.sonnysusanto.android.latihangmaps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MapMove extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap m_map;
    boolean mapReady = false;

    static final CameraPosition JAKARTA = CameraPosition.builder().target(new LatLng(-6.179254, 106.8252976)).zoom(17)
            .bearing(0).tilt(45).build();

    static final CameraPosition SURABAYA = CameraPosition.builder().target(new LatLng(-7.2458943, 112.735592)).zoom(17)
            .bearing(90).tilt(45).build();

    static final CameraPosition BANDUNG = CameraPosition.builder().target(new LatLng(-6.9025157, 107.6165933)).zoom(17)
            .bearing(90).tilt(45).build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_move);

        Button btnJakarta = (Button) findViewById(R.id.btnJakarta);
        btnJakarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(JAKARTA);
            }
        });

        Button btnSurabaya = (Button) findViewById(R.id.btnSurabaya);
        btnSurabaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(SURABAYA);
            }
        });

        //Develop by sonny.susanto@gmail.com
        Button btnBandung = (Button) findViewById(R.id.btnBandung);
        btnBandung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(BANDUNG);
            }
        });

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapMove);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mapReady = true;
        m_map = map;
        m_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        flyTo(JAKARTA);
    }

    private void flyTo(CameraPosition target) {
        m_map.animateCamera(CameraUpdateFactory.newCameraPosition(target), 10000, null);

    }
}
