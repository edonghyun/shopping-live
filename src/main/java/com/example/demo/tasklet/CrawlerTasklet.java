package com.example.demo.tasklet;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.item.ExecutionContext;

import org.springframework.batch.repeat.RepeatStatus;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.example.demo.crawler.Crawler;

@Slf4j
@RequiredArgsConstructor
public class CrawlerTasklet implements Tasklet, StepExecutionListener {
    private final Crawler cralwer;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        String value = (String) chunkContext
                                    .getStepContext()
                                    .getStepExecution()
                                    .getJobExecution()
                                    .getExecutionContext()
                                    .get("key");

        cralwer.run();
        return RepeatStatus.FINISHED;
    }
    
    @Override
    public void beforeStep(StepExecution stepExecution) {
        ExecutionContext jobExecutionContext = stepExecution
                                        .getJobExecution()
                                        .getExecutionContext();
        log.info("before::{}", jobExecutionContext.get("key"));
        jobExecutionContext.put("key", "before");
	}
    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        ExecutionContext jobExecutionContext = stepExecution
                                                .getJobExecution()
                                                .getExecutionContext();

        jobExecutionContext.put("key", "after");
        log.info("after::{}", jobExecutionContext.get("key"));
        return null;
    }

}