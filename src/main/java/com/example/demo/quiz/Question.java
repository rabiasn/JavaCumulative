package com.example.demo.quiz;

import java.util.List;

public interface Question {
    String getText();

    void setText(String text);

    List<Answer> getAnswers();

    void setAnswers(List<Answer> answers);

    void addAnswer(Answer answer);
}
