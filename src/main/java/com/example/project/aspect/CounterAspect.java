package com.example.project.aspect;

import com.example.project.error.RequestsLimitException;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Aspect
@Log4j2
@Component
public class CounterAspect {

    private final AtomicInteger counter = new AtomicInteger(0);

    @Value("${request.limit}")
    private int requestLimit;

    @Around("@annotation(APIMethod)")
    public Object countRequests(ProceedingJoinPoint joinPoint) throws RuntimeException {
        if (counter.incrementAndGet() > requestLimit)
            throw new RequestsLimitException("Request limit reached");

        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
