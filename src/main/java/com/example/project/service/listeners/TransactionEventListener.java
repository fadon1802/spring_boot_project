package com.example.project.service.listeners;

import com.example.project.event.TransactionalEvent;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Log4j2
@Component
public class TransactionEventListener {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleAfterCommit(TransactionalEvent event) {
        log.info("Transactional event commit: {}", event.getMessage());
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void handleAfterRollback(TransactionalEvent event) {
        log.info("Transactional event rollback: {}", event.getMessage());
    }
}
