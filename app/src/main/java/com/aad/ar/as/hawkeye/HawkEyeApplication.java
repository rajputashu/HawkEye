package com.aad.ar.as.hawkeye;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.aad.ar.as.hawkeye.models.Information;

import java.util.ArrayList;

/**
 * Created by HP on 09-07-2016.
 */
public class HawkEyeApplication extends Application
{
    private static SharedPreferences sharedPreferences;
    private ArrayList<Information> informationArrayList=new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        createPreference();
    }

    private void createPreference()
    {
        sharedPreferences=getSharedPreferences("HawkEyeFile", Context.MODE_PRIVATE);
    }

    public static SharedPreferences getHawkEyePreference()
    {
        return sharedPreferences;
    }

    // USING BELOW TO RETRIEVE ALL THE INFORMATION OBJECTS FROM THE LIST
    public ArrayList<Information> getInformationList()
    {
        return informationArrayList;
    }

    // USING BELOW METHOD TO INSERT INFORMATION CLASS OBJECTS IN ARRAY LIST
    public void addInfoDetails(Information information)
    {
        informationArrayList.add(information);
    }

    // USING BELOW METHOD TO GET THE SIZE OF THE ARRAY LIST
    public int getInformationListSize()
    {
        return informationArrayList.size();
    }


}
