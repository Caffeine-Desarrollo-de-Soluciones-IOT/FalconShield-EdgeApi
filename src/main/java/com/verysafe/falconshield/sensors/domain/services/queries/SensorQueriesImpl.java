package com.verysafe.falconshield.sensors.domain.services.queries;

import com.verysafe.falconshield.sensors.application.dto.response.SensorResponseDto;
import com.verysafe.falconshield.sensors.infrastructure.repositories.ISensorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SensorQueriesImpl implements ISensorQueries {

    private final ISensorRepository sensorRepository;

    public SensorQueriesImpl(ISensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    public List<SensorResponseDto> getAllSensorReadings() {
        return sensorRepository.findAll().stream()
                .map(sensor -> new SensorResponseDto(
                        sensor.getId(),
                        sensor.getType(),
                        sensor.getStatus(),
                        sensor.getCurrentReading(),
                        sensor.getMacAddress()))
                .collect(Collectors.toList());
    }
}
