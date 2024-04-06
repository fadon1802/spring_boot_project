package com.example.project.service;

import com.example.project.service.common.Engine;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
public class FirstService {
    @Autowired
    Engine engine;

    public void useEngine() {
        engine.startWork();
    }
}
