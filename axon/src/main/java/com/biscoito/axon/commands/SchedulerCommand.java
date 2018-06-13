package com.biscoito.axon.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.TargetAggregateIdentifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Component
public class SchedulerCommand {

    @TargetAggregateIdentifier
    private String sku;

    private LocalDateTime dateTime;
}
