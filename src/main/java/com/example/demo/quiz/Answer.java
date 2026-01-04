package com.example.demo.quiz;

public interface Answer<T> {
    T getContent();

    void setContent(T content);

    boolean isCorrect();

    void setCorrect(boolean correct);
}
