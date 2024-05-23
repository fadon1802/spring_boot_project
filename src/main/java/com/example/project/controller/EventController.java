package com.example.project.controller;

import com.example.project.dto.EventDto;
import com.example.project.dto.TransactionError;
import com.example.project.exception.TransactionException;
import com.example.project.service.event.publishers.AsyncEventPublisher;
import com.example.project.service.event.publishers.CustomEventPublisher;
import com.example.project.service.event.publishers.TransactionalEventPublisher;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EventController {
    private final AsyncEventPublisher asyncEventPublisher;
    private final CustomEventPublisher customEventPublisher;
    private final TransactionalEventPublisher transactionalEventPublisher;

    @GetMapping("/publish")
    public List<EventDto> publishEvents() {
        var customEvent = customEventPublisher.publishCustomEvent("custom event 1");
        var asyncEvent = asyncEventPublisher.publishAsyncEvent("async event 1");
        return List.of(new EventDto(customEvent.getMessage(), customEvent.getSource().toString()), new EventDto(asyncEvent.getMessage(), asyncEvent.getSource().toString()));
    }

    @GetMapping("/publishTransactional1")
    public EventDto publishTransactionalEvent() {
        var transactionalEvent = transactionalEventPublisher.publishTransactionalEvent("transactional event");
        return new EventDto(transactionalEvent.getMessage(), transactionalEvent.getSource().toString());
    }

    @GetMapping("/publishTransactional2")
    public void publishTransactionalEventWithRollback() {
        transactionalEventPublisher.publishTransactionalEventWithRollback("transactional event with rollback");
    }

    @ExceptionHandler(TransactionException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public TransactionError handleTransactionalException(TransactionException ex) {
        return new TransactionError(ex.getMessage());
    }
}
