package com.apress.messaging.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;
import com.apress.messaging.annotation.Log;
import io.micrometer.core.instrument.Metrics;

@Component
public class RestApiEventsListener implements ApplicationListener<ApplicationEvent> {
    
    public static final String LATEST = "/currency/latest";    

    @Log(printParamsValues=true)
    public void onApplicationEvent(final ApplicationEvent event) {
        if( event instanceof ServletRequestHandledEvent) {
            if( ( (ServletRequestHandledEvent) event).getRequestUrl().equals(LATEST)) {
                Metrics.counter("url.currency.latest.hits").increment(1.0);
            }
        }
    }
}