package ex;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class ModuleBatchApplication {
    public static void main(String[] args) {
        SpringApplication.run(ModuleBatchApplication.class, args);
    }
}
