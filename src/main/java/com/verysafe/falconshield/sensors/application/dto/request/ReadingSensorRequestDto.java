package com.verysafe.falconshield.sensors.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Sensor MAC address", example = "00:1A:7D:DA:71:13")
public class ReadingSensorRequestDto {
    @Schema(description = "ID of the sensor that generates the reading", example = "1")
    private Long sensorId;
    @Schema(description = "Sensor reading value", example = "23.5")
    private Float value;
    @Schema(description = "Unit of measurement for reading", example = "Celsius")
    private String unit;

    // Constructor, Getters y Setters
}
