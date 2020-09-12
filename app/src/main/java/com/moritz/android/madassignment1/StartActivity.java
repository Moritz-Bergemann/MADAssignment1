package com.moritz.android.madassignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.moritz.android.madassignment1.model.GameData;

import java.util.Locale;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //Getting GameData instance (and effectively initialising game values)
        GameData gd = GameData.getInstance();

        //Setting seed/target points values
        TextView seedPointsValue = findViewById(R.id.seedPointsValue);
        seedPointsValue.setText(String.format(Locale.US, "%d", gd.getSeedPoints()));
        TextView targetPointsValue = findViewById(R.id.targetPointsValue);
        targetPointsValue.setText(String.format(Locale.US, "%d", gd.getTargetPoints()));

        //Set button to start the game
        Button startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(view -> {
            Intent intent = CountryActivity.makeIntent(this);
            startActivity(intent);
        });
    }
}