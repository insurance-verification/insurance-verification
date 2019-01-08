package com.insurance.verificationsystem.listener;

import com.insurance.verificationsystem.cache.VehiclesCacheLoader;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import static java.util.Objects.requireNonNull;

public class StartUpCacheLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final VehiclesCacheLoader cacheLoader;
    private final boolean loadOnStartUp;

    public StartUpCacheLoader(VehiclesCacheLoader cacheLoader, boolean loadOnStartUp) {
        this.cacheLoader = requireNonNull(cacheLoader);
        this.loadOnStartUp = loadOnStartUp;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(this.loadOnStartUp) {
            this.cacheLoader.reload();
        }
    }
}
