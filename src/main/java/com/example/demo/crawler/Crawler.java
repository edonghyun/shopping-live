package com.example.demo.crawler;

import java.util.List;
import java.util.LinkedList;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.example.demo.crawler.strategy.CrawlerStrategyInterface;
import com.example.demo.core.dto.BroadcastCreateDto;

@RequiredArgsConstructor
@Component
@Slf4j
public class Crawler {
    private final List<CrawlerStrategyInterface> crawlerStrategies;
    public List<BroadcastCreateDto> run() {
        List<BroadcastCreateDto> results = new LinkedList();
        for(CrawlerStrategyInterface crawlerStrategy : crawlerStrategies) {
            results.addAll(crawlerStrategy.parse());
        }
        return results;
    }
}
