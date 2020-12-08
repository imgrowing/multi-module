package ex.sample;

import ex.support.TimestampJobParameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static ex.sample.SampleTaskletJobConfig.JOB_NAME;

@Slf4j
@RequiredArgsConstructor
@Configuration
@ConditionalOnProperty(name = "job.name", havingValue = JOB_NAME)
public class SampleTaskletJobConfig {

    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    protected static final String JOB_NAME = "sampleTaskletJob";

    @Bean
    public Job job() {
        return jobBuilderFactory.get(JOB_NAME)
                .start(step())
                .incrementer(new TimestampJobParameter())
                .build();
    }

    @Bean
    public Step step() {
        return stepBuilderFactory.get(JOB_NAME + "Step")
                .tasklet((contribution, chunkContext) -> {

                    log.warn("HELLO SPRING BATCH !!!");

                    return RepeatStatus.FINISHED;
                })
                .build();
    }
}
