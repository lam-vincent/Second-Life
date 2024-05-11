package com.example.depotsauvage.controller;

import com.example.depotsauvage.model.Incident;
import com.example.depotsauvage.model.IncidentStatus;
import com.example.depotsauvage.dto.IncidentDTO;
import com.example.depotsauvage.service.IncidentService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/incidents")
@CrossOrigin(origins = "http://localhost:5173")
public class IncidentController {

    private final IncidentService incidentService;

    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @PostMapping
    public ResponseEntity<IncidentDTO> createIncident(@Valid @RequestBody IncidentDTO incidentDTO,
            BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        Incident createdIncident = incidentService.createIncident(mapToIncident(incidentDTO));
        return new ResponseEntity<>(mapToIncidentDTO(createdIncident), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<IncidentDTO>> getAllIncidents() {
        List<Incident> incidents = incidentService.getAllIncidents();
        return new ResponseEntity<>(mapToIncidentDTOList(incidents), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncidentDTO> getIncidentById(@PathVariable Long id) {
        Incident incident = incidentService.getIncidentById(id);
        if (incident != null) {
            return new ResponseEntity<>(mapToIncidentDTO(incident), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<IncidentDTO> updateIncident(@PathVariable Long id,
            @RequestBody IncidentDTO updatedIncidentDTO) {
        Incident updatedIncident = incidentService.updateIncident(id, mapToIncident(updatedIncidentDTO));
        if (updatedIncident != null) {
            return new ResponseEntity<>(mapToIncidentDTO(updatedIncident), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncident(@PathVariable Long id) {
        boolean deleted = incidentService.deleteIncident(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/reported")
    public ResponseEntity<List<IncidentDTO>> getReportedIncidents() {
        List<Incident> reportedIncidents = incidentService.getReportedIncidents();
        return new ResponseEntity<>(mapToIncidentDTOList(reportedIncidents), HttpStatus.OK);
    }

    @GetMapping("/resolved")
    public ResponseEntity<List<IncidentDTO>> getResolvedIncidents() {
        List<Incident> resolvedIncidents = incidentService.getResolvedIncidents();
        return new ResponseEntity<>(mapToIncidentDTOList(resolvedIncidents), HttpStatus.OK);
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
        incident.setStatus(IncidentStatus.valueOf(dto.getStatus().name()));
        incident.setCoordinates(dto.getCoordinates());
        return incident;
    }
}
