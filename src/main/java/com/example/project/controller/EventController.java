package com.example.project.controller;

import com.example.project.service.event.publishers.AsyncEventPublisher;
import com.example.project.service.event.publishers.CustomEventPublisher;
import com.example.project.service.event.publishers.TransactionalEventPublisher;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class EventController {
    private final AsyncEventPublisher asyncEventPublisher;
    private final CustomEventPublisher customEventPublisher;
    private final TransactionalEventPublisher transactionalEventPublisher;

    @GetMapping("/publish")
    public String publishEvents() {
        customEventPublisher.publishCustomEvent("custom event 1");
        asyncEventPublisher.publishAsyncEvent("async event 1");
        return "Events published";
    }

    @GetMapping("/publishTransactional")
    public String publishTransactionalEvents() {
        try {
            transactionalEventPublisher.publishTransactionalEvent("transactional event 1");
            transactionalEventPublisher.publishTransactionalEventWithRollback("transactional event 2");
        } catch (Exception e) {
            return "Transactional events published";
        }

        return "Transactional events published";
    }
}
