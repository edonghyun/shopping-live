package com.example.demo.crawler;

import java.util.List;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.example.demo.crawler.strategy.CrawlerStrategyInterface;

@RequiredArgsConstructor
@Component
@Slf4j
public class Crawler {
    private final List<CrawlerStrategyInterface> crawlerStrategies;

    public void run() {
        for(CrawlerStrategyInterface strategy : crawlerStrategies) {
            strategy.run();
        }
    }
}
