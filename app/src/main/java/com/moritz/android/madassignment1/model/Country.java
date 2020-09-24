package com.moritz.android.madassignment1.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Country {
    private List<Question> questions;
    private String name;
    private int flagResourceID;

    public Country(String name, int flagResourceID) {
        this.name = name;
        this.questions = new LinkedList<>();
        this.flagResourceID = flagResourceID;
    }

    /**
     * Adds a question to this country's list of questions.
     * @param question question to add
     */
    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public List<Question> getQuestions() {
        return Collections.unmodifiableList(questions);
    }

    public String getName() {
        return name;
    }

    public int getFlagResourceID() {
        return flagResourceID;
    }

    public void addPointsToQuestions(int pointsAdded) {
        for (Question question : questions) {
            question.setPoints(question.getPoints() + pointsAdded);
        }
    }

    public boolean allQuestionsAnswered() {
        boolean allAnswered = true;

        for (Question question : questions) {
            if (!question.isAnswered()) {
                allAnswered = false;
            }
        }

        return allAnswered;
    }
}
