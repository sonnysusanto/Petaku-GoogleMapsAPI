package com.sonnysusanto.android.latihangmaps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
    }

    public void buttonMapFragment(View view) {
        Intent i = new Intent(this, MapFragment.class);
        startActivity(i);
    }

    public void buttonMapType(View view) {
        Intent i = new Intent(this, MapType.class);
        startActivity(i);
    }

    public void buttonMapMove(View view) {
        Intent i = new Intent(this, MapMove.class);
        startActivity(i);
    }

    public void buttonMapMarker(View view) {
        Intent i = new Intent(this, MapMarker.class);
        startActivity(i);
    }

    public void buttonMapPolylines(View view) {
        Intent i = new Intent(this, MapPolylines.class);
        startActivity(i);
    }

    public void buttonMapCircles(View view) {
        Intent i = new Intent(this, MapCircles.class);
        startActivity(i);
    }

    public void buttonMapStreetView(View view) {
        Intent i = new Intent(this, MapStreetView.class);
        startActivity(i);
    }
}
