package com.example.project.service;

import com.example.project.service.common.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirstService {
    @Autowired
    Engine engine;

    public void useEngine() {
        engine.startWork();
    }
}
