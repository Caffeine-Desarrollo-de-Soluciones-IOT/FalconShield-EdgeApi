package com.verysafe.falconshield.actuators.domain.services.queries;

import com.verysafe.falconshield.actuators.application.dto.response.ActuatorResponseDto;

public interface IActuatorQueries {
    ActuatorResponseDto getActuatorStatus(Long id);
}
