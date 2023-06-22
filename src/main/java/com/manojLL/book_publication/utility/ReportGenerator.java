package com.manojLL.book_publication.utility;

import com.manojLL.book_publication.dao.AuthorDao;
import com.manojLL.book_publication.entity.Author;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class ReportGenerator {
    @Autowired
    AuthorDao authorDao;

    @Scheduled(fixedRate = 300000)
    public void logAuthorCount(){
        List<Author> authors = authorDao.findAll();
        log.info("number of authors : "+ authors.size());
    }
}
