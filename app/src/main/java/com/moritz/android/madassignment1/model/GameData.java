/* Parts of this file comprise externally-obtained code. */

package com.moritz.android.madassignment1.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.moritz.android.madassignment1.R;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Singleton containing game state information
 */
public class GameData {
    private static GameData instance = null;

    public static GameData getInstance() {
        if (instance == null) {
            instance = new GameData();
        }

        return instance;
    }

    //CONSTANTS
    public static final int SEED_POINTS_MIN = 1;
    public static final int SEED_POINTS_MAX = 20;
    public static final int TARGET_POINTS_MIN = 100;
    public static final int TARGET_POINTS_MAX = 150;

    public static final int POINTS_ADDED_BY_SPECIAL = 10;


    private MutableLiveData<Integer> curPoints;
    private int targetPoints;
    private int seedPoints;
    private int specialPoints;  //Special points can be 'redeemed' to increase the points given by a
                                // category by 10

    private Country curCountry;
    private Question curQuestion;
    List<Country> countries;

    //**Actually Private (for internal functionality)**
    //Tracks if game has ended (used internally to see if points should be updated on question answering)
    private boolean gameOver;

    private GameData() {
        //Randomly select seed points (& therefore initial score)
        seedPoints = (randBetween(SEED_POINTS_MIN, SEED_POINTS_MAX));
        curPoints = new MutableLiveData<>();
        curPoints.setValue(seedPoints);
        gameOver = false;

        //Randomly select target points
        targetPoints = randBetween(TARGET_POINTS_MIN, TARGET_POINTS_MAX);

        //Generating questions information
        countries = getCountries();

        specialPoints = 0;
    }

    public Country getCountry(int position) {
        return countries.get(position);
    }

    public int getNumCountries() {
        return countries.size();
    }

    public Country getCurCountry() {
        return curCountry;
    }

    public void setCurCountry(Country curCountry) {
        this.curCountry = curCountry;
    }

    public Question getCurQuestion() {
        return curQuestion;
    }

    public void setCurQuestion(Question curQuestion) {
        this.curQuestion = curQuestion;
    }

    public LiveData<Integer> getCurPoints() {
        return curPoints;
    }

    private void setCurPoints(int points) {
        if (!gameOver) {
            this.curPoints.setValue(points);

            //Setting gameOver if this change ended the game
            if (curPoints.getValue() >= targetPoints || curPoints.getValue() <= 0) {
                gameOver = true;
            }
        }
    }

    public void addCurPoints(int points) {
        setCurPoints(curPoints.getValue() + points);
    }

    public void loseCurPoints(int points) {
        setCurPoints(curPoints.getValue() - points);
    }

    public int getSpecialPoints() {
        return specialPoints;
    }

    /**
     * Adds a special point for the player (should be called when the player correctly answers a
     * special question
     */
    public void addSpecialPoint() {
        specialPoints++;
    }

    public void loseSpecialPoint() {
        specialPoints--;
    }

    public int getTargetPoints() {
        return targetPoints;
    }

    public int getSeedPoints() {
        return seedPoints;
    }

    public boolean isGameWon() {
        return curPoints.getValue() >= targetPoints;
    }

    public boolean isGameLost() {
        return curPoints.getValue() <= 0;
    }

    /**
     * Creates a random integer between the imported min and max
     * @param min minimum value for random integer
     * @param max maximum value for random integer\
     * Self-Reference: Retrieved from Moritz Bergemann's OOSE Assignment completed in Semester 1 of 2020
     * @return random integer
     */
    private static int randBetween(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Lower bound cannot be greater than upper bound");
        }

        //Returning value directly if min & max equal (since rand.nextInt cannot take in negative integers)
        if (min == max) {
            return min;
        }

        Random rand = new Random();

        //Getting number by setting lower bound as min & upper bound as max (standard bound is between 0 & import - 1)
        return rand.nextInt(max - min) + min + 1;
    }

    /**
     * Generates hard-coded questions for game for various countries.
     *
     * @return generated list of questions
     */
    private static List<Country> getCountries() {
        List<Country> countries = CountryDataGenerator.getCountries();

        //Shuffle the order of choices in each country question
        CountryDataGenerator.randomiseQuestions(countries);

        return countries;
    }
}
