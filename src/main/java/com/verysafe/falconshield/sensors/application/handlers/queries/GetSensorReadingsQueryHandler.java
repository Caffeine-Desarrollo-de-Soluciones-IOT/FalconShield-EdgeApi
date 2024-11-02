package com.verysafe.falconshield.sensors.application.handlers.queries;

import com.verysafe.falconshield.sensors.application.dto.response.SensorResponseDto;
import com.verysafe.falconshield.sensors.domain.services.queries.ISensorQueries;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GetSensorReadingsQueryHandler {

    private final ISensorQueries sensorQueries;

    public GetSensorReadingsQueryHandler(ISensorQueries sensorQueries) {
        this.sensorQueries = sensorQueries;
    }

    public List<SensorResponseDto> execute() {
        return sensorQueries.getAllSensorReadings();
    }
}
