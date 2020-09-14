package com.moritz.android.madassignment1.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//TO-DOS
//TODO fix alignment on recyclerviews (especially questions, maybe using framelayout wrapper?)
//TODO add more questions
//TODO add stuff done during victory/defeat

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
}
