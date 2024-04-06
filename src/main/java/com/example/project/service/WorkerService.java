package com.example.project.service;

import com.example.project.service.common.WorkerInterface;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Service
public class WorkerService {
    @Autowired
    @Qualifier("worker")
    WorkerInterface worker1;

    @Autowired
    @Qualifier("anotherWorker")
    WorkerInterface worker2;

}
