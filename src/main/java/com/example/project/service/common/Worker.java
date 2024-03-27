package com.example.project.service.common;

import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Worker implements WorkerInterface {
    private static final Logger log = org.apache.logging.log4j.LogManager.getLogger(Worker.class);
    private final int id = 1;

    public void doWork() {
        log.info("worker with id {} is working", id);
    }
}
