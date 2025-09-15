package org.example;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.List;

@Controller("/hello")
public class HelloController {

    private final NewsService newsService;

    public HelloController(NewsService newsService) {
        this.newsService = newsService;
    }


    @Get(produces = MediaType.TEXT_PLAIN)
    public String index() {
        return "Hello World";
    }

    @Get(produces = MediaType.APPLICATION_JSON, value = "/news")
    public List<String> news() {
        return newsService.getNews("category");
    }

}