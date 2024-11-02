package com.verysafe.falconshield.sensors.domain.services.queries;

import com.verysafe.falconshield.sensors.application.dto.response.SensorResponseDto;
import java.util.List;

public interface ISensorQueries {
    List<SensorResponseDto> getAllSensorReadings();
}
