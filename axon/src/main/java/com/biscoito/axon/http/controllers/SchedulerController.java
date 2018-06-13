package com.biscoito.axon.http.controllers;

import com.biscoito.axon.commands.SchedulerCommand;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.scheduling.quartz.QuartzEventScheduler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class SchedulerController {

    private final CommandGateway commandGateway;

    private final QuartzEventScheduler scheduler;

    @GetMapping(value = "teste")
    public String teste() {
        final String sku = UUID.randomUUID().toString();
        commandGateway.send(new SchedulerCommand(sku, LocalDateTime.now()));
        return "FOI";
    }

    @GetMapping(value = "v1")
    public String simple() {
        return scheduler.schedule(
                LocalDateTime.now().plusSeconds(10).atZone(ZoneId.systemDefault()).toInstant(),
                new SchedulerCommand(UUID.randomUUID().toString(), LocalDateTime.now())
        ).toString();
    }
}
