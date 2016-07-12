package com.aad.ar.as.hawkeye;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aad.ar.as.hawkeye.models.Information;

import java.util.ArrayList;

/**
 * Created by cirmac3 on 7/11/16.
 */
public class MyFragment extends Fragment {
    public static final String ARG_PAGE = "arg_page";

    // DUMMY DATA LATER NEED TO REPLACED WITH ORIGINAL DATA
    String[] name = {"Arvind Kejriwal", "Narendra Modi", "Mahesh Bhupati", "Sachin Tendulkar", "Saina Nehwal"};
    String[] distance = {"5KM", "50KM", "100KM", "190KM", "5000KM"};
    String[] address = {"Delhi, 200 E Plot Govt. Marg", "Mumbai, east navi mumbai, thane", "Karnataka, Plot 544, second floor",
            "Mumbai, dadar central BT, Banglow 200", "Chandigarh, Plot no 765 Lane No 4, Swiss palace"};

    static LinearLayoutManager layoutManager;

    public MyFragment() {

    }

    public static MyFragment newInstance(int pageNumber) {
        MyFragment myFragment = new MyFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARG_PAGE, pageNumber + 1);
        myFragment.setArguments(arguments);
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        int pageNumber = arguments.getInt(ARG_PAGE);

        ArrayList<Information> infoList=null;

        HawkEyeApplication appContext = (HawkEyeApplication) getActivity().getApplicationContext();
        for (byte b = 0; b < name.length && b < distance.length && b < address.length; b++) {
            appContext.addInfoDetails(new Information(name[b], address[b], distance[b]));
        }

        if(appContext.getInformationListSize()>0)
        {
            infoList=appContext.getInformationList();
        }

        RecyclerView recyclerView = new RecyclerView(getActivity());
        recyclerView.setAdapter(new HomeRecyclerView(getActivity(), infoList));
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return recyclerView;
    }

    public static void setZeroPosition() {
        layoutManager.scrollToPositionWithOffset(0, 10);

    }

}
