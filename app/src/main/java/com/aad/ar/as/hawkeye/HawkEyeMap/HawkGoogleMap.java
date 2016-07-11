package com.aad.ar.as.hawkeye.HawkEyeMap;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.aad.ar.as.hawkeye.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

/**
 * Created by HP on 09-07-2016.
 */
public class HawkGoogleMap extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Circle circle;
    ArrayList<LatLng> latlongList=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hawk_eye_map);

        latlongList=new ArrayList<>();

        latlongList.add(new LatLng(28.7439642, 77.096008));
        latlongList.add(new LatLng(28.7429500, 77.106050));
        latlongList.add(new LatLng(28.7419450, 77.110100));
        latlongList.add(new LatLng(28.7409400, 77.096120));
        latlongList.add(new LatLng(28.7399380, 77.096130));

        latlongList.add(new LatLng(28.7123646,77.1343239));
        latlongList.add(new LatLng(28.6598923, 77.124355));
        latlongList.add(new LatLng(28.5587878, 77.0098748));
        latlongList.add(new LatLng(28.4686868,77.1284848));

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        for(int i=0;i<latlongList.size();i++)
        {
            mMap.addMarker(new MarkerOptions().position(latlongList.get(i)).title("Marker " +i));
        }
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latlongList.get(0), 14);
        mMap.animateCamera(cameraUpdate);

        /*LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(sydney, 13);
        mMap.animateCamera(cameraUpdate);*/

        double radiusInMeters = 1000.0;
        //red outline
        int strokeColor = 0xffff0000;
        //opaque red fill
        int shadeColor = 0x44ff0000;


       /* CircleOptions circleOptions = new CircleOptions().center(sydney).radius(radiusInMeters).
                fillColor(shadeColor).strokeColor(strokeColor).strokeWidth(2);
        mMap.addCircle(circleOptions);*/

        mMap.addCircle(new CircleOptions()
                .center(latlongList.get(0))
                .radius(1000)
                .strokeWidth(10)
                .strokeColor(Color.GREEN)
                .fillColor(Color.argb(128, 255, 0, 0)));

       /* mMap.setOnCircleClickListener(new OnCircleClickListener() {

            @Override
            public void onCircleClick(Circle circle) {
                // Flip the r, g and b components of the circle's
                // stroke color.
                int strokeColor = circle.getStrokeColor() ^ 0x00ffffff;
                circle.setStrokeColor(strokeColor);
            }
        });*/


    }
}
