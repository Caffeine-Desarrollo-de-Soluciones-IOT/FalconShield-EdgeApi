package com.verysafe.falconshield.actuators.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ActuatorResponseDto {
    private Long id;
    private String type;
    private String status;

    // Getters y Setters
}
