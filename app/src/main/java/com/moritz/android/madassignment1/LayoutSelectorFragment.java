package com.moritz.android.madassignment1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LayoutSelectorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LayoutSelectorFragment extends Fragment {
    public LayoutSelectorFragment() {
        // Required empty public constructor
    }

    ImageButton mOneButton;
    ImageButton mTwoButton;
    ImageButton mThreeButton;
    ImageButton mOrientationButton;

    public static LayoutSelectorFragment newInstance() {
        return new LayoutSelectorFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_layout_selector, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        UIData uiData = UIData.getInstance();

        mOneButton = view.findViewById(R.id.oneButton);
        mTwoButton = view.findViewById(R.id.twoButton);
        mThreeButton = view.findViewById(R.id.threeButton);
        mOrientationButton = view.findViewById(R.id.orientationButton);

        //** SETTING BUTTON ACTIONS **
        //Make the different buttons set the designated number of rows/columns to their
        // corresponding values (listened to by activity displaying them)
        mOneButton.setOnClickListener((View v) -> {
            uiData.setSpan(1);
        });

        mTwoButton.setOnClickListener((View v) -> {
            uiData.setSpan(2);
        });

        mThreeButton.setOnClickListener((View v) -> {
            uiData.setSpan(3);
        });

        //Making orientation button switch the orientation
        mOrientationButton.setOnClickListener((View v) -> {
            //Switch orientation
            if (uiData.getOrientation().getValue() == GridLayoutManager.HORIZONTAL) {
                uiData.setOrientation(GridLayoutManager.VERTICAL);
            } else {
                uiData.setOrientation(GridLayoutManager.HORIZONTAL);
            }
        });

        //** SETTING BUTTON VISUALS **
        uiData.getOrientation().observe(getViewLifecycleOwner(), orientation -> {
            if (orientation == GridLayoutManager.HORIZONTAL) {
                mTwoButton.setImageResource(R.drawable.square_ver_two);
                mThreeButton.setImageResource(R.drawable.square_ver_three);
                mOrientationButton.setImageResource(R.drawable.arrow_right);
            } else { //If orientation is vertical
                mTwoButton.setImageResource(R.drawable.square_hor_two);
                mThreeButton.setImageResource(R.drawable.square_hor_three);
                mOrientationButton.setImageResource(R.drawable.arrow_down);
            }
        });
    }
}