package com.example.project.bean;

import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@ConditionalOnExpression(value = "!'${environment.variable}'.equals('default')")
public class ThirdBean {

    @PostConstruct
    public void init() {
        log.info("ThirdBean created");
    }
}
