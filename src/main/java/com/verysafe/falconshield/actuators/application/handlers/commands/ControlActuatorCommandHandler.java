package com.verysafe.falconshield.actuators.application.handlers.commands;
import com.verysafe.falconshield.actuators.domain.services.commands.IActuatorCommands;

import org.springframework.stereotype.Service;

import com.verysafe.falconshield.actuators.application.dto.request.CommandActuatorRequestDto;


@Service
public class ControlActuatorCommandHandler {

    private final IActuatorCommands actuatorCommands;

    public ControlActuatorCommandHandler(IActuatorCommands actuatorCommands) {
        this.actuatorCommands = actuatorCommands;
    }

    public void execute(CommandActuatorRequestDto commandDto) {
        actuatorCommands.controlActuator(commandDto.getActuatorId(), commandDto.getTypeCommand(), commandDto.getParameter());
    }
}
