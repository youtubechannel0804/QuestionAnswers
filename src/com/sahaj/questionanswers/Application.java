package com.sahaj.questionanswers;

import com.sahaj.questionanswers.Exception.ApplicationException;
import com.sahaj.questionanswers.controller.AnswerController;
import com.sahaj.questionanswers.service.ApplicationContext;

public class Application {

    /**
     * Starting point of the application
     *
     * @param args
     * @throws ApplicationException
     */
    public static void main(String[] args) throws ApplicationException {
        AnswerController answerController = new AnswerController();
        ApplicationContext applicationContext = answerController.computeAnswers("paragraph.txt", "questions.txt");
        answerController.displayAnswers(applicationContext);
    }
}