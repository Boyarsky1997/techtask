package com.github.boyarsky1997.techtask;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        RandomString randomString = new RandomString();
        List<String> strings = new ArrayList<>();
        for (int i = 0;i<10; i++){
            strings.add(randomString.nextString());
        }
        System.out.println( Process.processing(strings,2));
    }

}
