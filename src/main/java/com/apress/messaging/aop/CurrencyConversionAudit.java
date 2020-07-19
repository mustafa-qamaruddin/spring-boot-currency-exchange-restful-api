package com.apress.messaging.aop;

import com.apress.messaging.event.CurrencyConversionEvent;
import com.apress.messaging.exception.BadCodeRuntimeException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

@Aspect
public class CurrencyConversionAudit {
    
    private ApplicationEventPublisher publisher;

    @Autowired
    public CurrencyConversionAudit(
        ApplicationEventPublisher publisher
    ) {
        this.publisher = publisher;
    }

    @Pointcut("execution(* com.apress.messaging.service.*Service.*(..))")
    public void exceptionPointcut() {}

    @AfterThrowing(pointcut = "exceptionPointcut()", throwing="ex")
    public void badCodeException(JoinPoint jp, BadCodeRuntimeException ex) {
        if ( ex.getConversion() != null) {
            publisher.publishEvent(
                new CurrencyConversionEvent(jp.getTarget(), ex.getMessage(), ex.getConversion())
            );
        }
    }
}