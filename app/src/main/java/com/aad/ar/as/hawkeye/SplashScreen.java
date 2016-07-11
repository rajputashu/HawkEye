package com.aad.ar.as.hawkeye;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Space;

import com.aad.ar.as.hawkeye.HawkEyeMap.HawkGoogleMap;
import com.aad.ar.as.hawkeye.introduction.IntroScreen;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        Handler h=new Handler();
        h.postDelayed(new Runnable() {

            @Override
            public void run() {

                if(HawkEyeApplication.getHawkEyePreference().getBoolean("IS_INTRO_COMPLETE", false))
                    startActivity(new Intent(SplashScreen.this,HomeScreenNew.class));
//                    startActivity(new Intent(SplashScreen.this,HawkGoogleMap.class));
                else
                    startActivity(new Intent(SplashScreen.this,IntroScreen.class));

                SplashScreen.this.finish();

            }
        }, 3000);

    }
}
