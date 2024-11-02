package com.verysafe.falconshield.sensors.domain.services.commands;

import com.verysafe.falconshield.sensors.infrastructure.repositories.ISensorRepository;
import com.verysafe.falconshield.sensors.domain.model.entities.Sensor;
import org.springframework.stereotype.Service;

@Service
public class SensorCommandsImpl implements ISensorCommands {

    private final ISensorRepository sensorRepository;

    public SensorCommandsImpl(ISensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    public void processReading(Long sensorId, Float readingValue) {
        Sensor sensor = sensorRepository.findById(sensorId)
                .orElseThrow(() -> new RuntimeException("Sensor not found"));

        // Actualiza la lectura actual del sensor
        sensor.updateReading(readingValue);
        sensorRepository.save(sensor);
    }
}
