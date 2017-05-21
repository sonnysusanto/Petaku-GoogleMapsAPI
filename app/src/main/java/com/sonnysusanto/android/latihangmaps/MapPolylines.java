package com.sonnysusanto.android.latihangmaps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapPolylines extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap m_map;
    boolean mapReady = false;
    LatLng bppt = new LatLng(-6.193555, 106.7523363);
    LatLng tmii = new LatLng(-6.3024459, 106.8929672);
    LatLng dufan = new LatLng(-6.1237748, 106.8296171);
    LatLng soeta = new LatLng(-6.1377913, 106.6598478);
    LatLng pancoran = new LatLng(-6.2441296, 106.8383475);
    static final CameraPosition MONAS = CameraPosition.builder()
            .target(new LatLng(-6.179254, 106.8252976))
            .zoom(10)
            .bearing(0)
            .tilt(45)
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_polylines);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapPolylines);
        mapFragment.getMapAsync(this);
    }

    //Develop sonny.susanto@gmail.com
    @Override
    public void onMapReady(GoogleMap map) {
        map.moveCamera(CameraUpdateFactory.newCameraPosition(MONAS));
        map.addPolyline(new PolylineOptions().geodesic(true)
                .add(bppt)
                .add(tmii)
                .add(dufan)
                .add(soeta)
                .add(pancoran)
                .add(bppt));
    }
}
