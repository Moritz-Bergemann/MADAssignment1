package com.moritz.android.madassignment1;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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
public class CountrySelectorFragment extends Fragment {
    public CountrySelectorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CountrySelectorFragment.
     */
    public static CountrySelectorFragment newInstance() {
        return new CountrySelectorFragment();
    }

    private RecyclerView mRecycler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        //** RECYCLERVIEW SETUP **
        mRecycler = view.findViewById(R.id.recycler);

        //Setting initial grid layout as vertical with 2 columns
        mRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 1,
                GridLayoutManager.VERTICAL, false));

        //Setting custom country adapter
        mRecycler.setAdapter(new CountryAdapter(GameData.getInstance(), getActivity()));
    }

    //FIXME is there a way to make this adapter the same as the one for questions?
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
            holder.bind(mGameData.getCountry(position));
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

            public void bind(Country country) {
                mCountry = country;
                mFlagImage.setImageResource(country.getFlagResourceID());

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(mActivity, String.format("You pressed %s!",
                                mCountry.getName()), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }

}