package com.sahaj.questionanswers.service;

import com.sahaj.questionanswers.Exception.ApplicationException;
import com.sahaj.questionanswers.util.FileReader;

import java.io.IOException;
import java.util.List;

public class AnswerService {

    /**
     * This  method take paragraph and question as input and process them further.
     *
     * @param paragraphFilePath
     * @param questionFilePath
     * @return
     * @throws ApplicationException
     */
    public ApplicationContext computeAnswers(String paragraphFilePath, String questionFilePath) throws ApplicationException {
        String paragraph;
        List<String> questions;
        try {
            paragraph = FileReader.readFileAsString(paragraphFilePath);
            questions = FileReader.readAllLines(questionFilePath);
        } catch (IOException ex) {
            throw new ApplicationException("File not present ", ex);
        }
        ApplicationContext applicationContext = new ApplicationContext(paragraph, questions);
        applicationContext.computeAnswers();
        return applicationContext;
    }
}
