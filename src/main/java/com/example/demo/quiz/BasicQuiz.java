package com.example.demo.quiz;

import java.util.ArrayList;
import java.util.List;

public class BasicQuiz implements Quiz {
    private String title;
    private List<Question<?>> questions;

    public BasicQuiz() {
        this.questions = new ArrayList<>();
    }

    public BasicQuiz(String title) {
        this.title = title;
        this.questions = new ArrayList<>();
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public List<Question<?>> getQuestions() {
        return questions;
    }

    @Override
    public void setQuestions(List<Question<?>> questions) {
        this.questions = questions;
    }

    @Override
    public void addQuestion(Question<?> question) {
        this.questions.add(question);
    }

    @Override
    public void removeQuestion(Question<?> question) {
        this.questions.remove(question);
    }

    @Override
    public String toString() {
        return "BasicQuiz{" +
                "title='" + title + '\'' +
                ", questions=" + questions +
                '}';
    }
}
