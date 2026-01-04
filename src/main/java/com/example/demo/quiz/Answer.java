package com.example.demo.quiz;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = BasicAnswer.class)
public interface Answer<T> {
    T getContent();

    void setContent(T content);

    boolean isCorrect();

    void setCorrect(boolean correct);
}
