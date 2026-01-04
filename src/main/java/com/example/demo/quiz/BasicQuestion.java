package com.example.demo.quiz;

import java.util.ArrayList;
import java.util.List;

public class BasicQuestion<T> implements Question<T> {
    private String text;
    private List<Answer<T>> answers;

    public BasicQuestion(String text) {
        this.text = text;
        this.answers = new ArrayList<>();
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public List<Answer<T>> getAnswers() {
        return answers;
    }

    @Override
    public void setAnswers(List<Answer<T>> answers) {
        this.answers = answers;
    }

    @Override
    public void addAnswer(Answer<T> answer) {
        this.answers.add(answer);
    }

    @Override
    public String toString() {
        return "BasicQuestion{" +
                "text='" + text + '\'' +
                ", answers=" + answers +
                '}';
    }
}
