package com.sahaj.questionanswers.tokenizer;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class SentenceTokenizer implements Tokenizer {

    String paragraph;

    private List<String> sentences;

    public SentenceTokenizer(String paragraph) {
        this.paragraph = paragraph;
        sentences = new ArrayList();
    }

    @Override
    public List<String> split() {
        BreakIterator iterator = BreakIterator.getSentenceInstance();
        iterator.setText(paragraph);
        int lastIndex = iterator.first();

        while (lastIndex != BreakIterator.DONE) {
            int firstIndex = lastIndex;
            lastIndex = iterator.next();

            if (lastIndex != BreakIterator.DONE) {
                String sentence = paragraph.substring(firstIndex, lastIndex);
                sentences.add(sentence);
            }
        }
        return sentences;
    }
}
