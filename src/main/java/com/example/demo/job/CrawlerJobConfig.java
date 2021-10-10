package com.example.demo.job;

import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.repeat.RepeatStatus;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.example.demo.tasklet.CrawlerTasklet;
import com.example.demo.crawler.Crawler;
import com.example.demo.crawler.strategy.CrawlerStrategyInterface;
import com.example.demo.job.CrawlerStepDecider;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class CrawlerJobConfig {
    private final List<CrawlerStrategyInterface> crawlerStrategyList;
    private final CrawlerStepDecider crawlerStepDecider;
    private final Crawler cralwer;
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;


    @Bean
    public Job crawlerJob() {
        return jobBuilderFactory.get("crawlerJob")
            .start(step())
            .build();
    }

    @Bean
    public Step step() {
        return stepBuilderFactory.get("crawlData")
            .tasklet(new CrawlerTasklet(cralwer))
            .build();
    }

}