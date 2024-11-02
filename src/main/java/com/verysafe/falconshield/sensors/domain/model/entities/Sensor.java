package com.verysafe.falconshield.sensors.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "Sensor")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String status;

    @Column(name = "current_reading", nullable = true)
    private Float currentReading;

    @Column(name = "mac_address", nullable = false, unique = true)
    private String macAddress;

    public void updateReading(Float reading) {
        this.currentReading = reading;
    }
}
