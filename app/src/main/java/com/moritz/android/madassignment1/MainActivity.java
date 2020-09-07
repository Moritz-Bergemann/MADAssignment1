package com.moritz.android.madassignment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

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

    @Override
    public void onBackPressed() {
        Fragment mainFragment = getSupportFragmentManager().findFragmentById(R.id.mainContent);
        if (mainFragment instanceof QuestionFragment) {
            goToQuestionSelectorFragment();
        } else if (mainFragment instanceof QuestionSelectorFragment) {
            goToCountrySelectorFragment();
        } else { //If in CountrySelectorFragment, just do normal back
            super.onBackPressed();
        }
    }

    public void goToCountrySelectorFragment() {
        Fragment countrySelectorFragment = CountrySelectorFragment.newInstance();

        getSupportFragmentManager().beginTransaction().replace(R.id.mainContent,
                countrySelectorFragment).commit();
    }

    public void goToQuestionSelectorFragment() {
        Fragment questionSelectorFragment = QuestionSelectorFragment.newInstance();

        getSupportFragmentManager().beginTransaction().replace(R.id.mainContent,
                questionSelectorFragment).commit();
    }

    public void goToQuestionFragment() {
        Fragment questionFragment = QuestionFragment.newInstance();

        getSupportFragmentManager().beginTransaction().replace(R.id.mainContent,
            questionFragment).commit();
    }
}