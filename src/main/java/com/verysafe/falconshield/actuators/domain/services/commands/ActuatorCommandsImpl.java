package com.verysafe.falconshield.actuators.domain.services.commands;
import org.springframework.stereotype.Service;

@Service
public class ActuatorCommandsImpl implements IActuatorCommands {

    @Override
    public void controlActuator(Long actuatorId, String commandType, String parameter) {
    }
}
