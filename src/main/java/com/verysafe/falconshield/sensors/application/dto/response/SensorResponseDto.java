package com.verysafe.falconshield.sensors.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response containing data from a sensor")
public class SensorResponseDto {

    @Schema(description = "Sensor ID", example = "1")
    private Long id;

    @Schema(description = "Sensor type", example = "Temperature")
    private String type;

    @Schema(description = "Current sensor status", example = "Active")
    private String status;

    @Schema(description = "Current sensor reading", example = "23.5")
    private Float currentReading;

    @Schema(description = "Sensor MAC address", example = "00:1A:7D:DA:71:13")
    private String macAddress;

    public SensorResponseDto(Long id, String type, String status, Float currentReading, String macAddress) {
        this.id = id;
        this.type = type;
        this.status = status;
        this.currentReading = currentReading;
        this.macAddress = macAddress;
    }

    // Constructor, Getters y Setters
}
