package com.sahaj.questionanswers.service;

import com.sahaj.questionanswers.model.Question;
import com.sahaj.questionanswers.service.procesor.AnswerProcessor;
import com.sahaj.questionanswers.service.procesor.QuestionProcessor;
import com.sahaj.questionanswers.service.procesor.SentenceProcessor;
import com.sahaj.questionanswers.util.PercentageMatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * it hold the application Context
 */
public class ApplicationContext {

    /**
     * Contain entire paragraph in form of String
     */
    String paragraph;
    /**
     * Broken sentences
     */
    List<String> sentence;
    /**
     * Keywords from a sentence
     */
    List<Set<String>> listOfKeywordsOfSentences;
    /**
     * List of question
     */
    List<Question> questions;
    /**
     * computed Answers
     */
    List<String> Answers;


    /**
     * Initlialized attributes  and set questions
     *
     * @param paragraph
     * @param questions
     */
    public ApplicationContext(String paragraph, List<String> questions) {
        this.paragraph = paragraph;
        this.questions = new ArrayList<>();
        this.sentence = new ArrayList<>();
        for (String questionText : questions) {
            this.questions.add(new Question(questionText));
        }
    }

    public void setSentence(List<String> sentence) {
        this.sentence = sentence;
    }

    public void setListOfKeywordsOfSentences(List<Set<String>> listOfKeywordsOfSentences) {
        this.listOfKeywordsOfSentences = listOfKeywordsOfSentences;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public String getParagraph() {
        return paragraph;
    }

    public List<String> getSentence() {
        return sentence;
    }

    /**
     * This method
     * 1. process sentence
     * 2. process question
     * 3. compute percentageMatch
     * 4. process answers
     */
    public void computeAnswers() {
        SentenceProcessor sentenceProcessor = new SentenceProcessor();
        sentenceProcessor.process(this);

        QuestionProcessor questionProcessor = new QuestionProcessor();
        questionProcessor.process(this);

        PercentageMatch.calculatePercentageMatch(this.getQuestions(), this.listOfKeywordsOfSentences);

        AnswerProcessor answerProcessor = new AnswerProcessor();
        answerProcessor.process(this);
    }

}
