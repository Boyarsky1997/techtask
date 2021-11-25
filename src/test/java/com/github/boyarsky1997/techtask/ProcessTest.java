package com.github.boyarsky1997.techtask;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class ProcessTest {
    @Test
    public void testNumberDuplicates() {
        int actual = Process.numberDuplicates("RrsrAas");
        Assert.assertEquals(2, actual);
    }

    @Test
    public void testNumberDuplicatesEqualsNull() {
        int actual = Process.numberDuplicates("RsrAa");
        Assert.assertEquals(0, actual);
    }

    @Test
    public void testNumberDuplicatesEqualUpperChars() {
        int actual = Process.numberDuplicates("RsRrAafA");
        Assert.assertEquals(2, actual);
    }

    @Test
    public void testProcessing() {
        List<String> strings = Arrays.asList("ariacn", "avcd", "adddfga", "drrrrrddff","kk");
        String actual = Process.processing(strings, 2);
        Assert.assertEquals("ariacnkk", actual);
    }
    @Test
    public void testProcessing1() {
        List<String> strings = Arrays.asList("ariacn", "avcd", "adddfga", "drrrrrddff","kdf");
        String actual = Process.processing(strings, 2);
        Assert.assertEquals("ariacn", actual);
    }
    @Test
    public void testProcessing2() {
        List<String> strings = Arrays.asList("aricn", "avcd", "adddfga", "drrrrrddff","kddf");
        String actual = Process.processing(strings, 2);
        Assert.assertEquals("kddf", actual);
    }

}