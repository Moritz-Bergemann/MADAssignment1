package com.moritz.android.madassignment1.model;

public class Question {
    private String question;
    String[] choices;
    int correctChoice;
    boolean special;

    private int points;
    private int penalty;

    public Question(String question, String[] choices, int correctChoice, int points, int penalty, boolean special) {
        this.question = question;
        this.choices = choices;
        this.correctChoice = correctChoice;
        this.points = points;
        this.penalty = penalty;
        this.special = special;
    }

    public boolean isCorrectChoice(int choice) {
        return choice == correctChoice;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getChoices() {
        return choices;
    }

    public int getPoints() {
        return points;
    }

    public int getPenalty() {
        return penalty;
    }

    public boolean isSpecial() {
        return special;
    }
}
