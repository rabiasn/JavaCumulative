package com.example.demo.quiz;

import java.util.List;

public interface Question<T> {
    String getText();

    void setText(String text);

    List<Answer<T>> getAnswers();

    void setAnswers(List<Answer<T>> answers);

    void addAnswer(Answer<T> answer);
}
