package com.sahaj.questionanswers.util;

import com.sahaj.questionanswers.model.Question;

import java.util.List;

public class AnswerFormatter {

    public static void displayAnswers(List<Question> questions) {
        for (int i = 0; i < questions.size(); i++) {
            System.out.println(i + 1 + " " + questions.get(i).getAnswer());
        }
    }
}
