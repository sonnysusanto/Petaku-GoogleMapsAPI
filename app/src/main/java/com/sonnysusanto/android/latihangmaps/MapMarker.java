package com.sonnysusanto.android.latihangmaps;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapMarker extends AppCompatActivity implements OnMapReadyCallback{
    GoogleMap m_map;
    boolean mapReady=false;

    MarkerOptions bppt;
    MarkerOptions tmii;
    MarkerOptions dufan;

    static final CameraPosition JAKARTA = CameraPosition.builder()
            .target(new LatLng(-6.179254,106.8252976))
            .zoom(10)
            .bearing(0)
            .tilt(45)
            .build();

    @Override
    public Resources getResources() {
        return super.getResources();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_marker);

        bppt = new MarkerOptions()
                .position(new LatLng(-6.193555, 106.7523363))
                .title("BPPT")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.sonny));

        tmii = new MarkerOptions()
                .position(new LatLng(-6.3024459, 106.8929672))
                .title("TMII");

        //Develop sonny.susanto@gmail.com
        dufan = new MarkerOptions()
                .position(new LatLng(-6.1237748,106.8296171))
                .title("DUFAN")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.dufan));

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapMarker);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap map){
        //MapsInitializer.initialize(getApplicationContext());
        mapReady=true;
        m_map = map;
        m_map.addMarker(bppt);
        m_map.addMarker(tmii);
        m_map.addMarker(dufan);
        flyTo(JAKARTA);
    }

    private void flyTo(CameraPosition target)
    {
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}
