package com.moritz.android.madassignment1.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Country {
    private List<Question> questions;

    public Country() {
        this.questions = new LinkedList<>();
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
}
