package com.apress.messaging.listener;

import com.apress.messaging.annotation.Log;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;
import com.apress.messaging.event.CurrencyEvent;

@Component
public class RateEventListener {
    
    @TransactionalEventListener
    @Log(printParamsValues = true, callMethodWithNoParamsToString = "getRate")
    public void processEvent(CurrencyEvent event) {}
}