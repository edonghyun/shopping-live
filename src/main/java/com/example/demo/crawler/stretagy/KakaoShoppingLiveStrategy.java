package com.example.demo.crawler.strategy;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.crawler.strategy.CrawlerStrategyInterface;
import com.example.demo.core.dto.BroadcastCreateDto;

public class KakaoShoppingLiveStrategy implements CrawlerStrategyInterface {
    public List<BroadcastCreateDto> parse() {
        return null;
    }
}