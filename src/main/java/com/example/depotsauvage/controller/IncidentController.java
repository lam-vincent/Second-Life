package com.example.depotsauvage.controller;

import com.example.depotsauvage.model.Incident;
import com.example.depotsauvage.service.IncidentService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidents")
@CrossOrigin(origins = "http://localhost:5173")
public class IncidentController {

    private final IncidentService incidentService;

    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    // Endpoint to create a new incident
    @PostMapping
    public ResponseEntity<Incident> createIncident(@Valid @RequestBody Incident incident, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(incident);
        }

        Incident createdIncident = incidentService.createIncident(incident);
        return new ResponseEntity<>(createdIncident, HttpStatus.CREATED);
    }

    // Endpoint to retrieve all incidents
    @GetMapping
    public ResponseEntity<List<Incident>> getAllIncidents() {
        List<Incident> incidents = incidentService.getAllIncidents();
        return new ResponseEntity<>(incidents, HttpStatus.OK);
    }

    // Endpoint to retrieve a specific incident by ID
    @GetMapping("/{id}")
    public ResponseEntity<Incident> getIncidentById(@PathVariable Long id) {
        Incident incident = incidentService.getIncidentById(id);
        if (incident != null) {
            return new ResponseEntity<>(incident, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to update an existing incident
    @PutMapping("/{id}")
    public ResponseEntity<Incident> updateIncident(@PathVariable Long id, @RequestBody Incident updatedIncident) {
        Incident incident = incidentService.updateIncident(id, updatedIncident);
        if (incident != null) {
            return new ResponseEntity<>(incident, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to delete an incident by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncident(@PathVariable Long id) {
        boolean deleted = incidentService.deleteIncident(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to retrieve all reported incidents
    @GetMapping("/reported")
    public ResponseEntity<List<Incident>> getReportedIncidents() {
        List<Incident> reportedIncidents = incidentService.getReportedIncidents();
        return new ResponseEntity<>(reportedIncidents, HttpStatus.OK);
    }

    // Endpoint to retrieve all resolved incidents
    @GetMapping("/resolved")
    public ResponseEntity<List<Incident>> getResolvedIncidents() {
        List<Incident> resolvedIncidents = incidentService.getResolvedIncidents();
        return new ResponseEntity<>(resolvedIncidents, HttpStatus.OK);
    }
}
