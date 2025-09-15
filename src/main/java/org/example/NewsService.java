package org.example;

import io.micronaut.cache.annotation.CacheConfig;
import io.micronaut.cache.annotation.Cacheable;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Singleton
@CacheConfig("news")
public class NewsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewsService.class);

    @Cacheable
    public List<String> getNews(String category) {
        LOGGER.debug("Retrieving news for {}", category);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            return List.of();
        }
        return List.of("news");
    }

}
