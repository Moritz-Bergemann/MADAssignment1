package com.moritz.android.madassignment1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.GridLayoutManager;

/**
 * ViewModel class for UI components - used for communication between fragments regarding UI layout.
 */
public class UIViewModel extends ViewModel {
    public static final int DEFAULT_SPAN = 2;
    public static final int DEFAULT_ORIENTATION = GridLayoutManager.VERTICAL;

    //** SIZE OF SCROLLABLE RECYCLERVIEW **
    private MutableLiveData<Integer> mSpan;

    public LiveData<Integer> getSpan() {
        initialiseSpan();

        return mSpan;
    }

    public void setSpan(int span) {
        initialiseSpan();

        mSpan.setValue(span);
    }

    private void initialiseSpan() {
        if (mSpan == null) {
            mSpan = new MutableLiveData<>();
            mSpan.setValue(DEFAULT_SPAN);
        }
    }

    //** ORIENTATION OF RECYCLERVIEW **
    private MutableLiveData<Integer> mOrientation;

    public LiveData<Integer> getOrientation() {
        initialiseOrientation();

        return mOrientation;
    }

    public void setOrientation(int orientation) {
        initialiseOrientation();

        if (orientation != GridLayoutManager.HORIZONTAL && orientation != GridLayoutManager.VERTICAL) {
            throw new IllegalArgumentException("Orientation must be either horizontal or vertical!");
        }

        mOrientation.setValue(orientation);
    }

    private void initialiseOrientation() {
        if (mOrientation == null) {
            mOrientation = new MutableLiveData<>();
            mOrientation.setValue(DEFAULT_ORIENTATION);
        }
    }
}
