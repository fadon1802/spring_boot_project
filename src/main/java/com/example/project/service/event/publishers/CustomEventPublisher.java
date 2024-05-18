package com.example.project.service.event.publishers;

import com.example.project.event.TransactionalEvent;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Log4j2
public class CustomEventPublisher {

    final ApplicationEventPublisher applicationEventPublisher;

    public void publishCustomEvent(final String message) {
        log.info("Publishing custom event: " + message);
        applicationEventPublisher.publishEvent(new TransactionalEvent(this, message));
    }
}
