package com.verysafe.falconshield.sensors.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReadingSensorRequestDto {
    private Long sensorId;
    private Float value;
    private String unit;

    // Constructor, Getters y Setters
}
