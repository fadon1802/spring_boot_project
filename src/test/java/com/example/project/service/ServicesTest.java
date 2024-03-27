package com.example.project.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServicesTest {
    @Autowired
    private FirstService firstService;
    @Autowired
    private SecondService secondService;
    @Autowired
    private ThirdService thirdService;

    @Autowired
    private WorkerService workerService;

    @Test
    public void test1() {
        firstService.useEngine();
    }

    @Test
    public void test2() {
        secondService.useEngine();
    }

    @Test
    public void test3() {
        thirdService.useEngine();
    }

    @Test
    public void testInterfaces() {
        workerService.worker1.doWork();
        workerService.worker2.doWork();
    }
}