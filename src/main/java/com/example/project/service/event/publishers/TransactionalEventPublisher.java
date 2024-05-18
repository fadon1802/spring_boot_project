package com.example.project.service.event.publishers;

import com.example.project.event.TransactionalEvent;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Log4j2
public class TransactionalEventPublisher {

    final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public void publishTransactionalEvent(final String message) {
        log.info("Publishing transactional event 1: " + message);
        applicationEventPublisher.publishEvent(new TransactionalEvent(this, message));
    }

    @Transactional
    public void publishTransactionalEventWithRollback(final String message) {
        log.info("Publishing transactional event 2: " + message);
        applicationEventPublisher.publishEvent(new TransactionalEvent(this, message));
        throw new RuntimeException("Rollback");
    }
}
