package com.moritz.android.madassignment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    FrameLayout mTopBar;
    FrameLayout mMainContent;
    FrameLayout mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTopBar = findViewById(R.id.topBar); //FIXME these might be redundant
        mMainContent = findViewById(R.id.mainContent);
        mBottomBar = findViewById(R.id.bottomBar);

        //** FRAGMENT SETUP **
        FragmentManager fm = getSupportFragmentManager();

        //Getting fragments currently contained in containers (if there are any)
        Fragment topFragment = fm.findFragmentById(R.id.topBar);
        Fragment mainFragment = fm.findFragmentById(R.id.mainContent);
        Fragment bottomFragment = fm.findFragmentById(R.id.bottomBar);

        //Initialising top fragment to layout manager
        if (topFragment == null) {
            topFragment = LayoutSelectorFragment.newInstance();
            fm.beginTransaction().add(R.id.topBar, topFragment).commit();
        }

        //Initialising middle fragment to country selector
        if (mainFragment == null) {
            mainFragment = CountrySelectorFragment.newInstance();
            fm.beginTransaction().add(R.id.mainContent, mainFragment).commit();
        }

        //Initialising bottom fragment to score tracker
        if (bottomFragment == null) {
            bottomFragment = ScoreTrackerFragment.newInstance();
            fm.beginTransaction().add(R.id.bottomBar, bottomFragment).commit();
        }
    }

    public void goToCountry(int countryPosition) {
        Fragment questionSelectorFragment = QuestionSelectorFragment.newInstance(countryPosition);

        getSupportFragmentManager().beginTransaction().replace(R.id.mainContent,
                questionSelectorFragment).commit();
    }
}