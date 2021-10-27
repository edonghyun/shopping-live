package com.example.demo.crawler.strategy;

import java.util.List;
import com.example.demo.core.dto.BroadcastCreateDto;

public interface CrawlerStrategyInterface {
    List<BroadcastCreateDto> parse();
}