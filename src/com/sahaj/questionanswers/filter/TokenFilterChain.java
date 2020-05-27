package com.sahaj.questionanswers.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * This manages adding all filter to one speicfic type.
 */
public abstract class TokenFilterChain {

    private List<TokenFilter> filters = new ArrayList<TokenFilter>();

    private String text;

    public void addFilter(TokenFilter filter) {
        filters.add(filter);
    }

    public void execute() {
        for (TokenFilter filter : filters) {
            this.text = filter.execute(this.text);
        }
        setText(this.text);
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public abstract String apply();
}
