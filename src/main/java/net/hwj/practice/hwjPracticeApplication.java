package net.hwj.practice;

import net.hwj.practice.properties.ApiProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

@Slf4j
@SpringBootApplication
@EnableConfigurationProperties({
        ApiProperties.class
})
@EnableCaching
public class hwjPracticeApplication {
    public static void main(String[] args) {
        SpringApplication.run(hwjPracticeApplication.class, args);
    }
}
