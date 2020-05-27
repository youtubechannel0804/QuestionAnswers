package com.sahaj.questionanswers.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Help to identify Wh words and replace them from text
 */
public class WhWorldFilter implements TokenFilter {
    @Override
    public String execute(String text) {
        Pattern p = Pattern.compile("(?:[W|w]ho|[W|w]hat|[W|w]hen|[W|w]here|[W|w]hy|[W|w]hich|[W|w]hom|[W|w]hose)");
        Matcher m = p.matcher(text);
        List<String> matchedWords = new ArrayList<String>();
        while (m.find()) matchedWords.add(m.group());

        for (String word : matchedWords)
            text = text.replaceAll(word, "").trim();//System.out.println(ques);

        return text;
    }
}
