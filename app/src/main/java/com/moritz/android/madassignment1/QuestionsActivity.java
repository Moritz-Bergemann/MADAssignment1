package com.moritz.android.madassignment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class QuestionsActivity extends AppCompatActivity {

    private static final String TAG_QUESTION_FRAGMENT = "QUESTION_FRAGMENT";

    Fragment mTopFragment;
    Fragment mQuestionSelectorFragment;
    Fragment mBottomFragment;
    Fragment mQuestionFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        //** FRAGMENT SETUP **
        FragmentManager fm = getSupportFragmentManager();

        //Getting fragments currently contained in containers (if there are any)
        mTopFragment = fm.findFragmentById(R.id.topBar);
        mQuestionSelectorFragment = fm.findFragmentById(R.id.mainContent);
        mBottomFragment = fm.findFragmentById(R.id.bottomBar);
        mQuestionFragment = null;

        //Initialising top fragment to layout manager
        if (mTopFragment == null) {
            mTopFragment = LayoutSelectorFragment.newInstance();
            fm.beginTransaction().add(R.id.topBar, mTopFragment).commit();
        }

        //Initialising middle fragment to country selector
        if (mQuestionSelectorFragment == null) {
            mQuestionSelectorFragment = QuestionSelectorFragment.newInstance();
            fm.beginTransaction().add(R.id.mainContent, mQuestionSelectorFragment, TAG_QUESTION_FRAGMENT).commit();
        } else if (mQuestionSelectorFragment instanceof QuestionFragment) { //If main fragment is actually question picking fragment
            //Set the current fragment in main slot to question fragment
            mQuestionFragment = mQuestionSelectorFragment;

            //Find the actual question selector fragment (currently hidden)
            mQuestionSelectorFragment = fm.findFragmentByTag(TAG_QUESTION_FRAGMENT);
        }

        if (mQuestionFragment == null) { //If no question fragment has been found
            //See if question fragment exists in special question fragment container (only on tablets)
            mQuestionFragment = fm.findFragmentById(R.id.questionContent);
        }

        //Initialising bottom fragment to score tracker
        if (mBottomFragment == null) {
            mBottomFragment = ScoreTrackerFragment.newInstance();
            fm.beginTransaction().add(R.id.bottomBar, mBottomFragment).commit();
        }
    }

    public void goToQuestion() {
        if (mQuestionFragment != null) { //If previous question has not been unselected
            //Reset everything by going to question selector
            goToQuestionSelector();
        }

        //Use insert/replace method to show question fragment (depending on if separate container
        // available)
        mQuestionFragment = QuestionFragment.newInstance();

        if (findViewById(R.id.questionContent) != null) { //If separate container exists
            getSupportFragmentManager().beginTransaction().replace(R.id.questionContent, mQuestionFragment).commit();
        } else { //If no separate container
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            //Hide current fragment in main content slot
            transaction.hide(mQuestionSelectorFragment);

            //Create and display the new question fragment
            transaction.add(R.id.mainContent, mQuestionFragment);
            transaction.commit();

            //Hide the header bar
            findViewById(R.id.topBar).setVisibility(View.INVISIBLE);
        }
    }

    public void goToQuestionSelector() {
        if (mQuestionFragment != null) {
            //Remove question fragment and any references
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.remove(mQuestionFragment);

            if (findViewById(R.id.questionContent) == null) { //If there is no separate container for question fragments
                //Show the question selector again
                transaction.show(mQuestionSelectorFragment);

                //Show the layout bar again
                findViewById(R.id.topBar).setVisibility(View.VISIBLE);
            }

            transaction.commit();

            //Hide the 'previous' button
            UIData.getInstance().setShowPreviousButton(false);


            //Unlink this question fragment
            mQuestionFragment = null;

        } //Else do nothing, should already be at question selector
    }

    public static Intent makeIntent(Activity callingActivity) {
        Intent intent = new Intent(callingActivity, QuestionsActivity.class);
        return intent;
    }

    /**
     * Returns to the calling activity. Should only be called if the activity has finished successfully.
     */
    public void returnActivity() {
        //Hide the 'previous' button
        UIData.getInstance().setShowPreviousButton(false);

        setResult(RESULT_OK);
        finish();
    }
}