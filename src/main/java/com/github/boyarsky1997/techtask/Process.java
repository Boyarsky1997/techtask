package com.github.boyarsky1997.techtask;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Process {
    public static String processing(List<String> values, int maxDuplicates) {
        StringBuilder result = new StringBuilder();
        List<String> collect = values.stream().filter(s -> numberDuplicates(s) <= maxDuplicates && numberDuplicates(s) >= 1)
                .collect(Collectors.toList());
        System.out.println(collect);
        String word = collect.stream()
                .max(Comparator.comparing(String::length)).get();
        for (int i = 0; i < collect.size(); i++) {
            if (collect.get(i).equals(word)) {
                if (i == 0) {
                    result.append(collect.get(i + 1));
                    break;
                } else if (i == collect.size() - 1) {
                    result.append(collect.get(i - 1));
                    break;
                }
                result.append(collect.get(i - 1)).append(collect.get(i + 1));
            }
        }
        return result.toString();
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
                }
            }
        }
        return tmp.size();
    }
}
