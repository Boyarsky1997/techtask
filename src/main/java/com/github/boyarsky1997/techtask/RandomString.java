package com.github.boyarsky1997.techtask;

import java.util.Random;

public class RandomString {
    private static final char[] DICTIONARY =
            "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm".toCharArray();
    private static final int MIN_VALUE = 2;
    private static final int MAX_VALUE = 10;

    private final Random random;

    public RandomString() {
        this.random = new Random();
    }

    public RandomString(long seed) {
        this.random = new Random(seed);
    }

    public String nextString() {
        return nextString(MIN_VALUE, MAX_VALUE);
    }

    public String nextString(int min, int max) {
        int length = random.nextInt(max - min) + min;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= length; i++) {
            result.append(DICTIONARY[random.nextInt(DICTIONARY.length - 1)]);
        }
        return result.toString();
    }
}
