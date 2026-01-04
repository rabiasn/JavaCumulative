package com.example.demo.quiz;

public class BasicAnswer<T> implements Answer<T> {
    private T content;
    private boolean isCorrect;

    public BasicAnswer() {
    }

    public BasicAnswer(T content, boolean isCorrect) {
        this.content = content;
        this.isCorrect = isCorrect;
    }

    @Override
    public T getContent() {
        return content;
    }

    @Override
    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public boolean isCorrect() {
        return isCorrect;
    }

    @Override
    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    @Override
    public String toString() {
        return "BasicAnswer{" +
                "content=" + content +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
