package com.sahaj.questionanswers.filter;

public interface TokenFilter {

    public static String BLANK_STRING = "";

    String execute(String text);
}
