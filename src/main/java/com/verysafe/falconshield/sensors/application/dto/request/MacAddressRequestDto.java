package com.verysafe.falconshield.sensors.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Request to register the MAC address of a sensor")
public class MacAddressRequestDto {
    @Schema(description = "Sensor ID", example = "1")
    private Long sensorId;
    @Schema(description = "Sensor MAC address", example = "00:1A:7D:DA:71:13")
    private String macAddress;

    // Constructor, Getters y Setters
}
