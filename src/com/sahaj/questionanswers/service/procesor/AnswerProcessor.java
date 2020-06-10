package com.sahaj.questionanswers.service.procesor;

import com.sahaj.questionanswers.filter.*;
import com.sahaj.questionanswers.service.ApplicationContext;
import com.sahaj.questionanswers.model.Question;
import com.sahaj.questionanswers.util.FileReader;
import com.sahaj.questionanswers.util.KeywordExtractor;
import com.sahaj.questionanswers.util.PercentageMatch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AnswerProcessor implements Processor {

    private void applySentenceFilter(String[] sentence) {
        TokenFilterChain sentenceFilterChain = new SentenceFilterChain();
        for (int i = 0; i < sentence.length; i++) {
            sentenceFilterChain.setText(sentence[i]);
            sentence[i] = sentenceFilterChain.apply();
        }
    }

    public void process(ApplicationContext applicationContext) {

        String answers = null;
        try {
            answers = FileReader.readFileAsString("answers.txt");
        } catch (IOException ex) {
        }

        String[] answersList = answers.split(";");

        applySentenceFilter(answersList);


        List<Set<String>> answersSet = new ArrayList<>();
        for (String s : answersList) {
            Set<String> keywordSet = KeywordExtractor.getKeywords(s);
            answersSet.add(keywordSet);
        }


        for (Question quest : applicationContext.getQuestions()) {
            String sentence = applicationContext.getSentence().get(quest.getSentenceIndex());
            double percentageMatch = 0;
            int answerIndex = 0;
            for (int i = 0; i < answersSet.size(); i++) {
                Set<String> keyWords = answersSet.get(i);
                int count = 0;
                for (String word : keyWords) {
                    if (sentence.contains(word)) {
                       // sentence = sentence.replace(word, "").trim();
                        count++;
                    }
                }

                double matchCount = PercentageMatch.calculatePercentage(keyWords.size(), count);
                if (percentageMatch < matchCount) {
                    percentageMatch = matchCount;
                    answerIndex = i;
                }

            }
            System.out.println(answersList[answerIndex]);
        }
    }
}
