package com.aad.ar.as.hawkeye;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by HP on 09-07-2016.
 */
public class HawkEyeApplication extends Application
{
    private static SharedPreferences sharedPreferences;

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

}
