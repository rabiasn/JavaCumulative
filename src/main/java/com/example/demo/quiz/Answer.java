package com.example.demo.quiz;

public interface Answer {
    String getText();

    void setText(String text);

    boolean isCorrect();

    void setCorrect(boolean correct);
}
