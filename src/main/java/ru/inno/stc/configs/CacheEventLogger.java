package ru.inno.stc.configs;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheEventLogger implements CacheEventListener<Object, Object> {
    private static final Logger logger = LoggerFactory.getLogger(CacheEventLogger.class);

    @Override
    public void onEvent(CacheEvent<?, ?> cacheEvent) {
        logger.info("Cache event {} for item with key {}. Old value = {}, New value = {}",
                    cacheEvent.getType(), cacheEvent.getKey(),
                    cacheEvent.getOldValue(), cacheEvent.getNewValue());
    }
}
