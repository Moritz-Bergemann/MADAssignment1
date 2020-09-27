package com.moritz.android.madassignment1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.GridLayoutManager;

/**
 * Singleton class for UI components - used for communication between fragments regarding UI layout.
 */
public class UIData {
    //** SINGLETON STUFF **
    private static UIData instance = null;

    public static UIData getInstance() {
        if (instance == null) {
            instance = new UIData();
        }

        return instance;
    }

    private UIData() {
        mSpan = new MutableLiveData<>();
        mSpan.setValue(DEFAULT_SPAN);

        mOrientation = new MutableLiveData<>();
        mOrientation.setValue(DEFAULT_ORIENTATION);

        mShowPreviousButton = new MutableLiveData<>();
        mShowPreviousButton.setValue(false);
    }

    public static final int DEFAULT_SPAN = 2;
    public static final int DEFAULT_ORIENTATION = GridLayoutManager.VERTICAL;

    //** SIZE OF SCROLLABLE RECYCLERVIEW **
    private MutableLiveData<Integer> mSpan;

    public LiveData<Integer> getSpan() {
        return mSpan;
    }

    public void setSpan(int span) {
        mSpan.setValue(span);
    }


    //** ORIENTATION OF RECYCLERVIEW **
    private MutableLiveData<Integer> mOrientation;

    public LiveData<Integer> getOrientation() {
        return mOrientation;
    }

    public void setOrientation(int orientation) {
        if (orientation != GridLayoutManager.HORIZONTAL && orientation != GridLayoutManager.VERTICAL) {
            throw new IllegalArgumentException("Orientation must be either horizontal or vertical!");
        }

        mOrientation.setValue(orientation);
    }

    private MutableLiveData<Boolean> mShowPreviousButton;

    public LiveData<Boolean> getShowPreviousButton() {
        return mShowPreviousButton;
    }

    public void setShowPreviousButton(boolean showPreviousButton) {
        mShowPreviousButton.setValue(showPreviousButton);
    }
}
