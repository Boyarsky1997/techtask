package com.github.boyarsky1997.techtask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

public class ProcessTest {

    static Object[][] testNumberDuplicates() {
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

    static Object[][] testProcessing() {
        return new Object[][]{
                {Arrays.asList("ariacn", "avcd", "adddfga", "drrrrrddff", "kk"), 2, "avcddrrrrrddff"},
                {Arrays.asList("ariaacaaacn", "avcd", "adddfga", "drrrrrddff", "kdf"), 2, "avcd"},
                {Arrays.asList("aricn", "avcd", "adddfga", "drrrrrddff", "kkkkkkkkkkkkkddf"), 2, "drrrrrddff"},
                {Arrays.asList("ariannnnndnndnndndnn", "avcd", "adddfga", "drrrrrddff", "kkkkkkkkkkkkkddfdf"), 3, "avcd"},
                {Arrays.asList("ariannnnndndnn", "avcd", "adddfga", "drrrrrrrrrrrrrrrrrrddff", "kkkkkkkkkkkkkddfdf"), 3, "adddfgakkkkkkkkkkkkkddfdf"}
        };
    }

    static Object[][] testConcatenate() {
        return new Object[][]{
                {Arrays.asList("ariacn", "avcd", "adddfga", "drrrrrddff", "kk"), 2, "avcddrrrrrddff"},
                {Arrays.asList("ariaacaaacn", "avcd", "adddfga", "drrrrrddff", "kdf"), 0, "avcd"},
                {Arrays.asList("aricn", "avcd", "adddfga", "drrrrrddff", "kkkkkkkkkkkkkddf"), 1, "aricnadddfga"},
                {Arrays.asList("ariannnnndnndnndndnn", "avcd", "adddfga", "drrrrrddff", "kkkkkkkkkkkkkddfdf"), 3, "adddfgakkkkkkkkkkkkkddfdf"},
                {Arrays.asList("ariannnnndndnn", "avcd", "adddfga", "drrrrrrrrrrrrrrrrrrddff", "kkkkkkkkkkkkkddfdf"), 4, "drrrrrrrrrrrrrrrrrrddff"}
        };
    }

    @ParameterizedTest
    @MethodSource("testNumberDuplicates")
    public void dataProviderTest1(String a, int expected) {
        Assertions.assertEquals(expected, Process.numberDuplicates(a));
    }

    @ParameterizedTest
    @MethodSource("testProcessing")
    public void dataProviderTest2(List<String> a, int b, String expected) {
        Assertions.assertEquals(expected, Process.processing(a, b));
    }

    @ParameterizedTest
    @MethodSource("testConcatenate")
    public void dataProviderTest3(List<String> a, int b, String expected) {
        Assertions.assertEquals(expected, Process.concatenate(a, b));
    }
}