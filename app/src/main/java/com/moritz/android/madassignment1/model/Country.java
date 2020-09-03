package com.moritz.android.madassignment1.model;

import java.util.Collections;
import java.util.List;

public class Country {
    private List<Question> questions;

    public Country(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return Collections.unmodifiableList(questions);
    }
}
