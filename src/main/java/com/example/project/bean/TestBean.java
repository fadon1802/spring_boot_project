package com.example.project.bean;

import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@Profile("test")
public class TestBean {

    @PostConstruct
    public void init() {
        log.info("TestBean created");
    }
}
