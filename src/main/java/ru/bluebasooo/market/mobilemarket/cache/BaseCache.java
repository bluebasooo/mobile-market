package ru.bluebasooo.market.mobilemarket.cache;

import java.util.*;

public class BaseCache<Key, Value> { //TODO implement LRU + shard

    private static final int MAX_CACHE_SIZE = 1024;

    private final LinkedHashMap<Key, Value> hotCache;

    private final Map<Key, Value> old;

    public BaseCache() {
        hotCache = new LinkedHashMap<>();
        old = new HashMap<>();
    }

    public int getOldSize() {
        return old.size();
    }

    public boolean contains(Key key) {
        return hotCache.containsKey(key);
    }

    public Value get(Key key) {
        return hotCache.get(key);
    }

    public void put(Key key, Value value) {
        if (hotCache.containsKey(key)) {
            hotCache.remove(key);
            hotCache.put(key, value);
            return;
        }

        if(old.containsKey(key)) { //?
            old.remove(key);
        }

        hotCache.put(key, value);
        if (hotCache.size() > MAX_CACHE_SIZE) {
            cleanCache();
        }
    }

    public Collection<Value> getOld() {
        var toFetch = Set.copyOf(old.values());
        old.clear();
        return toFetch;
    }

    private void cleanCache() {
        hotCache.entrySet()
                .stream()
                .skip(MAX_CACHE_SIZE - 1)
                .forEach(entry -> {
                    var removed = hotCache.remove(entry.getKey());
                    old.put(entry.getKey(), entry.getValue());
                });
    }
}
