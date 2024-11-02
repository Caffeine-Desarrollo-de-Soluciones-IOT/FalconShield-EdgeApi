package com.verysafe.falconshield.actuators.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommandActuatorRequestDto {
    private Long actuatorId;
    private String typeCommand;
    private String parameter;

    // Getters y Setters
}