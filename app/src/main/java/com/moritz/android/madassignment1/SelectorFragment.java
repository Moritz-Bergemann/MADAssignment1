package com.moritz.android.madassignment1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class SelectorFragment extends Fragment {
    //RecyclerView used to display items to select
    private RecyclerView mRecycler;

    /**
     * OnCreateView method must be overridden for the 'SelectorFragment' abstract class to inflate
     *  the specific layout belonging to the inheriting Fragment
     */
    @Nullable
    @Override
    public abstract View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //** RECYCLERVIEW SETUP **
        mRecycler = view.findViewById(R.id.recycler);

        //Setting initial grid layout as vertical with 2 columns
        mRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 1,
                GridLayoutManager.VERTICAL, false));

        //Setting custom country adapter
        mRecycler.setAdapter(getAdapter());

        //** RESPONDING TO LAYOUT CHANGES **
        //Getting ViewModel holding layout information
        UIData uiData = UIData.getInstance();

        //Observing orientation change
        uiData.getOrientation().observe(getViewLifecycleOwner(), orientation -> {
            int span = uiData.getSpan().getValue();

            mRecycler.setLayoutManager(new GridLayoutManager(requireActivity(), span, orientation, false));
        });

        //Observing span change
        uiData.getSpan().observe(getViewLifecycleOwner(), span -> {
            int orientation = uiData.getOrientation().getValue();

            mRecycler.setLayoutManager(new GridLayoutManager(requireActivity(), span, orientation, false));
        });
    }

    /**
     * @return the adapter that should be used in this class' RecyclerView
     */
    protected abstract RecyclerView.Adapter<? extends RecyclerView.ViewHolder> getAdapter();
}
