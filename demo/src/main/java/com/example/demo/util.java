package com.example.demo;

import java.util.Iterator;
import java.util.Map;

public class util {
    public static Map.Entry<String, Double> getMax(Map<String, Double> map){
        if (map.size() == 0){
            return null;
        }
        Map.Entry<String, Double> maxEntry = null;
        boolean flag = false;
        Iterator<Map.Entry<String, Double>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Double> entry = iterator.next();
            if (!flag){
                maxEntry = entry;
                flag = true;
            }
            if (entry.getValue() > maxEntry.getValue()){
                maxEntry = entry;
            }
        }
        map.remove(maxEntry.getKey());
        return maxEntry;
    }
}
