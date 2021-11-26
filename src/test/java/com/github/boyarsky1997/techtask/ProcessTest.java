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
    public void testNumberDuplicatesEqualsNull() {
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
        Assertions.assertEquals("ariacnkk", actual);
    }

    @Test
    public void testProcessing1() {
        List<String> strings = Arrays.asList("ariacn", "avcd", "adddfga", "drrrrrddff", "kdf");
        String actual = Process.processing(strings, 2);
        Assertions.assertEquals("ariacn", actual);
    }

    @Test
    public void testProcessing2() {
        List<String> strings = Arrays.asList("aricn", "avcd", "adddfga", "drrrrrddff", "kddf");
        String actual = Process.processing(strings, 2);
        Assertions.assertEquals("kddf", actual);
    }

}