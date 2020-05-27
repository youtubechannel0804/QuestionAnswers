package com.sahaj.questionanswers.model;

import java.util.List;

/**
 * This is an POJO for question
 */
public class Question {

    String questionText;
    String intermediateText;
    String answer;
    int sentenceIndex;
    double percentageMatch = 0;
    List<String> keywords;

    public Question(String questionText) {

        this.questionText = questionText;
        this.intermediateText = questionText;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getIntermediateText() {
        return intermediateText;
    }

    public void setIntermediateText(String intermediateText) {
        this.intermediateText = intermediateText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getSentenceIndex() {
        return sentenceIndex;
    }

    public void setSentenceIndex(int sentenceIndex) {
        this.sentenceIndex = sentenceIndex;
    }

    public double getPercentageMatch() {
        return percentageMatch;
    }

    public void setPercentageMatch(double percentageMatch) {
        this.percentageMatch = percentageMatch;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }
}
