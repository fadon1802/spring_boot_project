package com.example.project.service.common;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@FieldDefaults(makeFinal=true, level=AccessLevel.PRIVATE)
@Component
public class AnotherWorker implements WorkerInterface {
    int id = 0;

    public void doWork() {
        log.info("worker with id {} is working", id);
    }
}
