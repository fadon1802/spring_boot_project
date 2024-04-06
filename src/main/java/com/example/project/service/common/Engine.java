package com.example.project.service.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Engine {
    public void startWork() {
        log.info("engine is working");
    }

    @PostConstruct
    public void init() {
        log.info("created " + this.getClass().getSimpleName());
    }

    @PreDestroy
    public void destroy() {
        log.info("destroyed " + this.getClass().getSimpleName());
    }
}
