package com.manojLL.book_publication;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class BookPublicationApplication {

    public static void main(String[] args) {
        log.info("application starts");
        SpringApplication.run(BookPublicationApplication.class, args);
    }

}
