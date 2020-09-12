package com.moritz.android.madassignment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class QuestionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

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
            mainFragment = QuestionSelectorFragment.newInstance();
            fm.beginTransaction().add(R.id.mainContent, mainFragment).commit();
        }

        //Initialising bottom fragment to score tracker
        if (bottomFragment == null) {
            bottomFragment = ScoreTrackerFragment.newInstance();
            fm.beginTransaction().add(R.id.bottomBar, bottomFragment).commit();
        }
    }

    public void goToQuestion() {
        //Making question fragment visible and top bar/question selector invisible
        //FIXME this should only be done on mobile devices
        findViewById(R.id.questionContent).setVisibility(View.VISIBLE);
        findViewById(R.id.topBar).setVisibility(View.INVISIBLE);
        findViewById(R.id.mainContent).setVisibility(View.INVISIBLE);

        //Insert a question fragment into the question fragment holder
        getSupportFragmentManager().beginTransaction().replace(R.id.questionContent,
                QuestionFragment.newInstance()).commit();
    }

    public void goToQuestionSelector() {
        //FIXME this should only be done on mobile devices
        findViewById(R.id.questionContent).setVisibility(View.INVISIBLE);
        findViewById(R.id.topBar).setVisibility(View.VISIBLE);
        findViewById(R.id.mainContent).setVisibility(View.VISIBLE);

        //Empty out the question fragment holder
        Fragment questionFragment = getSupportFragmentManager().findFragmentById(R.id.questionContent);
        if (questionFragment != null) {
            getSupportFragmentManager().beginTransaction().remove(questionFragment).commit();
        }
    }

    public static Intent makeIntent(Activity callingActivity) {
        Intent intent = new Intent(callingActivity, QuestionsActivity.class);
        return intent;
    }

    /**
     * Returns to the calling activity. Should only be called if the activity has finished successfully.
     */
    public void returnActivity() {
        setResult(RESULT_OK);
        finish();
    }
}