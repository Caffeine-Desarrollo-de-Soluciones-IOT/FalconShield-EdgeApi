package com.verysafe.falconshield.sensors.infrastructure.repositories;

import com.verysafe.falconshield.sensors.domain.model.entities.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISensorRepository extends JpaRepository<Sensor, Long> {
}
