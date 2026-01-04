package com.example.demo.quiz;

import java.util.List;

public interface Quiz {
    String getTitle();

    void setTitle(String title);

    List<Question<?>> getQuestions();

    void setQuestions(List<Question<?>> questions);

    void addQuestion(Question<?> question);

    void removeQuestion(Question<?> question);
}
