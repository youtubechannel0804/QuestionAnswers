package com.sahaj.questionanswers.filter;

import org.junit.Assert;
import org.junit.Test;

public class PunctutationFilterTest {

    @Test
    public void testRemoveQuestionMark() {
        PunctutationFilter punctutationFilter = new PunctutationFilter();
        String result = punctutationFilter.execute("sentence starts?");
        Assert.assertEquals("sentence starts", result);
    }

    @Test
    public void testRemoveQuestionMarkWithSpaceAsPrefix() {
        PunctutationFilter punctutationFilter = new PunctutationFilter();
        String result = punctutationFilter.execute("sentence starts ?");
        Assert.assertEquals("sentence starts", result);
    }

}