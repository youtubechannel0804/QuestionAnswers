package com.sahaj.questionanswers.filter;

import org.junit.Assert;
import org.junit.Test;

public class WhWorldFilterTest {
    @Test
    public void testRemoveWhWords() {
        WhWorldFilter whWorldFilter = new WhWorldFilter();
        String result = whWorldFilter.execute("what is the color of sky?");
        Assert.assertEquals("is the color of sky?", result);
    }

    @Test
    public void testRemoveWhWordsInMiddle() {
        WhWorldFilter whWorldFilter = new WhWorldFilter();
        String result = whWorldFilter.execute("middle what is the color of sky?");
        Assert.assertEquals("middle  is the color of sky?", result);
    }
}