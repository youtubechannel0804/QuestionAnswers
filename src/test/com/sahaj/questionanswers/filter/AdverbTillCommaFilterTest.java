package com.sahaj.questionanswers.filter;

import org.junit.Assert;
import org.junit.Test;

public class AdverbTillCommaFilterTest {

    @Test
    public void testAdverbsTillComma() {
        AdverbTillCommaFilter adverbTillCommaFilter = new AdverbTillCommaFilter();
        String result = adverbTillCommaFilter.execute("unlike test test, sentence starts");
        Assert.assertEquals("sentence starts",result);
    }

    @Test
    public void testAdverbWithoutComma() {
        AdverbTillCommaFilter adverbTillCommaFilter = new AdverbTillCommaFilter();
        String result = adverbTillCommaFilter.execute("unlike test test sentence starts");
        Assert.assertEquals("unlike test test sentence starts",result);
    }

    @Test
    public void testSentenceWithoutAdverb() {
        AdverbTillCommaFilter adverbTillCommaFilter = new AdverbTillCommaFilter();
        String result = adverbTillCommaFilter.execute("test test sentence starts");
        Assert.assertEquals("test test sentence starts",result);
    }
}