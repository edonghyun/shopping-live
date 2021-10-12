package com.example.demo.crawler.scheduler;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CrawlerScheduler {

    private final Job job;
    private final JobLauncher jobLauncher;

    @Scheduled(fixedDelay = 60 * 1000L)
    public void executeJob () {
        try {
            jobLauncher.run(
                    job,
                    new JobParametersBuilder()
                            .addString("datetime", LocalDateTime.now().toString())
                    .toJobParameters()
            );
        } catch (JobExecutionException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

}