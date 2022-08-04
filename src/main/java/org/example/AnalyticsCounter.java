package org.example;

import java.util.*;

public class AnalyticsCounter {
    public static Map<Long,Long> Count(Map<Character,VisitorInfo>... input){
        Map<Long,Long> visitorCounts = new HashMap<>();
/*        Arrays.stream(input)
                .filter(Objects::nonNull)
                .flatMap(map -> map.entrySet().stream())
                .filter(entry -> entry.getValue() != null)
                .forEach((entry -> {
                    VisitorInfo visitorInfo = entry.getValue();
                    try{
                        Long visitorKey = Long.parseLong(entry.getKey().toString());
                        Optional<Long> visitCount = visitorInfo.getVisitCount();
                        visitCount.ifPresent(count -> visitorCounts.put(visitorKey, visitorCounts.getOrDefault(visitorKey, 0L) + count));
                    }
                    catch(Exception e){
                        // do nothing
                    }
                }));*/
        for(Map<Character, VisitorInfo> visitorInfoMap : input){
            if(visitorInfoMap == null){
                continue;
            }
            for(Map.Entry<Character, VisitorInfo> entry : visitorInfoMap.entrySet()){
                VisitorInfo visitorInfo = entry.getValue();
                if(visitorInfo == null){
                    continue;
                }
                try{
                    Long visitorKey = Long.parseLong(entry.getKey().toString());
                    Optional<Long> visitCount = visitorInfo.getVisitCount();
                    visitCount.ifPresent(count -> visitorCounts.put(visitorKey, visitorCounts.getOrDefault(visitorKey, 0L) + count));
                }
                catch(Exception e){
                    continue;
                }

            }
        }
        return visitorCounts;
    }
}
