package com.example.demo.crawler.tasklet;

import java.util.List;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.item.ExecutionContext;

import org.springframework.batch.repeat.RepeatStatus;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.example.demo.crawler.Crawler;
import com.example.demo.core.service.BroadcastService;

@Slf4j
@RequiredArgsConstructor
public class CrawlerTasklet implements Tasklet {
    private final Crawler crawler;
    private final BroadcastService broadcastService;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        return RepeatStatus.FINISHED;
    }
}