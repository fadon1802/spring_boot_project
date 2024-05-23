package com.example.project.service.event.publishers;

import com.example.project.event.TransactionalEvent;
import com.example.project.exception.TransactionException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Log4j2
public class TransactionalEventPublisher {

    ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public TransactionalEvent publishTransactionalEvent(final String message) {
        log.info("Publishing transactional event 1: {}", message);
        var event = new TransactionalEvent(this, message);
        applicationEventPublisher.publishEvent(event);
        return event;
    }

    @Transactional
    public void publishTransactionalEventWithRollback(final String message) throws TransactionException {
        log.info("Publishing transactional event 2: {}", message);
        applicationEventPublisher.publishEvent(new TransactionalEvent(this, message));
        throw new TransactionException("Rollback");
    }
}
