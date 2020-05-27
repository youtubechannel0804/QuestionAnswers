package com.sahaj.questionanswers.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * filter to remove all adverbs from a text
 */
public class AdverbTillCommaFilter implements TokenFilter {

    public static final String PATTERN_ADVERB_TILL_COMMA = "(?:though|unlike|before|after|since)[\\sa-z]*(\\,)";

    @Override
    public String execute(String text) {
        Pattern p = Pattern.compile(PATTERN_ADVERB_TILL_COMMA);
        Matcher m = p.matcher(text);
        List<String> matchedWords = new ArrayList<String>();
        while (m.find()) matchedWords.add(m.group());
        for (String word : matchedWords)
            text = text.replaceAll(word, "").trim();
        return text;
    }
}
