package com.moritz.android.madassignment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class CountryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    public void goToQuestionSelector() {
        //Start the question activity
        startActivity(QuestionsActivity.makeIntent(this));
    }

    public static Intent makeIntent(Activity callingActivity) {
        Intent intent = new Intent(callingActivity, CountryActivity.class);
        return intent;
    }
}