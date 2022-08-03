package org.example;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Character, VisitorInfo>[] input = new Map[1];
        input[0] = new java.util.HashMap<>();
        Map<Long, Long> result = AnalyticsCounter.Count(input);
    }
}