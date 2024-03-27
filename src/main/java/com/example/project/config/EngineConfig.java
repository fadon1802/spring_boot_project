package com.example.project.config;

import com.example.project.service.common.Engine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EngineConfig {

    @Bean
    public Engine engine() {
        return new Engine();
    }
}
