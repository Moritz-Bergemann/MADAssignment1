package com.moritz.android.madassignment1.model;

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

    private GameData() {
        //Randomly select seed points (& therefore initial score)
        playerPoints = seedPoints = randBetween(SEED_POINTS_MIN, SEED_POINTS_MAX);

        //Randomly select target points
        targetPoints = randBetween(TARGET_POINTS_MIN, TARGET_POINTS_MAX);
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
}
