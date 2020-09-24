package com.moritz.android.madassignment1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.moritz.android.madassignment1.model.GameData;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScoreTrackerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScoreTrackerFragment extends Fragment {

    public ScoreTrackerFragment() {
        // Required empty public constructor
    }

    public static ScoreTrackerFragment newInstance() {
        return new ScoreTrackerFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_score_tracker, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView scoreValue = view.findViewById(R.id.scoreValue);
        GameData.getInstance().getCurPoints().observe(getViewLifecycleOwner(), score ->
                scoreValue.setText(String.format(Locale.US, "%d", score)));

        Button previousButton = view.findViewById(R.id.previousButton);
        UIData.getInstance().getShowPreviousButton().observe(getViewLifecycleOwner(), showButton -> {
            if (showButton) {
                previousButton.setVisibility(View.VISIBLE);
            } else {
                previousButton.setVisibility(View.INVISIBLE);
            }
        });

        //Setting previous button functionality
        previousButton.setOnClickListener(button -> {
            //Go to question selector if activity is QuestionsActivity
            if (getActivity() instanceof QuestionsActivity) {
                QuestionsActivity activity = (QuestionsActivity) getActivity();
                activity.returnActivity();
            }
        });

        TextView winLoseText = view.findViewById(R.id.winLoseText);
        //Setting won/lost label
        GameData.getInstance().getCurPoints().observe(getViewLifecycleOwner(), points -> {
            if (GameData.getInstance().isGameWon()) { //If game won
                winLoseText.setVisibility(View.VISIBLE);
                winLoseText.setText(R.string.loseGameText);
            } else if (GameData.getInstance().isGameLost()) { //If game lost
                winLoseText.setVisibility(View.VISIBLE);
                winLoseText.setText(R.string.wonGameMessage);
            } else {
                winLoseText.setVisibility(View.INVISIBLE);
            }
        });
    }
}