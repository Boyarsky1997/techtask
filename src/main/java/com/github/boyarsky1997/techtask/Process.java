package com.github.boyarsky1997.techtask;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Process {
    public static String processing(List<String> values, int maxDuplicates) {
        int largestString = 0;
        int index = 0;
        for (int i = 0; i < values.size(); i++) {
            String value = values.get(i);
            if (value.length() > largestString) {
                if (numberDuplicates(value) <= maxDuplicates) {
                    largestString = values.get(i).length();
                    index = i;
                }
            }
        }
        return concatenate(values, index);
    }

    public static String concatenate(List<String> values, int index) {
        if (index == 0) {
            return values.get(index + 1);
        } else if (index == values.size() - 1) {
            return values.get(index - 1);
        }
        return values.get(index - 1) + (values.get(index + 1));
    }

    public static int numberDuplicates(String word) {
        Set<Character> tmp = new HashSet<>();
        for (int i = 0; i < word.length() - 1; i++) {
            if (tmp.contains(word.charAt(i))) {
                continue;
            }
            for (int c = i + 1; c < word.length(); c++) {
                if (word.charAt(i) == word.charAt(c)) {
                    tmp.add(word.charAt(i));
                    break;
                }
            }
        }
        return tmp.size();
    }
}
