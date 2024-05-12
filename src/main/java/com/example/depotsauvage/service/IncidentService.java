package com.example.depotsauvage.service;

import com.example.depotsauvage.dto.IncidentDTO;
import com.example.depotsauvage.mapper.IncidentMapper;
import com.example.depotsauvage.model.Incident;
import com.example.depotsauvage.model.IncidentStatus;
import com.example.depotsauvage.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IncidentService {

    private final IncidentRepository incidentRepository;
    private final IncidentMapper incidentMapper;

    @Autowired
    public IncidentService(IncidentRepository incidentRepository, IncidentMapper incidentMapper) {
        this.incidentRepository = incidentRepository;
        this.incidentMapper = incidentMapper;
    }

    public IncidentDTO createIncident(IncidentDTO incidentDTO) {
        Incident incident = incidentMapper.mapToIncident(incidentDTO);

        incident.setReportedAt(LocalDateTime.now());
        incident.setStatus(IncidentStatus.REPORTED);

        Incident savedIncident = incidentRepository.save(incident);

        // Map the saved Incident back to IncidentDTO
        return incidentMapper.mapToIncidentDTO(savedIncident);
    }

    public List<IncidentDTO> getAllIncidents() {
        List<Incident> incidents = incidentRepository.findAll();
        return incidents.stream().map(incidentMapper::mapToIncidentDTO).collect(Collectors.toList());
    }

    public IncidentDTO getIncidentById(Long id) {
        Optional<Incident> optionalIncident = incidentRepository.findById(id);
        return optionalIncident.map(incidentMapper::mapToIncidentDTO).orElse(null);
    }

    public IncidentDTO updateIncident(Long id, IncidentDTO updatedIncidentDTO) {
        Optional<Incident> optionalExistingIncident = incidentRepository.findById(id);
        if (optionalExistingIncident.isPresent()) {
            Incident existingIncident = optionalExistingIncident.get();

            incidentMapper.updateIncidentFromDTO(updatedIncidentDTO, existingIncident);

            Incident savedIncident = incidentRepository.save(existingIncident);

            // Map the saved Incident back to IncidentDTO
            return incidentMapper.mapToIncidentDTO(savedIncident);
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
        return reportedIncidents.stream().map(incidentMapper::mapToIncidentDTO).collect(Collectors.toList());
    }

    public List<IncidentDTO> getResolvedIncidents() {
        List<Incident> resolvedIncidents = incidentRepository.findResolvedIncidents();
        return resolvedIncidents.stream().map(incidentMapper::mapToIncidentDTO).collect(Collectors.toList());
    }
}
