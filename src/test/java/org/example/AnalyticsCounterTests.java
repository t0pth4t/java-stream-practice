package org.example;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Optional;

public class AnalyticsCounterTests {
    @Test
    public void testAnalyticsCounter() {
        Map<Character, VisitorInfo>[] input = new Map[1];
        Map<Character, VisitorInfo> visitorInfoMap = new java.util.HashMap<>();
        visitorInfoMap.put('1', new VisitorInfo(Optional.of(1L)));
        input[0] = visitorInfoMap;
        Map<Long, Long> result = AnalyticsCounter.Count(input);
        assert result.get(1L) == 1L;
    }
    @Test
    public void testAnalyticsCounterWorksWithTwo() {
        Map<Character, VisitorInfo>[] input = new Map[2];

        Map<Character, VisitorInfo> visitorInfoMapOne = new java.util.HashMap<>();
        visitorInfoMapOne.put('1', new VisitorInfo(Optional.of(1L)));
        input[0] = visitorInfoMapOne;

        Map<Character, VisitorInfo> visitorInfoMapTwo = new java.util.HashMap<>();
        visitorInfoMapTwo.put('1', new VisitorInfo(Optional.of(2L)));
        input[1] = visitorInfoMapTwo;

        Map<Long, Long> result = AnalyticsCounter.Count(input);
        assert result.get(1L) == 3L;
    }

    @Test
    public void testAnalyticsCounterWorksWithNullMaps() {
        Map<Character, VisitorInfo>[] input = new Map[2];
        Map<Character, VisitorInfo> visitorInfoMapOne = new java.util.HashMap<>();
        visitorInfoMapOne.put('1', new VisitorInfo(Optional.of(1L)));
        input[0] = visitorInfoMapOne;
        input[1] = null;
        Map<Long, Long> result = AnalyticsCounter.Count(input);
        assert result.get(1L) == 1L;
    }

}
