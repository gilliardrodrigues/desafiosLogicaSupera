package util;

import java.util.HashMap;
import java.util.Map;

public class Counter<T> {
	
    private Map<T, Integer> counterMap;
    
    public Counter() {
        counterMap = new HashMap<>();
    }

    public void increment(T element) {
        counterMap.put(element, counterMap.getOrDefault(element, 0) + 1);
    }

    public void decrement(T element) {
    	
        int count = counterMap.getOrDefault(element, 0);
        
        if (count > 0)
            counterMap.put(element, count - 1);
    }

    public int getCount(T element) {
    	
        return counterMap.getOrDefault(element, 0);
    }

    public boolean contains(T element) {
    	
        return counterMap.containsKey(element);
    }

    public void clear() {
    	
        counterMap.clear();
    }

    public int size() {
    	
        return counterMap.size();
    }

    public void printCounts() {
    	
        for (Map.Entry<T, Integer> entry : counterMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public Map<T, Integer> getCountMap() {
    	
        return counterMap;
    }
}

