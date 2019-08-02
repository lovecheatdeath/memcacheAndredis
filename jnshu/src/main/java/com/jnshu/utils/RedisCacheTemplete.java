package com.jnshu.utils;

import org.springframework.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;

public interface RedisCacheTemplete {

    String getName();

    Object getNativeCache();

    Cache.ValueWrapper get(Object key);

    void put(Object key, Object value);

    void evict(Object key);

    void clear();

    <T> T get(Object key, Class<T> type);

    Cache.ValueWrapper putIfAbsent(Object key, Object value);
}
