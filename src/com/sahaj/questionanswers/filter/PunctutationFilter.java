package com.sahaj.questionanswers.filter;

/**
 * Remve question mark punctuation
 */
public class PunctutationFilter implements TokenFilter {

    public static final String PATTERN_QUESTION_MARK = "[\\s]*\\?";

    @Override
    public String execute(String text) {
        return text.replaceAll(PATTERN_QUESTION_MARK, BLANK_STRING).trim();
    }
}
