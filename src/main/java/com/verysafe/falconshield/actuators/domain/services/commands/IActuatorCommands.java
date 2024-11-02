package com.verysafe.falconshield.actuators.domain.services.commands;

public interface IActuatorCommands {
    void controlActuator(Long actuatorid, String commandType, String parameter);
}