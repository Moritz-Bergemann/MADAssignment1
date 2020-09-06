package com.moritz.android.madassignment1;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * ViewModel class for UI components - used for communication between fragments regarding UI layout.
 */
public class UIViewModel extends ViewModel {
    public static final int DEFAULT_SIZE = 2;

    public enum Orientation {
        HORIZONTAL,
        VERTICAL
    }

    //** SIZE OF SCROLLABLE RECYCLERVIEW **
    private MutableLiveData<Integer> mSize;

    public LiveData<Integer> getSize() {
        initialiseSize();

        return mSize;
    }

    public void setSize(int size) {
        initialiseSize();

        mSize.setValue(size);
    }

    private void initialiseSize() {
        if (mSize == null) {
            mSize = new MutableLiveData<>();
            mSize.setValue(1);
        }
    }

    //** ORIENTATION OF RECYCLERVIEW **
    private MutableLiveData<Orientation> mOrientation;

    public LiveData<Orientation> getOrientation() {
        initialiseOrientation();

        return mOrientation;
    }

    public void setOrientation(Orientation orientation) {
        initialiseOrientation();

        mOrientation.setValue(orientation);
    }

    private void initialiseOrientation() {
        if (mOrientation == null) {
            mOrientation = new MutableLiveData<>();
            mOrientation.setValue(Orientation.VERTICAL);
        }
    }
}
