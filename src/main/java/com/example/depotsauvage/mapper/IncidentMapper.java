package com.example.depotsauvage.mapper;

import com.example.depotsauvage.dto.IncidentDTO;
import com.example.depotsauvage.model.Incident;
import com.example.depotsauvage.model.IncidentStatus;

import jakarta.validation.Valid;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IncidentMapper {

    public IncidentDTO mapToIncidentDTO(Incident incident) {
        IncidentDTO dto = new IncidentDTO();
        dto.setId(incident.getId());
        dto.setDescription(incident.getDescription());
        dto.setReportedAt(incident.getReportedAt());
        dto.setLocation(incident.getLocation());
        dto.setStatus(IncidentStatus.valueOf(incident.getStatus().name()));
        dto.setCoordinates(incident.getCoordinates());
        return dto;
    }

    public List<IncidentDTO> mapToIncidentDTOList(List<Incident> incidents) {
        return incidents.stream().map(this::mapToIncidentDTO).collect(Collectors.toList());
    }

    public Incident mapToIncident(IncidentDTO dto) {
        Incident incident = new Incident();
        incident.setDescription(dto.getDescription());
        incident.setReportedAt(dto.getReportedAt());
        incident.setLocation(dto.getLocation());
        incident.setStatus(IncidentStatus.valueOf(dto.getStatus()));
        incident.setCoordinates(dto.getCoordinates());
        return incident;
    }

    public void updateIncidentFromDTO(IncidentDTO updatedIncidentDTO, Incident existingIncident) {
        existingIncident.setDescription(updatedIncidentDTO.getDescription());
        existingIncident.setLocation(updatedIncidentDTO.getLocation());
        existingIncident.setCoordinates(updatedIncidentDTO.getCoordinates());
        existingIncident.setStatus(IncidentStatus.valueOf(updatedIncidentDTO.getStatus()));
    }

    public IncidentDTO toEntity(@Valid IncidentDTO incidentDTO) {
        return new IncidentDTO(incidentDTO.getId(), incidentDTO.getDescription(), incidentDTO.getReportedAt(),
                incidentDTO.getLocation(), incidentDTO.getStatus(), incidentDTO.getCoordinates());
    }

    public IncidentDTO toDTO(IncidentDTO incident) {
        return new IncidentDTO(incident.getId(), incident.getDescription(), incident.getReportedAt(),
                incident.getLocation(), incident.getStatus(), incident.getCoordinates());
    }
}
