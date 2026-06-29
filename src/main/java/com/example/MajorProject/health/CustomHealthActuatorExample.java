package com.example.MajorProject.health;

import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthActuatorExample implements HealthIndicator {

    @Override
    public Health health() {
        return Health.up().withDetail("app", "Cab Booking API").build();
    }
}
