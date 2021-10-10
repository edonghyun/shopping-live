package com.example.demo.job;

import org.springframework.stereotype.Component;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;

import lombok.Getter;

@Component
public class CrawlerStepDecider implements JobExecutionDecider {
    private static final String JOB_STATUS = "JOB_STATUS";
    private static final String CONTINUE = "CONTINUE";
    private static final String FAILED = "FAILED";
    private static final String COMPLETED = "COMPLETED";

    @Override
    public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
        // String stepStatus = jobExecution.getExecutionContext().getString(JOB_STATUS);

        String stepStatus = CONTINUE;
        FlowExecutionStatus flowExecutionStatus = null;        
        if (CONTINUE.equals(stepStatus)) {
            flowExecutionStatus = new FlowExecutionStatus(CONTINUE);
        } else if (FAILED.equals(stepStatus)) {
            flowExecutionStatus = new FlowExecutionStatus(FAILED);
        } else {
            flowExecutionStatus = new FlowExecutionStatus(COMPLETED);
        }

        return flowExecutionStatus;
    }
}
