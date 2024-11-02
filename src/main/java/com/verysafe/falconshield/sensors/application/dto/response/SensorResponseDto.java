package com.verysafe.falconshield.sensors.application.dto.response;

public class SensorResponseDto {

    private Long id;
    private String type;
    private String status;
    private Float currentReading;
    private String macAddress;

    public SensorResponseDto(Long id, String type, String status, Float currentReading, String macAddress) {
        this.id = id;
        this.type = type;
        this.status = status;
        this.currentReading = currentReading;
        this.macAddress = macAddress;
    }

    // Getters y Setters
}
