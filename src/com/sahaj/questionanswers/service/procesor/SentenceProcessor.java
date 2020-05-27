package com.sahaj.questionanswers.service.procesor;

import com.sahaj.questionanswers.filter.SentenceFilterChain;
import com.sahaj.questionanswers.filter.TokenFilterChain;
import com.sahaj.questionanswers.util.SentenceKeyWordExtractor;
import com.sahaj.questionanswers.service.ApplicationContext;
import com.sahaj.questionanswers.tokenizer.SentenceTokenizer;
import com.sahaj.questionanswers.tokenizer.Tokenizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SentenceProcessor implements Processor {

    private List<String> parseSentence(String paragraph) {
        Tokenizer tokenizer = new SentenceTokenizer(paragraph);
        return tokenizer.split();
    }

    public void process(ApplicationContext applicationContext) {
        List<String> sentences = parseSentence(applicationContext.getParagraph());
        applySentenceFilter(sentences);
        applicationContext.setSentence(sentences);
        applicationContext.setListOfKeywordsOfSentences(getKeyword(applicationContext.getSentence()));
    }

    private void applySentenceFilter(List<String> sentence) {
        TokenFilterChain sentenceFilterChain = new SentenceFilterChain();
        for (int i = 0; i < sentence.size(); i++) {
            sentenceFilterChain.setText(sentence.get(i));
            sentence.set(i, sentenceFilterChain.apply());
        }
    }

    private List<Set<String>> getKeyword(List<String> sentence) {
        List<Set<String>> listOfKeywords = new ArrayList<>();
        for (String sent : sentence) {
            listOfKeywords.add(SentenceKeyWordExtractor.getKeywordsForSentence(sent));
        }
        return listOfKeywords;
    }
}
