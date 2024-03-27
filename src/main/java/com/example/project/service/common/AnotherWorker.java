package com.example.project.service.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class AnotherWorker implements WorkerInterface {
    private static final Logger log = LogManager.getLogger(AnotherWorker.class);
    private final int id = 0;

    public void doWork() {
        log.info("worker with id {} is working", id);
    }
}
