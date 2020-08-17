package ru.inno.stc.configs;

import org.ehcache.CacheManager;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.core.EhcacheManager;
import org.ehcache.core.config.DefaultConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.inno.stc.model.User;

@Configuration
public class CachingConfig {

}
