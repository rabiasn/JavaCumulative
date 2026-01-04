package com.example.demo.quiz;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

@JsonDeserialize(as = BasicQuestion.class)
public interface Question<T> {
    String getText();

    void setText(String text);

    List<Answer<T>> getAnswers();

    void setAnswers(List<Answer<T>> answers);

    void addAnswer(Answer<T> answer);
}
