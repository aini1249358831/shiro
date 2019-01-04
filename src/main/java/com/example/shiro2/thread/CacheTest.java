package com.example.shiro2.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheTest {
    private Map<String, Object> map = new HashMap<>();

    public static void main(String[] args) {

    }

    public Object getData(String key) {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        Object value = null;
        try {
            readWriteLock.readLock().lock();
            value = map.get(key);
            if (value == null) {
                readWriteLock.readLock().unlock();
                readWriteLock.writeLock().lock();
                try {
                    if (value == null) {
                        value = "abcd";
                        map.put(key, value);

                    }

                } finally {
                    readWriteLock.writeLock().unlock();
                }

            }
        } finally {
            readWriteLock.readLock().unlock();

        }
        return value;


    }


}
