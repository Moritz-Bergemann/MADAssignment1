package com.moritz.android.madassignment1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

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

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
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

        UIViewModel uiViewModel = new ViewModelProvider(requireActivity()).get(UIViewModel.class);

        mOneButton = view.findViewById(R.id.oneButton);
        mTwoButton = view.findViewById(R.id.twoButton);
        mThreeButton = view.findViewById(R.id.threeButton);
        mOrientationButton = view.findViewById(R.id.orientationButton);

        mOneButton.setOnClickListener((View v) -> {

        });

    }
}