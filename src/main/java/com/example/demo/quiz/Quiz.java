package com.example.demo.quiz;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

@JsonDeserialize(as = BasicQuiz.class)
public interface Quiz {
    String getTitle();

    void setTitle(String title);

    List<Question<?>> getQuestions();

    void setQuestions(List<Question<?>> questions);

    void addQuestion(Question<?> question);

    void removeQuestion(Question<?> question);
}
