package com.github.boyarsky1997.techtask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ProcessTest {
    @Test
    public void testNumberDuplicates() {
        int actual = Process.numberDuplicates("RrsrAas");
        Assertions.assertEquals(2, actual);
    }

    @Test
    public void testNumberDuplicatesEqualsZero() {
        int actual = Process.numberDuplicates("RsrAa");
        Assertions.assertEquals(0, actual);
    }

    @Test
    public void testNumberDuplicatesEqualUpperChars() {
        int actual = Process.numberDuplicates("RsRrAafA");
        Assertions.assertEquals(2, actual);
    }

    @Test
    public void testProcessing() {
        List<String> strings = Arrays.asList("ariacn", "avcd", "adddfga", "drrrrrddff", "kk");
        String actual = Process.processing(strings, 2);
        Assertions.assertEquals("avcddrrrrrddff", actual);
    }

    @Test
    public void testProcessing1() {
        List<String> strings = Arrays.asList("ariaacaaacn", "avcd", "adddfga", "drrrrrddff", "kdf");
        String actual = Process.processing(strings, 2);
        Assertions.assertEquals("avcd", actual);
    }

    @Test
    public void testProcessing2() {
        List<String> strings = Arrays.asList("aricn", "avcd", "adddfga", "drrrrrddff", "kkkkkkkkkkkkkddf");
        String actual = Process.processing(strings, 2);
        Assertions.assertEquals("drrrrrddff", actual);
    }

}