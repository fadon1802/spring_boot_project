package com.example.project.service.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Engine {
    private final Logger logger = LogManager.getLogger("INFO");
    public void startWork() {
        logger.info("engine is working");
    }

    @PostConstruct
    public void init() {
        logger.info("created " + this.getClass().getSimpleName());
    }

    @PreDestroy
    public void destroy() {
        logger.info("destroyed " + this.getClass().getSimpleName());
    }
}
