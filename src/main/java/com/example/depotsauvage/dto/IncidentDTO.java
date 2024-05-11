package com.example.depotsauvage.dto;

import java.time.LocalDateTime;

import com.example.depotsauvage.model.IncidentStatus;

import jakarta.validation.constraints.Pattern;

public class IncidentDTO {
    private Long id;
    private String description;
    private LocalDateTime reportedAt;
    private String location;
    private IncidentStatus status;

    @Pattern(regexp = "\\(\\d+\\.\\d+, \\d+\\.\\d+\\)", message = "Coordinates must be in the format '(0.00, 0.00)'")
    private String coordinates;

    public IncidentDTO() {
    }

    public IncidentDTO(Long id, String description, LocalDateTime reportedAt, String location, IncidentStatus status,
            String coordinates) {
        this.id = id;
        this.description = description;
        this.reportedAt = reportedAt;
        this.location = location;
        this.status = status;
        this.coordinates = coordinates;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getReportedAt() {
        return reportedAt;
    }

    public void setReportedAt(LocalDateTime reportedAt) {
        this.reportedAt = reportedAt;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public IncidentStatus getStatus() {
        return status;
    }

    public void setStatus(IncidentStatus status) {
        this.status = status;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }
}
