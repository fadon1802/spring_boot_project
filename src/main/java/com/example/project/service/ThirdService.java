package com.example.project.service;

import com.example.project.service.common.Engine;
import org.springframework.stereotype.Service;

@Service
public class ThirdService {
    Engine engine;

    public ThirdService(Engine engine) {
        this.engine = engine;
    }

    public void useEngine() {
        engine.startWork();
    }
}
