package com.example.demo.gui;

import com.example.demo.quiz.BasicAnswer;
import com.example.demo.quiz.BasicQuestion;
import com.example.demo.quiz.Question;

import javax.swing.*;
import java.awt.*;

public class AddQuestionDialog extends JDialog {
    private JTextField questionTextField;
    private JTextField answer1Field, answer2Field, answer3Field, answer4Field;
    private JCheckBox correct1, correct2, correct3, correct4;
    private boolean confirmed = false;
    private Question<String> newQuestion;

    public AddQuestionDialog(Frame owner) {
        super(owner, "Add Question", true);
        setLayout(new BorderLayout());
        setSize(400, 300);

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));

        inputPanel.add(new JLabel("Question Text:"));
        questionTextField = new JTextField();
        inputPanel.add(questionTextField);

        answer1Field = new JTextField();
        correct1 = new JCheckBox("Correct?");
        inputPanel.add(new JLabel("Answer 1:"));
        JPanel ans1Panel = new JPanel(new BorderLayout());
        ans1Panel.add(answer1Field, BorderLayout.CENTER);
        ans1Panel.add(correct1, BorderLayout.EAST);
        inputPanel.add(ans1Panel);

        answer2Field = new JTextField();
        correct2 = new JCheckBox("Correct?");
        inputPanel.add(new JLabel("Answer 2:"));
        JPanel ans2Panel = new JPanel(new BorderLayout());
        ans2Panel.add(answer2Field, BorderLayout.CENTER);
        ans2Panel.add(correct2, BorderLayout.EAST);
        inputPanel.add(ans2Panel);

        answer3Field = new JTextField();
        correct3 = new JCheckBox("Correct?");
        inputPanel.add(new JLabel("Answer 3:"));
        JPanel ans3Panel = new JPanel(new BorderLayout());
        ans3Panel.add(answer3Field, BorderLayout.CENTER);
        ans3Panel.add(correct3, BorderLayout.EAST);
        inputPanel.add(ans3Panel);

        answer4Field = new JTextField();
        correct4 = new JCheckBox("Correct?");
        inputPanel.add(new JLabel("Answer 4:"));
        JPanel ans4Panel = new JPanel(new BorderLayout());
        ans4Panel.add(answer4Field, BorderLayout.CENTER);
        ans4Panel.add(correct4, BorderLayout.EAST);
        inputPanel.add(ans4Panel);

        add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> onSave());
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dispose());
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void onSave() {
        String text = questionTextField.getText();
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Question text cannot be empty.");
            return;
        }

        newQuestion = new BasicQuestion<>(text);
        if (!answer1Field.getText().isEmpty())
            newQuestion.addAnswer(new BasicAnswer<>(answer1Field.getText(), correct1.isSelected()));
        if (!answer2Field.getText().isEmpty())
            newQuestion.addAnswer(new BasicAnswer<>(answer2Field.getText(), correct2.isSelected()));
        if (!answer3Field.getText().isEmpty())
            newQuestion.addAnswer(new BasicAnswer<>(answer3Field.getText(), correct3.isSelected()));
        if (!answer4Field.getText().isEmpty())
            newQuestion.addAnswer(new BasicAnswer<>(answer4Field.getText(), correct4.isSelected()));

        confirmed = true;
        dispose();
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public Question<String> getNewQuestion() {
        return newQuestion;
    }
}
