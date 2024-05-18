package com.example.project.bean;

import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnBean(TestBean.class)
@Log4j2
public class SecondBean {

    @PostConstruct
    public void init() {
        log.info("SecondBean created");
    }
}
