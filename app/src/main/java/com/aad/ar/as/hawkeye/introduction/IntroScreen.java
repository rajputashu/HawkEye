package com.aad.ar.as.hawkeye.introduction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.aad.ar.as.hawkeye.HawkEyeApplication;
import com.aad.ar.as.hawkeye.HomeScreen;
import com.aad.ar.as.hawkeye.HomeScreenNew;
import com.aad.ar.as.hawkeye.R;
import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntroFragment;

/**
 * Created by cirmac3 on 7/8/16.
 * USE this
 * https://android-arsenal.com/details/1/3206
 *
 */
public class IntroScreen extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Add your slide's fragments here.
        // AppIntro will automatically generate the dots indicator and buttons.

       /* addSlide(first_fragment);
        addSlide(second_fragment);
        addSlide(third_fragment);
        addSlide(fourth_fragment);*/


        // custom fragment
//        addSlide(IntroFragment.newInstance(R.layout.your_slide_here));


        // Instead of fragments, you can also use our default slide
        // Just set a title, description, background and image. AppIntro will do the rest.
        addSlide(AppIntroFragment.newInstance("Screen 1", "Medical", R.drawable.hawk_logo, getResources().getColor(R.color.colorAccent)));
        addSlide(AppIntroFragment.newInstance("Screen 2", "Doctor", R.drawable.hawk_logo, getResources().getColor(R.color.colorPrimary)));
        addSlide(AppIntroFragment.newInstance("Screen 3", "Pathology", R.drawable.hawk_logo, getResources().getColor(R.color.colorPrimaryDark)));

        // OPTIONAL METHODS
        // Override bar/separator color.
        setBarColor(Color.parseColor("#3F51B5"));
        setSeparatorColor(Color.parseColor("#2196F3"));

        // Hide Skip/Done button.
        showSkipButton(true);
        setProgressButtonEnabled(true);

        // Turn vibration on and set intensity.
        // NOTE: you will probably need to ask VIBRATE permisssion in Manifest.
//        setVibrate(true);
//        setVibrateIntensity(30);
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        // Do something when users tap on Skip button.
        completeIntroStatus();
        startActivity(new Intent(IntroScreen.this, HomeScreenNew.class));
        this.finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        // Do something when users tap on Done button.
        completeIntroStatus();
        startActivity(new Intent(IntroScreen.this, HomeScreenNew.class));
        this.finish();
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }

    private void completeIntroStatus()
    {
        SharedPreferences.Editor introEditor= HawkEyeApplication.getHawkEyePreference().edit();
        introEditor.putBoolean("IS_INTRO_COMPLETE",true).apply();
    }

}
