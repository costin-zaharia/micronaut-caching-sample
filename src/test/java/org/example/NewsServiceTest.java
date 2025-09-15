package org.example;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@MicronautTest(startApplication = false)
public class NewsServiceTest {

    @Inject
    NewsService sut;

    @Timeout(4)
    @Test
    @Order(1)
    void getNews_firstCall_retrievesNews() {
        var result = sut.getNews("category");

        assertNotNull(result);
    }

    @Timeout(1)
    @Test
    @Order(2)
    void  getNews_secondCall_hitsCache() {
        var result = sut.getNews("category");

        assertNotNull(result);
    }
}
