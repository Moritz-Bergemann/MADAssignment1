package com.moritz.android.madassignment1.model;

public class Question {
    private String question;
    private String[] choices;
    private int correctChoice;
    private boolean special;
    private boolean answered;

    private int points;
    private int penalty;

    public Question(String question, String[] choices, int correctChoice, int points, int penalty, boolean special) {
        this.question = question;
        this.choices = choices;
        this.correctChoice = correctChoice;
        this.points = points;
        this.penalty = penalty;
        this.special = special;
        this.answered = false;
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

    public void setPoints(int points) {
        this.points = points;
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

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }
}
