package com.verysafe.falconshield.actuators.application.handlers.queries;


import org.springframework.stereotype.Service;

import com.verysafe.falconshield.actuators.application.dto.response.ActuatorResponseDto;
import com.verysafe.falconshield.actuators.domain.services.queries.IActuatorQueries;

@Service
public class GetActuatorStatusQueryHandler {

    private final IActuatorQueries actuatorQueries;

    public GetActuatorStatusQueryHandler(IActuatorQueries actuatorQueries) {
        this.actuatorQueries = actuatorQueries;
    }

    public ActuatorResponseDto execute(Long actuatorId) {
        return actuatorQueries.getActuatorStatus(actuatorId);
    }
}
