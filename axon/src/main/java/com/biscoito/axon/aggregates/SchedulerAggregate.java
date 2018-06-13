package com.biscoito.axon.aggregates;

import com.biscoito.axon.commands.SchedulerCommand;
import com.biscoito.axon.events.SchedulerEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@NoArgsConstructor
@Aggregate
public class SchedulerAggregate {

    @AggregateIdentifier
    private String sku;

    @CommandHandler
    public SchedulerAggregate(SchedulerCommand command) {
        apply(new SchedulerEvent(command.getSku(), command.getDateTime()));
    }

    @EventHandler
    public void on(SchedulerEvent event) {
        this.sku = event.getSku();
    }
}
