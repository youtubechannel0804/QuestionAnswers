package com.sahaj.questionanswers.filter;

/**
 * convert letters to lower case for comparison.
 */
public class LowerCaseFilter implements TokenFilter {

    @Override
    public String execute(String text) {
        return text.toLowerCase();
    }
}
