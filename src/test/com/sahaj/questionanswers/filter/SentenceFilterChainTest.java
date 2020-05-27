package com.sahaj.questionanswers.filter;

import org.junit.Assert;
import org.junit.Test;

public class SentenceFilterChainTest {

    @Test
    public void testAllFilterForSentence() {
        SentenceFilterChain chain = new SentenceFilterChain();
        chain.setText("Zebras are several species of African equids (horse family) united by\n" +
                "their distinctive black and white stripes.");
        String result = chain.apply();
        Assert.assertEquals("zebras several species african equids (horse family) united by\n" +
                "their distinctive black and white stripes.",result);
    }

}