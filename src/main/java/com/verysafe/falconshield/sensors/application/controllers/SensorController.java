package com.verysafe.falconshield.sensors.application.controllers;

import org.springframework.web.bind.annotation.*;
import com.verysafe.falconshield.sensors.application.dto.request.ReadingSensorRequestDto;
import com.verysafe.falconshield.sensors.application.dto.request.MacAddressRequestDto;
import com.verysafe.falconshield.sensors.application.dto.response.SensorResponseDto;
import com.verysafe.falconshield.sensors.application.handlers.commands.ProcessSensorReadingCommandHandler;
import com.verysafe.falconshield.sensors.application.handlers.queries.GetSensorReadingsQueryHandler;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    private final ProcessSensorReadingCommandHandler processSensorReadingCommandHandler;
    private final GetSensorReadingsQueryHandler getSensorReadingsQueryHandler;

    public SensorController(ProcessSensorReadingCommandHandler processSensorReadingCommandHandler,
                            GetSensorReadingsQueryHandler getSensorReadingsQueryHandler) {
        this.processSensorReadingCommandHandler = processSensorReadingCommandHandler;
        this.getSensorReadingsQueryHandler = getSensorReadingsQueryHandler;
    }

    @PostMapping("/readings")
    public String processReading(@RequestBody ReadingSensorRequestDto readingDto) {
        processSensorReadingCommandHandler.execute(readingDto);
        return "Reading processed for sensor " + readingDto.getSensorId();
    }

    @PostMapping("/mac-address")
    public String registerMacAddress(@RequestBody MacAddressRequestDto macDto) {
        // Lógica para registrar la dirección MAC del sensor
        return "MAC Address registered for sensor " + macDto.getSensorId();
    }

    @GetMapping("/readings")
    public List<SensorResponseDto> getAllReadings() {
        return getSensorReadingsQueryHandler.execute();
    }
}
