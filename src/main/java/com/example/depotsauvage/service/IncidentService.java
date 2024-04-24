package com.example.depotsauvage.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Incident createIncident(Incident incident) {
        // Implement any business logic before saving the incident
        incident.setReportedAt(LocalDateTime.now());
        incident.setStatus(IncidentStatus.REPORTED);
        incident.setLocation("Default Location");
        incident.setDescription("Default Description");

        return incidentRepository.save(incident);
    }

    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    public Incident getIncidentById(Long id) {
        Optional<Incident> optionalIncident = incidentRepository.findById(id);
        return optionalIncident.orElse(null);
    }

    public Incident updateIncident(Long id, Incident updatedIncident) {
        Optional<Incident> optionalExistingIncident = incidentRepository.findById(id);
        if (optionalExistingIncident.isPresent()) {
            // Update the existing incident with new values
            Incident existingIncident = optionalExistingIncident.get();
            existingIncident.setDescription(updatedIncident.getDescription());
            existingIncident.setReportedAt(updatedIncident.getReportedAt());
            existingIncident.setLocation(updatedIncident.getLocation());
            existingIncident.setStatus(updatedIncident.getStatus());

            // Save the updated incident
            return incidentRepository.save(existingIncident);
        }
        return null; // Incident with the given ID not found
    }

    public boolean deleteIncident(Long id) {
        if (incidentRepository.existsById(id)) {
            incidentRepository.deleteById(id);
            return true;
        }
        return false; // Incident with the given ID not found
    }
}
