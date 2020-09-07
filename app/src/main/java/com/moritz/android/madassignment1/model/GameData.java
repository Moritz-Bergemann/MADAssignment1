package com.moritz.android.madassignment1.model;

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
    public static final int SEED_POINTS_MAX = 5;
    public static final int TARGET_POINTS_MIN = 6;
    public static final int TARGET_POINTS_MAX = 10;

    private int playerPoints;
    private int targetPoints;
    private int seedPoints;

    private Country curCountry;
    private Question curQuestion;

    List<Country> countries;

    private GameData() {
        //Randomly select seed points (& therefore initial score)
        playerPoints = seedPoints = randBetween(SEED_POINTS_MIN, SEED_POINTS_MAX);

        //Randomly select target points
        targetPoints = randBetween(TARGET_POINTS_MIN, TARGET_POINTS_MAX);

        //Generating questions information
        countries = generateQuestions();
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

    public int getPlayerPoints() {
        return playerPoints;
    }

    public void setPlayerPoints(int playerPoints) {
        this.playerPoints = playerPoints;
    }

    public int getTargetPoints() {
        return targetPoints;
    }

    public int getSeedPoints() {
        return seedPoints;
    }

    public boolean hasWon() {
        return playerPoints >= targetPoints;
    }

    /** FIXME self-reference - retrieved from OOSE assignment
     * Creates a random integer between the imported min and max
     * @param min minimum value for random integer
     * @param max maximum value for random integer
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
     * @return generated list of questions
     */
    private static List<Country> generateQuestions() {
        List<Country> countryList = new LinkedList<>();

        Country testA = new Country("testA", R.drawable.flagtesta);
        countryList.add(testA);
        testA.addQuestion(new Question("Select A", new String[]{"A", "B", "C", "D"}, 0, 10, 10));
        testA.addQuestion(new Question("Select A", new String[]{"A", "B", "C", "D"}, 0, 10, 10));
        testA.addQuestion(new Question("Select A", new String[]{"A", "B", "C", "D"}, 0, 10, 10));
        testA.addQuestion(new Question("Select A", new String[]{"A", "B", "C", "D"}, 0, 10, 10));

        Country testB = new Country("testB", R.drawable.flagtestb);
        countryList.add(testB);
        testB.addQuestion(new Question("Select B", new String[]{"A", "B", "C", "D"}, 1, 10, 10));
        testB.addQuestion(new Question("Select B", new String[]{"A", "B", "C", "D"}, 1, 10, 10));
        testB.addQuestion(new Question("Select B", new String[]{"A", "B", "C", "D"}, 1, 10, 10));
        testB.addQuestion(new Question("Select B", new String[]{"A", "B", "C", "D"}, 1, 10, 10));

        Country testC = new Country("testC", R.drawable.flagtestc);
        countryList.add(testC);
        testC.addQuestion(new Question("Select C", new String[]{"A", "B", "C", "D"}, 2, 10, 10));
        testC.addQuestion(new Question("Select C", new String[]{"A", "B", "C", "D"}, 2, 10, 10));
        testC.addQuestion(new Question("Select C", new String[]{"A", "B", "C", "D"}, 2, 10, 10));
        testC.addQuestion(new Question("Select C", new String[]{"A", "B", "C", "D"}, 2, 10, 10));

        Country testA2 = new Country("testA2", R.drawable.flagtesta2);
        countryList.add(testA2);
        testA2.addQuestion(new Question("Select A", new String[]{"A", "B", "C", "D"}, 0, 10, 10));
        testA2.addQuestion(new Question("Select A", new String[]{"A", "B", "C", "D"}, 0, 10, 10));
        testA2.addQuestion(new Question("Select A", new String[]{"A", "B", "C", "D"}, 0, 10, 10));
        testA2.addQuestion(new Question("Select A", new String[]{"A", "B", "C", "D"}, 0, 10, 10));

        Country testB2 = new Country("testB2", R.drawable.flagtestb2);
        countryList.add(testB2);
        testB.addQuestion(new Question("Select B", new String[]{"A", "B", "C", "D"}, 1, 10, 10));
        testB.addQuestion(new Question("Select B", new String[]{"A", "B", "C", "D"}, 1, 10, 10));
        testB.addQuestion(new Question("Select B", new String[]{"A", "B", "C", "D"}, 1, 10, 10));
        testB.addQuestion(new Question("Select B", new String[]{"A", "B", "C", "D"}, 1, 10, 10));

        Country testC2 = new Country("testC2", R.drawable.flagtestc2);
        countryList.add(testC2);
        testC2.addQuestion(new Question("Select C", new String[]{"A", "B", "C", "D"}, 2, 10, 10));
        testC2.addQuestion(new Question("Select C", new String[]{"A", "B", "C", "D"}, 2, 10, 10));
        testC2.addQuestion(new Question("Select C", new String[]{"A", "B", "C", "D"}, 2, 10, 10));
        testC2.addQuestion(new Question("Select C", new String[]{"A", "B", "C", "D"}, 2, 10, 10));

        return countryList;
    }
}
