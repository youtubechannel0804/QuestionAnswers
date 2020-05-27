package com.sahaj.questionanswers.filter;

/**
 * Add all filter for question to clean text
 */
public class QuestionFilterChain extends TokenFilterChain {

    public String apply() {
        SentenceFilterChain filter = new SentenceFilterChain();
        filter.addFilter(new LowerCaseFilter());
        filter.addFilter(new PunctutationFilter());
        filter.addFilter(new StopWordFilter());
        filter.addFilter(new WhWorldFilter());
        filter.setText(super.getText());
        filter.execute();
        return filter.getText();
    }

}
