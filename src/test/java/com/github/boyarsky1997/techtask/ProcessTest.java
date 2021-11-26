package com.github.boyarsky1997.techtask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

public class ProcessTest {

    static Object[][] samplesNumberDuplicates() {
        return new Object[][]{
                {"RrsrAas", 2},
                {"RsrAa", 0},
                {"aa", 1},
                {"RRrraAaffA", 5},
                {"lllllll", 1},
                {"RrrrrfF", 1},
                {"", 0},
                {"RsRrddAafA", 3}
        };
    }

    static Object[][] samplesProcessing() {
        return new Object[][]{
                {Arrays.asList("ariacn", "avcd", "adddfga", "drrrrrddff", "kk"), 2, "avcddrrrrrddff"},
                {Arrays.asList("ariaacaaacn", "avcd", "adddfga", "drrrrrddff", "kdf"), 2, "avcd"},
                {Arrays.asList("aricn", "avcd", "adddfga", "drrrrrddff", "kkkkkkkkkkkkkddf"), 2, "drrrrrddff"},
                {Arrays.asList("ariannnnndnndnndndnn", "avcd", "adddfga", "drrrrrddff", "kkkkkkkkkkkkkddfdf"), 3, "avcd"},
                {Arrays.asList("ariannnnndndnn", "avcd", "adddfga", "drrrrrrrrrrrrrrrrrrddff", "kkkkkkkkkkkkkddfdf"), 3, "adddfgakkkkkkkkkkkkkddfdf"}
        };
    }

    static Object[][] samplesConcatenate() {
        return new Object[][]{
                {Arrays.asList("ariacn", "avcd", "adddfga", "drrrrrddff", "kk"), 2, "avcddrrrrrddff"},
                {Arrays.asList("ariaacaaacn", "avcd", "adddfga", "drrrrrddff", "kdf"), 0, "avcd"},
                {Arrays.asList("aricn", "avcd", "adddfga", "drrrrrddff", "kkkkkkkkkkkkkddf"), 1, "aricnadddfga"},
                {Arrays.asList("ariannnnndnndnndndnn", "avcd", "adddfga", "drrrrrddff", "kkkkkkkkkkkkkddfdf"), 3, "adddfgakkkkkkkkkkkkkddfdf"},
                {Arrays.asList("ariannnnndndnn", "avcd", "adddfga", "drrrrrrrrrrrrrrrrrrddff", "kkkkkkkkkkkkkddfdf"), 4, "drrrrrrrrrrrrrrrrrrddff"}
        };
    }

    @ParameterizedTest
    @MethodSource("samplesNumberDuplicates")
    public void testNumberDuplicates(String a, int expected) {

        Assertions.assertEquals(expected, Process.numberDuplicates(a));
    }

    @ParameterizedTest
    @MethodSource("samplesProcessing")
    public void testProcessing(List<String> a, int b, String expected) {

        Assertions.assertEquals(expected, Process.processing(a, b));
    }

    @ParameterizedTest
    @MethodSource("samplesConcatenate")
    public void testConcatenate(List<String> a, int b, String expected) {

        Assertions.assertEquals(expected, Process.concatenate(a, b));
    }
}