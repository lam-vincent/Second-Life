package com.example.depotsauvage.model;

public enum IncidentStatus {
    REPORTED,
    IN_PROGRESS,
    RESOLVED;

    public static IncidentStatus valueOf(IncidentStatus status) {
        return valueOf(status.name());
    }
}
