package com.moritz.android.madassignment1.model;

public class Question {
    private String question;
    String[] choices;
    int correctChoice;
    boolean isSpecial;

    private int points;
    private int penalty;

    public Question(String question, String[] choices, int correctChoice, int points, int penalty, boolean isSpecial) {
        this.question = question;
        this.choices = choices;
        this.correctChoice = correctChoice;
        this.points = points;
        this.penalty = penalty;
        this.isSpecial = isSpecial;
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
}
