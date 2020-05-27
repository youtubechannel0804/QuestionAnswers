package com.sahaj.questionanswers.service.procesor;

import com.sahaj.questionanswers.service.ApplicationContext;
import com.sahaj.questionanswers.filter.QuestionFilterChain;
import com.sahaj.questionanswers.filter.TokenFilterChain;
import com.sahaj.questionanswers.model.Question;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QuestionProcessor implements Processor{

    public void process(ApplicationContext applicationContext) {
        applyQuestionFilter(applicationContext.getQuestions());

        for (Question quest : applicationContext.getQuestions()) {
            quest.setKeywords(new ArrayList<String>(getKeywords(quest.getIntermediateText())));
        }
    }

    public void applyQuestionFilter(List<Question> questions) {
        TokenFilterChain questionFilterChain = new QuestionFilterChain();
        for (Question quest : questions) {
            questionFilterChain.setText(quest.getIntermediateText());
            questionFilterChain.setText(questionFilterChain.apply());
            quest.setIntermediateText(questionFilterChain.getText());
        }

    }

    private Set<String> getKeywords(String sentence) {
        Set<String> keyWords = new HashSet<>();
        BreakIterator breakIterator =
                BreakIterator.getWordInstance();
        breakIterator.setText(sentence);

        int start = breakIterator.first();
        for (int end = breakIterator.next();
             end != BreakIterator.DONE;
             start = end, end = breakIterator.next()) {
            String substring = sentence.substring(start, end).trim();
            if (substring.length() > 0) {
                keyWords.add(substring);
            }
        }
        return keyWords;
    }
}
