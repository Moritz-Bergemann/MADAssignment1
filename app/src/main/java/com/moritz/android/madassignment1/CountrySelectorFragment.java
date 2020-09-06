package com.moritz.android.madassignment1;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.moritz.android.madassignment1.model.Country;
import com.moritz.android.madassignment1.model.GameData;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CountrySelectorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CountrySelectorFragment extends SelectorFragment {
    public static CountrySelectorFragment newInstance() {
        return new CountrySelectorFragment();
    }

    public CountrySelectorFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country_selector, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected RecyclerView.Adapter<? extends RecyclerView.ViewHolder> getAdapter() {
        return new CountryAdapter(GameData.getInstance(), requireActivity());
    }

    private class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
        private GameData mGameData;
        protected Activity mActivity;

        public CountryAdapter(GameData gameData, Activity activity) {
            mGameData = gameData;
            mActivity = activity;
        }

        @NonNull
        @Override
        public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new CountryViewHolder(LayoutInflater.from(mActivity).inflate(R.layout.flag,
                    parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
            holder.bind(mGameData.getCountry(position), position);
        }

        @Override
        public int getItemCount() {
            return mGameData.getNumCountries();
        }

        private class CountryViewHolder extends RecyclerView.ViewHolder {
            ImageView mFlagImage;
            Country mCountry;

            public CountryViewHolder(@NonNull View itemView) {
                super(itemView);
                mFlagImage = itemView.findViewById(R.id.flagImage);
            }

            public void bind(Country country, int position) {
                mCountry = country;
                mFlagImage.setImageResource(country.getFlagResourceID());

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (getActivity() instanceof MainActivity) {
                            ((MainActivity) getActivity()).goToCountry(position);
                        }

//                        Toast.makeText(mActivity, String.format("You pressed %s!",
//                                mCountry.getName()), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }

}