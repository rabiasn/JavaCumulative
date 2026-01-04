package com.example.demo.gui;

import com.example.demo.quiz.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class QuizFrame extends JFrame {
    private Quiz quiz;
    private DefaultListModel<String> questionListModel;
    private JList<String> questionList;
    private QuizFileHandler fileHandler;

    public QuizFrame() {
        super("Quiz Maker");
        this.quiz = new BasicQuiz("My Quiz");
        this.fileHandler = new QuizFileHandler();
        this.questionListModel = new DefaultListModel<>();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        setupMenu();
        setupMainPanel();
    }

    private void setupMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem newItem = new JMenuItem("New Quiz");
        newItem.addActionListener(e -> {
            quiz = new BasicQuiz("New Quiz");
            questionListModel.clear();
        });

        JMenuItem saveItem = new JMenuItem("Save Quiz");
        saveItem.addActionListener(e -> saveQuiz());

        JMenuItem loadItem = new JMenuItem("Load Quiz");
        loadItem.addActionListener(e -> loadQuiz());

        fileMenu.add(newItem);
        fileMenu.add(saveItem);
        fileMenu.add(loadItem);
        menuBar.add(fileMenu);

        setJMenuBar(menuBar);
    }

    private void setupMainPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        questionList = new JList<>(questionListModel);
        mainPanel.add(new JScrollPane(questionList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton addBtn = new JButton("Add Question");
        addBtn.addActionListener(e -> openAddQuestionDialog());
        buttonPanel.add(addBtn);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);
    }

    private void openAddQuestionDialog() {
        AddQuestionDialog dialog = new AddQuestionDialog(this);
        dialog.setVisible(true);
        if (dialog.isConfirmed()) {
            Question<String> question = dialog.getNewQuestion();
            // Casting workaround for simple demonstration; in real app handle generics more
            // strictly
            Question rawQuestion = question;
            quiz.addQuestion(rawQuestion);
            questionListModel.addElement(question.getText());
        }
    }

    private void saveQuiz() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                fileHandler.saveQuiz(quiz, fileChooser.getSelectedFile().getAbsolutePath());
                JOptionPane.showMessageDialog(this, "Quiz saved successfully!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error saving quiz: " + e.getMessage());
            }
        }
    }

    private void loadQuiz() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                this.quiz = fileHandler.loadQuiz(fileChooser.getSelectedFile().getAbsolutePath());
                questionListModel.clear();
                for (Question<?> q : quiz.getQuestions()) {
                    questionListModel.addElement(q.getText());
                }
                JOptionPane.showMessageDialog(this, "Quiz loaded successfully!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error loading quiz: " + e.getMessage());
            }
        }
    }
}
