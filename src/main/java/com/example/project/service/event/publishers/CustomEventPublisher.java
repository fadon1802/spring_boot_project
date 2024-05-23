package com.example.project.service.event.publishers;

import com.example.project.event.CustomEvent;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Log4j2
public class CustomEventPublisher {

    ApplicationEventPublisher applicationEventPublisher;

    public CustomEvent publishCustomEvent(final String message) {
        log.info("Publishing custom event: {}", message);
        var event = new CustomEvent(this, message);
        applicationEventPublisher.publishEvent(event);
        return event;
    }
}
