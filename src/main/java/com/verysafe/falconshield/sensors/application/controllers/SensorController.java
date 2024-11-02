package com.verysafe.falconshield.sensors.application.controllers;

import org.springframework.web.bind.annotation.*;
import com.verysafe.falconshield.sensors.application.dto.request.ReadingSensorRequestDto;
import com.verysafe.falconshield.sensors.application.dto.request.MacAddressRequestDto;
import com.verysafe.falconshield.sensors.application.dto.response.SensorResponseDto;
import com.verysafe.falconshield.sensors.application.handlers.commands.ProcessSensorReadingCommandHandler;
import com.verysafe.falconshield.sensors.application.handlers.queries.GetSensorReadingsQueryHandler;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
@Tag(name = "Sensors", description = "Endpoints for managing sensors in the system")
public class SensorController {

    private final ProcessSensorReadingCommandHandler processSensorReadingCommandHandler;
    private final GetSensorReadingsQueryHandler getSensorReadingsQueryHandler;

    public SensorController(ProcessSensorReadingCommandHandler processSensorReadingCommandHandler,
                            GetSensorReadingsQueryHandler getSensorReadingsQueryHandler) {
        this.processSensorReadingCommandHandler = processSensorReadingCommandHandler;
        this.getSensorReadingsQueryHandler = getSensorReadingsQueryHandler;
    }

    @PostMapping("/readings")
    @Operation(
        summary = "Process reading from a sensor",
        description = "Receives a reading from a specific sensor and updates its value to the system",
        tags = {"Sensors"}
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Sensor reading processed successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid parameters in the request"),
        @ApiResponse(responseCode = "404", description = "Sensor not found")
    })
    public String processReading(@RequestBody ReadingSensorRequestDto readingDto) {
        processSensorReadingCommandHandler.execute(readingDto);
        return "Reading processed for sensor " + readingDto.getSensorId();
    }

    @PostMapping("/mac-address")
    @Operation(
        summary = "Register sensor MAC address",
        description = "Associates a MAC address to a sensor in the system",
        tags = {"Sensors"}
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "MAC address successfully registered for the sensor"),
        @ApiResponse(responseCode = "400", description = "Invalid parameters in the request"),
        @ApiResponse(responseCode = "404", description = "Sensor not found")
    })
    public String registerMacAddress(@RequestBody MacAddressRequestDto macDto) {
        // Lógica para registrar la dirección MAC del sensor
        return "MAC Address registered for sensor " + macDto.getSensorId();
    }

    @GetMapping("/readings")
    @Operation(
        summary = "Get all sensor readings",
        description = "Retrieves a list of all current sensor readings in the system",
        tags = {"Sensors"}
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Sensor readings successfully recovered"),
        @ApiResponse(responseCode = "500", description = "Server error while getting readings")
    })
    public List<SensorResponseDto> getAllReadings() {
        return getSensorReadingsQueryHandler.execute();
    }
}
