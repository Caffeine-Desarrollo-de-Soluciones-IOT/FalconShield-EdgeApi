package com.verysafe.falconshield.sensors.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MacAddressRequestDto {
    private Long sensorId;
    private String macAddress;

    // Constructor, Getters y Setters
}
