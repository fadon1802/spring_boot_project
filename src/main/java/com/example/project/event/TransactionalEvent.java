package com.example.project.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class TransactionalEvent extends ApplicationEvent {

    private final String message;

    public TransactionalEvent(Object source, String message) {
        super(source);
        this.message = message;
    }
}
