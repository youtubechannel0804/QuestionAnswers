package com.sahaj.questionanswers.filter;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionFilterChainTest {

    @Test
    public void testAllFilterForSentence() {
        QuestionFilterChain questionFilterChain = new QuestionFilterChain();
        questionFilterChain.setText("What is the aim of the Quagga Project?");
        String result = questionFilterChain.apply();
        Assert.assertEquals("aim quagga project",result);
    }

}