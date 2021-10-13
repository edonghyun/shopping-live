package com.example.demo.crawler;

import java.util.List;
import java.util.LinkedList;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.example.demo.crawler.strategy.CrawlerStrategyInterface;
import com.example.demo.core.dto.BroadcastCreateDto;
import com.example.demo.helper.ModelMapper;

@RequiredArgsConstructor
@Component
@Slf4j
public class Crawler {
    private final List<CrawlerStrategyInterface> crawlerStrategies;
    private final ModelMapper modelMapper;

    public List<BroadcastCreateDto> run() {
        List<BroadcastCreateDto> results = new LinkedList();
        for(CrawlerStrategyInterface crawlerStrategy : crawlerStrategies) {
            results.addAll(
                crawlerStrategy.parse()
                    .stream()
                    .map((object) -> modelMapper.map(
                        object, BroadcastCreateDto.class
                    ))
                    .collect(Collectors.toList())
            );
        }
        return results;
    }
}
