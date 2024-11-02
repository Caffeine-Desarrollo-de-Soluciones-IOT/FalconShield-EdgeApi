package com.verysafe.falconshield.actuators.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Request to send a command to an actuator")
public class CommandActuatorRequestDto {

    @Schema(description = "Actuator ID", example = "1")
    private Long actuatorId;
    @Schema(description = "Type of command to send", example = "ON/OFF")
    private String typeCommand;
    @Schema(description = "Additional parameter for the command", example = "HIGH")
    private String parameter;

    // Getters y Setters
}