package com.sahaj.questionanswers.filter;

import org.junit.Assert;
import org.junit.Test;

public class StopWordFilterTest {

    @Test
    public void testRemoveStopWords() {
        StopWordFilter stopWordFilter = new StopWordFilter();
        String result = stopWordFilter.execute("sentence is long");
        Assert.assertEquals("sentence long", result);
    }

    @Test
    public void testNoStopWords() {
        StopWordFilter stopWordFilter = new StopWordFilter();
        String result = stopWordFilter.execute("sentence starts");
        Assert.assertEquals("sentence starts", result);
    }

    @Test
    public void testMultipleStopWords() {
        StopWordFilter stopWordFilter = new StopWordFilter();
        String result = stopWordFilter.execute("sentence a the starts ");
        Assert.assertEquals("sentence starts", result);
    }
}