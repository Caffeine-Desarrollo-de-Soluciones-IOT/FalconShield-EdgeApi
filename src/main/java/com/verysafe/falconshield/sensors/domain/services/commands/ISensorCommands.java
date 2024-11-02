package com.verysafe.falconshield.sensors.domain.services.commands;

public interface ISensorCommands {
    void processReading(Long sensorId, Float readingValue);
}
