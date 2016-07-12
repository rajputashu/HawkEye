package com.aad.ar.as.hawkeye;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.aad.ar.as.hawkeye.HawkEyeMap.HawkGoogleMap;
import com.aad.ar.as.hawkeye.adapters.HomePagerAdapter;
import com.aad.ar.as.hawkeye.models.Information;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by cirmac3 on 7/11/16.
 */
public class HomeScreenNew extends AppCompatActivity implements OnMapReadyCallback,HomeRecyclerView.HomeItemClickListener
{
    private GoogleMap mMap;
    // Need this to link with the Snackbar
//    private CoordinatorLayout mCoordinator;
    //Need this to set the title of the app bar
//    private CollapsingToolbarLayout mCollapsingToolbarLayout;
//    private FloatingActionButton mFab;
//    private Toolbar mToolbar;

    private HomePagerAdapter mAdapter;
    private ViewPager mPager;


//        COMMENTING AS PER AAD
//    private DrawerLayout mDrawerLayout;
//    private ActionBarDrawerToggle mDrawerToggle;
//    private YourPagerAdapter mAdapter;
//    private TabLayout mTabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen_new);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mAdapter = new HomePagerAdapter(getSupportFragmentManager());
        mPager = (ViewPager) findViewById(R.id.view_pager);
        mPager.setAdapter(mAdapter);

        /*mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Notice how the Coordinator Layout object is used here
                Snackbar.make(mCoordinator, "FAB Clicked", Snackbar.LENGTH_SHORT).setAction("DISMISS", null).show();
            }
        });*/

        //Notice how the title is set on the Collapsing Toolbar Layout instead of the Toolbar
//        mCollapsingToolbarLayout.setTitle(getResources().getString(R.string.app_name));





    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(sydney, 13);
//        mMap.animateCamera(cameraUpdate);

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @Override
            public void onMapClick(LatLng arg0) {
                // TODO Auto-generated method stub
//                Log.d("arg0", arg0.latitude + "-" + arg0.longitude);
                startActivity(new Intent(HomeScreenNew.this, HawkGoogleMap.class));
            }
        });

    }


    @Override
    public void onHomeListItemClick(int position) {

        Log.e("HawkLog", "ClickEvent " + position);

    }
}