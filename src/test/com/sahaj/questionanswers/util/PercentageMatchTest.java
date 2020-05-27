package com.sahaj.questionanswers.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PercentageMatchTest {

    @Test
    public void calculatePercentage() {
        Assert.assertEquals(40.0, PercentageMatch.calculatePercentage(10, 4),0);
    }

    @Test
    public void testKeyWordsMatchCount(){
        Set<String> sentenceKeywords = new HashSet<>();
        sentenceKeywords.add("quagga");
        sentenceKeywords.add("aim");

        List<String> questionKeywords = new ArrayList();
        questionKeywords.add("quagga");
        questionKeywords.add("endangered");

        int count = PercentageMatch.getCount(sentenceKeywords,questionKeywords);
        Assert.assertEquals(1,count);
    }

}