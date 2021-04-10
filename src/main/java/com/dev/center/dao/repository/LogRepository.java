package com.dev.center.dao.repository;

import java.util.List;

import com.dev.center.dao.LogRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends MongoRepository<LogRecord, String> {

    @Override
    LogRecord save(LogRecord lr);

}
