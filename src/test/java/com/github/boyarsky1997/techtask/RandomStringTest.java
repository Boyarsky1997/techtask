package com.github.boyarsky1997.techtask;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class RandomStringTest {
    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Test
    @Repeat(10000)
    public void testNextString(){
        RandomString randomString = new RandomString();
        String actual = randomString.nextString(3, 5);
        Assert.assertTrue(actual.length()<=5&&actual.length()>=3);
    }

}