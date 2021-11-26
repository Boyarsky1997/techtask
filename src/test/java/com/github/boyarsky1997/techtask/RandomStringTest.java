package com.github.boyarsky1997.techtask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

public class RandomStringTest {

    @RepeatedTest(1000)
    public void testNextString() {
        RandomString randomString = new RandomString();

        String actual = randomString.nextString(3, 5);

        Assertions.assertTrue(actual.length() <= 5);
        Assertions.assertTrue(actual.length() >= 3);
    }
}