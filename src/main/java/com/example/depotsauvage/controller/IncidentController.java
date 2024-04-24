package com.example.depotsauvage.controller;

import com.example.depotsauvage.model.Incident;
import com.example.depotsauvage.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController {

    private final IncidentService incidentService;

    @Autowired
    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    // Endpoint to create a new incident
    @PostMapping
    public ResponseEntity<Incident> createIncident(@RequestBody Incident incident) {
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
}
