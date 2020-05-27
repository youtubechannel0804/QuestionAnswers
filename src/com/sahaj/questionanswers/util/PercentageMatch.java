package com.sahaj.questionanswers.util;

import com.sahaj.questionanswers.model.Question;

import java.util.List;
import java.util.Set;

/**
 * Percentage match for a question to a given sentence in a paragraph
 */
public class PercentageMatch {

    public static void calculatePercentageMatch(List<Question> questions, List<Set<String>> listOfKeywordsOfSentences) {

        int indexForSentence = 0;
        for (Set sentKeyWorld : listOfKeywordsOfSentences) {
            for (Question question : questions) {
                int count = getCountOfMatchedWords(sentKeyWorld, question);
                double percentageMatch = calculatePercentage(question.getKeywords().size(), count);
                setHighestMatchSentence(indexForSentence, question, percentageMatch);
            }
            indexForSentence++;
        }

    }

    /**
     * setting highest match index to question class
     *
     * @param indexForSentence
     * @param quest
     * @param percentageMatch
     */
    private static void setHighestMatchSentence(int indexForSentence, Question quest, double percentageMatch) {
        if (percentageMatch > quest.getPercentageMatch()) {
            quest.setPercentageMatch(percentageMatch);
            quest.setSentenceIndex(indexForSentence);
        }
    }

    /**
     * Calculate percentage for a given question.
     * this is based on total no of words with matched words.
     *
     * @param size
     * @param count
     * @return
     */
    public static double calculatePercentage(int size, int count) {
        return (count * 100) / size;
    }

    /**
     * check the match keywords with sentence keyword.
     *
     * @param sentKeyWorld
     * @param quest
     * @return
     */
    private static int getCountOfMatchedWords(Set sentKeyWorld, Question quest) {
        return getCount(sentKeyWorld, quest.getKeywords());
    }

    public static int getCount(Set<String> sentKeyWorld, List<String> questKeyWorld) {
        int count = 0;
        for (String questionKWord : questKeyWorld) {
            if (sentKeyWorld.contains(questionKWord)) {
                count++;
            }
        }
        return count;
    }
}
