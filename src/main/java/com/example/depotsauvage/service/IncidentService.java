package com.example.depotsauvage.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.depotsauvage.dto.IncidentDTO;
import com.example.depotsauvage.model.Incident;
import com.example.depotsauvage.model.IncidentStatus;
import com.example.depotsauvage.repository.IncidentRepository;

@Service
public class IncidentService {

    private final IncidentRepository incidentRepository;

    @Autowired
    public IncidentService(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    public IncidentDTO createIncident(IncidentDTO incidentDTO) {
        // Convert IncidentDTO to Incident
        Incident incident = mapToIncident(incidentDTO);

        // Set default values if needed
        incident.setReportedAt(LocalDateTime.now());
        incident.setStatus(IncidentStatus.REPORTED);
        incident.setLocation(incident.getLocation() != null ? incident.getLocation() : "Default Location");
        incident.setCoordinates(incident.getCoordinates() != null ? incident.getCoordinates() : "(0.00, 0.00)");
        incident.setDescription(incident.getDescription() != null ? incident.getDescription() : "Default Description");

        // Save the incident
        Incident savedIncident = incidentRepository.save(incident);

        // Convert saved Incident back to IncidentDTO
        return mapToIncidentDTO(savedIncident);
    }

    public List<IncidentDTO> getAllIncidents() {
        List<Incident> incidents = incidentRepository.findAll();
        return mapToIncidentDTOList(incidents);
    }

    public IncidentDTO getIncidentById(Long id) {
        Optional<Incident> optionalIncident = incidentRepository.findById(id);
        return optionalIncident.map(this::mapToIncidentDTO).orElse(null);
    }

    public IncidentDTO updateIncident(Long id, IncidentDTO updatedIncidentDTO) {
        Optional<Incident> optionalExistingIncident = incidentRepository.findById(id);
        if (optionalExistingIncident.isPresent()) {
            // Update the existing incident with new values
            Incident existingIncident = optionalExistingIncident.get();
            existingIncident.setDescription(updatedIncidentDTO.getDescription());
            existingIncident.setReportedAt(updatedIncidentDTO.getReportedAt());
            existingIncident.setLocation(updatedIncidentDTO.getLocation());
            existingIncident.setStatus(IncidentStatus.valueOf(updatedIncidentDTO.getStatus()));

            // Save the updated incident
            Incident savedIncident = incidentRepository.save(existingIncident);

            // Convert saved Incident back to IncidentDTO
            return mapToIncidentDTO(savedIncident);
        }
        return null;
    }

    public boolean deleteIncident(Long id) {
        if (incidentRepository.existsById(id)) {
            incidentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<IncidentDTO> getReportedIncidents() {
        List<Incident> reportedIncidents = incidentRepository.findReportedIncidents();
        return mapToIncidentDTOList(reportedIncidents);
    }

    public List<IncidentDTO> getResolvedIncidents() {
        List<Incident> resolvedIncidents = incidentRepository.findResolvedIncidents();
        return mapToIncidentDTOList(resolvedIncidents);
    }

    // Helper methods for mapping between Incident and IncidentDTO

    private IncidentDTO mapToIncidentDTO(Incident incident) {
        IncidentDTO dto = new IncidentDTO();
        dto.setId(incident.getId());
        dto.setDescription(incident.getDescription());
        dto.setReportedAt(incident.getReportedAt());
        dto.setLocation(incident.getLocation());
        dto.setStatus(IncidentStatus.valueOf(incident.getStatus().name()));
        dto.setCoordinates(incident.getCoordinates());
        return dto;
    }

    private List<IncidentDTO> mapToIncidentDTOList(List<Incident> incidents) {
        return incidents.stream().map(this::mapToIncidentDTO).collect(Collectors.toList());
    }

    private Incident mapToIncident(IncidentDTO dto) {
        Incident incident = new Incident();
        incident.setDescription(dto.getDescription());
        incident.setReportedAt(dto.getReportedAt());
        incident.setLocation(dto.getLocation());
        incident.setStatus(IncidentStatus.valueOf(dto.getStatus()));
        incident.setCoordinates(dto.getCoordinates());
        return incident;
    }
}
