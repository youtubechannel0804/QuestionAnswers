package com.sahaj.questionanswers.util;

import java.text.BreakIterator;
import java.util.HashSet;
import java.util.Set;

/**
 * Extract Key word from sentence
 */
public class SentenceKeyWordExtractor {

    /**
     * Break Sentence into words
     *
     * @param sentence
     * @return
     */
    public static Set<String> getKeywordsForSentence(String sentence) {
        Set<String> keyWords = new HashSet<>();
        BreakIterator breakIterator =
                BreakIterator.getWordInstance();
        breakIterator.setText(sentence);

        int start = breakIterator.first();
        for (int end = breakIterator.next();
             end != BreakIterator.DONE;
             start = end, end = breakIterator.next()) {
            extractKeyWord(sentence, keyWords, start, end);
        }
        return keyWords;
    }

    /**
     * Extract Key word from a given match and make use of "and" keyword
     *
     * @param sentence
     * @param keyWords
     * @param start
     * @param end
     */
    private static void extractKeyWord(String sentence, Set<String> keyWords, int start, int end) {
        String substring = sentence.substring(start, end).trim();
        if (substring.length() > 0) {
            if (keyWords.contains(substring)) {
                if (sentence.contains("and")) {
                    keyWords.remove(substring);
                    keyWords.add(substring + "s");
                }
            } else {
                keyWords.add(substring);
            }
        }
    }
}
