package com.example.project.service.listeners;

import com.example.project.event.AsyncEvent;
import com.example.project.event.CustomEvent;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class EventsListener {

    @EventListener
    public void onCustomEvent(CustomEvent event) {
        log.info("Handled custom event: " + event.getMessage());
    }

    @Async
    @EventListener
    public void onAsyncEvent(AsyncEvent event) {
        log.info("Handled async event: " + event.getMessage());
    }
}