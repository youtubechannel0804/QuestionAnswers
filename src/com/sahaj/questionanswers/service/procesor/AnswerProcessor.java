package com.sahaj.questionanswers.service.procesor;

import com.sahaj.questionanswers.filter.AdverbTillCommaFilter;
import com.sahaj.questionanswers.service.ApplicationContext;
import com.sahaj.questionanswers.filter.TokenFilter;
import com.sahaj.questionanswers.model.Question;

public class AnswerProcessor implements  Processor{

    public void process(ApplicationContext applicationContext) {
        for (Question quest : applicationContext.getQuestions()) {
            String sentence = applicationContext.getSentence().get(quest.getSentenceIndex());
            for (String keyWords : quest.getKeywords()) {
                if (sentence.contains(keyWords)) {
                    sentence = sentence.replace(keyWords, "").trim();
                }
            }
            TokenFilter filter = new AdverbTillCommaFilter();
            quest.setAnswer(filter.execute(sentence));
        }
    }
}
