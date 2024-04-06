package com.example.project.service;

import com.example.project.service.common.Engine;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
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
