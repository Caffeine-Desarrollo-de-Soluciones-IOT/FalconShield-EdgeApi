package com.verysafe.falconshield.actuators.domain.services.queries;

import com.verysafe.falconshield.actuators.application.dto.response.ActuatorResponseDto;
import com.verysafe.falconshield.actuators.domain.model.entities.Actuator;
import com.verysafe.falconshield.actuators.infrastructure.IActuatorRepository;
import org.springframework.stereotype.Service;

@Service
public class ActuatorQueriesImpl implements IActuatorQueries {

    private final IActuatorRepository actuatorRepository;

    public ActuatorQueriesImpl(IActuatorRepository actuatorRepository) {
        this.actuatorRepository = actuatorRepository;
    }

    @Override
    public ActuatorResponseDto getActuatorStatus(Long id) {
        Actuator actuator = actuatorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Actuator not found"));
        
        return new ActuatorResponseDto(
            actuator.getId(),
            actuator.getType(),
            actuator.getStatus()
        );
    }
}
