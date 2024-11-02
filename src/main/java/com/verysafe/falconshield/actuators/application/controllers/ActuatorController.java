package com.verysafe.falconshield.actuators.application.controllers;

import org.springframework.web.bind.annotation.*;
import com.verysafe.falconshield.actuators.application.dto.request.CommandActuatorRequestDto;
import com.verysafe.falconshield.actuators.application.dto.response.ActuatorResponseDto;
import com.verysafe.falconshield.actuators.application.handlers.commands.ControlActuatorCommandHandler;
import com.verysafe.falconshield.actuators.application.handlers.queries.GetActuatorStatusQueryHandler;

@RestController
@RequestMapping("/api/actuators")
public class ActuatorController {

    private final ControlActuatorCommandHandler controlActuatorCommandHandler;
    private final GetActuatorStatusQueryHandler getActuatorStatusQueryHandler;

    public ActuatorController(ControlActuatorCommandHandler controlActuatorCommandHandler,
                              GetActuatorStatusQueryHandler getActuatorStatusQueryHandler) {
        this.controlActuatorCommandHandler = controlActuatorCommandHandler;
        this.getActuatorStatusQueryHandler = getActuatorStatusQueryHandler;
    }

    @PostMapping("/register")
    public String controlActuator(@RequestBody CommandActuatorRequestDto commandDto) {
        controlActuatorCommandHandler.execute(commandDto);
        return "Actuator " + commandDto.getActuatorId() + " controlled with command " + commandDto.getTypeCommand();
    }

    @GetMapping("/{id}/status")
    public ActuatorResponseDto getActuatorStatus(@PathVariable Long id) {
        return getActuatorStatusQueryHandler.execute(id);
    }
}