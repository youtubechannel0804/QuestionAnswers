package com.sahaj.questionanswers.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class SentenceKeyWordExtractorTest {


    @Test
    public void testSentenceExtractKeyword() {
        String text = "Zebras are several species of African equids (horse family) united by\n" +
                "their distinctive black and white stripes.";
        Assert.assertEquals(20, SentenceKeyWordExtractor.getKeywordsForSentence(text).size());
    }

    @Test
    public void testSentenceWithAnd() {
        String text = "here are three species of zebras: the plains zebra,\n" +
                "the Grévy's zebra and the mountain zebra";
        Set<String> listOfKeywords = SentenceKeyWordExtractor.getKeywordsForSentence(text);
        Assert.assertEquals(15, listOfKeywords.size());
        Assert.assertTrue(listOfKeywords.contains("zebra"));
        Assert.assertTrue(listOfKeywords.contains("zebras"));
    }

    @Test
    public void testSentenceWithoutAnd() {
        String text = "The unique stripes of zebras make them one of the\n" +
                "animals most familiar to people";
        Set<String> listOfKeywords = SentenceKeyWordExtractor.getKeywordsForSentence(text);
        Assert.assertEquals(14, listOfKeywords.size());
        Assert.assertFalse(listOfKeywords.contains("zebra"));
        Assert.assertTrue(listOfKeywords.contains("zebras"));
    }
}