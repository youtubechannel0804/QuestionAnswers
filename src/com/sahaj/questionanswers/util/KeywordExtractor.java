package com.sahaj.questionanswers.util;

import java.text.BreakIterator;
import java.util.HashSet;
import java.util.Set;

public class KeywordExtractor {

    public static Set<String> getKeywords(String sentence) {
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
