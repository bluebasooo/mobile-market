package ru.bluebasooo.market.mobilemarket.cache;

import ru.bluebasooo.market.mobilemarket.entity.basket.BasketEntity;

import java.util.*;

public class BaseCache<Key, Value> { //TODO implement LRU + shard

    private LinkedHashMap<Key, Value> hotCache;

    private Map<Key, Value> old;

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


    }

    public Collection<Value> getOld() {
        var toFetch = Set.copyOf(old.values());
        old.clear();
        return toFetch;
    }

}
