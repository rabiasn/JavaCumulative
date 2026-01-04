package com.example.demo.quiz;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class QuizFileHandler {
    private final ObjectMapper objectMapper;

    public QuizFileHandler() {
        this.objectMapper = new ObjectMapper();
    }

    public void saveQuiz(Quiz quiz, String filename) throws IOException {
        objectMapper.writeValue(new File(filename), quiz);
    }

    public Quiz loadQuiz(String filename) throws IOException {
        return objectMapper.readValue(new File(filename), Quiz.class);
    }
}
