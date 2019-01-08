package com.insurance.verificationsystem.cache;

import org.ehcache.Cache;

import java.time.Duration;
import java.time.LocalDateTime;

import static java.util.Objects.requireNonNull;

public class LastUpdatedTimeProvider {

    private final Cache<String, LocalDateTime> lastUpdatedTimeCache;

    private final String KEY = "last_updated_cache_time";

    public LastUpdatedTimeProvider(Cache<String, LocalDateTime> lastUpdatedTimeCache) {
        this.lastUpdatedTimeCache = requireNonNull(lastUpdatedTimeCache);
    }

    public void cacheUpdated() {
        this.lastUpdatedTimeCache.put(KEY, LocalDateTime.now());
    }

    public Duration timeFromLastUpdate() {
        LocalDateTime localDateTime = this.lastUpdatedTimeCache.get(KEY);
        if(localDateTime == null) {
            return Duration.ofDays(100);
        }
        return Duration.between(LocalDateTime.now(), localDateTime);
    }


}
