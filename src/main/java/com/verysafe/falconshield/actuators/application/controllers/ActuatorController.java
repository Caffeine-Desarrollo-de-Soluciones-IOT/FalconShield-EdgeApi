package com.verysafe.falconshield.actuators.application.controllers;

import org.springframework.web.bind.annotation.*;
import com.verysafe.falconshield.actuators.application.dto.request.CommandActuatorRequestDto;
import com.verysafe.falconshield.actuators.application.dto.response.ActuatorResponseDto;
import com.verysafe.falconshield.actuators.application.handlers.commands.ControlActuatorCommandHandler;
import com.verysafe.falconshield.actuators.application.handlers.queries.GetActuatorStatusQueryHandler;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/actuators")
@Tag(name = "Actuators", description = "Endpoints for managing actuators in the system")
public class ActuatorController {

    private final ControlActuatorCommandHandler controlActuatorCommandHandler;
    private final GetActuatorStatusQueryHandler getActuatorStatusQueryHandler;

    public ActuatorController(ControlActuatorCommandHandler controlActuatorCommandHandler,
                              GetActuatorStatusQueryHandler getActuatorStatusQueryHandler) {
        this.controlActuatorCommandHandler = controlActuatorCommandHandler;
        this.getActuatorStatusQueryHandler = getActuatorStatusQueryHandler;
    }

    @PostMapping("/register")
    @Operation(
        summary = "Controlling an actuator",
        description = "Sends a command to control a specific actuator in the system",
        tags = {"Actuators"}
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Command sent successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid parameters in the request"),
        @ApiResponse(responseCode = "404", description = "Actuator not found")
    })
    public String controlActuator(@RequestBody CommandActuatorRequestDto commandDto) {
        controlActuatorCommandHandler.execute(commandDto);
        return "Actuator " + commandDto.getActuatorId() + " controlled with command " + commandDto.getTypeCommand();
    }

    @GetMapping("/{id}/status")
    @Operation(
        summary = "Get the status of an actuator",
        description = "Query the current status of a specific actuator by its ID",
        tags = {"Actuators"}
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Actuator status successfully recovered"),
        @ApiResponse(responseCode = "404", description = "Actuator not found")
    })
    public ActuatorResponseDto getActuatorStatus(@PathVariable Long id) {
        return getActuatorStatusQueryHandler.execute(id);
    }
}