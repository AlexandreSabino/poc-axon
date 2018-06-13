package com.biscoito.axon.handlers;

import com.biscoito.axon.events.SchedulerEvent;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.GenericEventMessage;
import org.springframework.stereotype.Component;

@Component
public class SchudulerEventHandler {

    @EventHandler
    public void handle(SchedulerEvent event) {
        System.out.println("Message received: " + event.getSku() + " (" + event.getDateTime() + ")");
    }


    @EventHandler
    public void handle(GenericEventMessage event) {
        System.out.println("Message received: " + event.getIdentifier());
    }

}
