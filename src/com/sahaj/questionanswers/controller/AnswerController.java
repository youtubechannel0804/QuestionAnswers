package com.sahaj.questionanswers.controller;

import com.sahaj.questionanswers.Exception.ApplicationException;
import com.sahaj.questionanswers.service.ApplicationContext;
import com.sahaj.questionanswers.service.AnswerService;
import com.sahaj.questionanswers.util.AnswerFormatter;

/**
 * This call service layer to execute business logic.
 */
public class AnswerController {

    /**
     * This  method take paragraph and question as input and process them further form service class.
     *
     * @param paragraphFilePath
     * @param questionFilePath
     * @return
     * @throws ApplicationException
     */
    public ApplicationContext computeAnswers(String paragraphFilePath, String questionFilePath) throws ApplicationException {
        AnswerService answerService = new AnswerService();
        return answerService.computeAnswers(paragraphFilePath, questionFilePath);
    }

    /**
     * This method take care of formatting and displaying answers
     *
     * @param applicationContext
     */
    public void displayAnswers(ApplicationContext applicationContext) {
        AnswerFormatter.displayAnswers(applicationContext.getQuestions());
    }
}
