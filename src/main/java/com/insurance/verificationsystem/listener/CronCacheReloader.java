package com.insurance.verificationsystem.listener;

import com.insurance.verificationsystem.cache.VehiclesCacheLoader;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Objects;

public class CronCacheReloader {

    private final VehiclesCacheLoader cacheLoader;

    public CronCacheReloader(VehiclesCacheLoader cacheLoader) {
        this.cacheLoader = Objects.requireNonNull(cacheLoader);
    }

    @Scheduled(cron = "${verificationsystem.reload.cron:-}")
    public void reload() {
        this.cacheLoader.reload();
    }

}
