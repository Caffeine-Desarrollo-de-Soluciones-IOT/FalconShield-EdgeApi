package com.verysafe.falconshield.actuators.infrastructure;

import com.verysafe.falconshield.actuators.domain.model.entities.Actuator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IActuatorRepository extends JpaRepository<Actuator, Long> {
}
