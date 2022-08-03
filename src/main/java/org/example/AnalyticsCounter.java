package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AnalyticsCounter {
    public static Map<Long,Long> Count(Map<Character,VisitorInfo>... input){
        Map<Long,Long> result = new HashMap<>();
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

                    if(visitCount.isPresent()){
                        result.put(visitorKey, result.getOrDefault(visitCount.get(), 0L) + 1);
                    }
                }
                catch(Exception e){
                    continue;
                }

            }
        }
        return result;
    }
}
