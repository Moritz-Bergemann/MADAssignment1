package com.moritz.android.madassignment1.model;

import java.util.List;

public class Question {
    private String question;
    String[] choices;
    int correctChoice;

    private int points;
    private int penalty;

    public Question(String question, String[] choices, int correctChoice, int points, int penalty) {
        this.question = question;
        this.choices = choices;
        this.correctChoice = correctChoice;
        this.points = points;
        this.penalty = penalty;
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
