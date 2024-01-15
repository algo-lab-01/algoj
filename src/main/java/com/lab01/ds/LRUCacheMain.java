package com.lab01.ds;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCacheMain {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache();
        System.out.println(lruCache.getCache("1"));
        lruCache.addCache("1","First Cache");
        lruCache.addCache("2","Second cache");
        System.out.println(lruCache.queue);
        System.out.println(lruCache.getCache("1"));
        System.out.println(lruCache.queue);
        lruCache.addCache("3","Second cache");
        lruCache.addCache("4","Second cache");
        lruCache.addCache("5","Second cache");
        lruCache.addCache("6","Second cache");
        System.out.println("---"+lruCache.getCache("2"));
        System.out.println(lruCache.queue);
    }
}

class LRUCache{
    int maxSize = 5;
    Map<String, Object> cache = new HashMap<>();
    Deque<String> queue = new LinkedList<>();

    public Object getCache(String key){
        if (cache.containsKey(key)){
            queue.remove(key);
            queue.addLast(key);
        }
        return cache.getOrDefault(key, null);
    }

    public void addCache(String key, Object value){
        if(cache.containsKey(key)){
            queue.remove(key);
        }
        cache.put(key, value);
        if(maxSize == queue.size()){
            String keyFirst = queue.getFirst();
            cache.remove(keyFirst);
            queue.removeFirst();
        }
        queue.addLast(key);
    }

}