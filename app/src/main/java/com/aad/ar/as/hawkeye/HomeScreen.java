package com.aad.ar.as.hawkeye;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aad.ar.as.hawkeye.HawkEyeMap.HawkGoogleMap;
import com.aad.ar.as.hawkeye.adapters.HomePagerAdapter;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

/**
 * Created by HP on 09-07-2016.
 */
public class HomeScreen extends AppCompatActivity implements OnMapReadyCallback,HomeRecyclerView.HomeItemClickListener
{
    private GoogleMap mMap;
    // Need this to link with the Snackbar
    private CoordinatorLayout mCoordinator;
    //Need this to set the title of the app bar
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private FloatingActionButton mFab;
    private Toolbar mToolbar;

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
        setContentView(R.layout.homescreen);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mCoordinator = (CoordinatorLayout) findViewById(R.id.root_coordinator);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mToolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(mToolbar);

//        MyFragment myFragment=new MyFragment().newInstance(position);
        
        
//        COMMENTING AS PER AAD
        /*mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mAdapter = new YourPagerAdapter(getSupportFragmentManager());
        mPager = (ViewPager) findViewById(R.id.view_pager);
        mPager.setAdapter(mAdapter);

        //Notice how the Tab Layout links with the Pager Adapter

        mTabLayout.setTabsFromPagerAdapter(mAdapter);

        //Notice how The Tab Layout adn View Pager object are linked
        mTabLayout.setupWithViewPager(mPager);
        mPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));*/


        mAdapter = new HomePagerAdapter(getSupportFragmentManager());
        mPager = (ViewPager) findViewById(R.id.view_pager);
        mPager.setAdapter(mAdapter);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Notice how the Coordinator Layout object is used here
                Snackbar.make(mCoordinator, "FAB Clicked", Snackbar.LENGTH_SHORT).setAction("DISMISS", null).show();
            }
        });

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
                startActivity(new Intent(HomeScreen.this, HawkGoogleMap.class));
            }
        });

    }


    @Override
    public void onHomeListItemClick(int position) {

        Log.e("HawkLog","ClickEvent "+position);


        mCoordinator.setFocusable(true);
//        MyFragment.setZeroPosition();

    }
}