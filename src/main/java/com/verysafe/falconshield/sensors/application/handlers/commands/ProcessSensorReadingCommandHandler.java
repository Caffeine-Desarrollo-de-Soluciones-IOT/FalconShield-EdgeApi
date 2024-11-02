package com.verysafe.falconshield.sensors.application.handlers.commands;

import com.verysafe.falconshield.sensors.domain.services.commands.ISensorCommands;
import com.verysafe.falconshield.sensors.application.dto.request.ReadingSensorRequestDto;
import org.springframework.stereotype.Service;

@Service
public class ProcessSensorReadingCommandHandler {

    private final ISensorCommands sensorCommands;

    public ProcessSensorReadingCommandHandler(ISensorCommands sensorCommands) {
        this.sensorCommands = sensorCommands;
    }

    public void execute(ReadingSensorRequestDto readingDto) {
        sensorCommands.processReading(readingDto.getSensorId(), readingDto.getValue());
    }
}
