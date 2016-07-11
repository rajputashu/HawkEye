package com.aad.ar.as.hawkeye;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by cirmac3 on 7/11/16.
 */
public class MyFragment extends Fragment {
    public static final String ARG_PAGE = "arg_page";
//    static RecyclerView recyclerView ;
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
        RecyclerView recyclerView = new RecyclerView(getActivity());
        recyclerView.setAdapter(new HomeRecyclerView(getActivity()));
        layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return recyclerView;
    }

    public static void setZeroPosition()
    {
        layoutManager.scrollToPositionWithOffset(0,10);

    }

}
