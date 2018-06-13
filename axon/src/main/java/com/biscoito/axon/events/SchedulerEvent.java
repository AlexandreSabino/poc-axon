package com.biscoito.axon.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class SchedulerEvent {

    private String sku;

    private LocalDateTime dateTime;
}
