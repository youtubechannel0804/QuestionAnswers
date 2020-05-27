package com.sahaj.questionanswers.filter;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LowerCaseFilterTest {

    @Test
    public void testAllCapitalLetter(){
        LowerCaseFilter lowerCaseFilter = new LowerCaseFilter();
        String result = lowerCaseFilter.execute("ABC DEF");
        Assert.assertEquals("abc def",result);
    }

    @Test
    public void testCamelCase(){
        LowerCaseFilter lowerCaseFilter = new LowerCaseFilter();
        String result = lowerCaseFilter.execute("Test Test");
        Assert.assertEquals("test test",result);
    }

}