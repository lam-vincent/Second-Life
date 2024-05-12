package com.example.depotsauvage.controller;

import com.example.depotsauvage.dto.IncidentDTO;
import com.example.depotsauvage.mapper.IncidentMapper;
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
    private final IncidentMapper incidentMapper;

    public IncidentController(IncidentService incidentService, IncidentMapper incidentMapper) {
        this.incidentService = incidentService;
        this.incidentMapper = incidentMapper;
    }

    @PostMapping
    public ResponseEntity<IncidentDTO> createIncident(@Valid @RequestBody IncidentDTO incidentDTO,
            BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        IncidentDTO createdIncidentDTO = incidentMapper
                .toDTO(incidentService.createIncident(incidentMapper.toEntity(incidentDTO)));
        return new ResponseEntity<>(createdIncidentDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<IncidentDTO>> getAllIncidents() {
        List<IncidentDTO> incidentDTOs = incidentService.getAllIncidents().stream()
                .map(incidentMapper::toDTO)
                .toList();
        return new ResponseEntity<>(incidentDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncidentDTO> getIncidentById(@PathVariable Long id) {
        IncidentDTO incidentDTO = incidentService.getIncidentById(id);
        return incidentDTO != null ? new ResponseEntity<>(incidentDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IncidentDTO> updateIncident(@PathVariable Long id,
            @RequestBody IncidentDTO updatedIncidentDTO) {
        IncidentDTO updatedIncident = incidentMapper.toDTO(
                incidentService.updateIncident(id, incidentMapper.toEntity(updatedIncidentDTO)));
        return updatedIncident != null ? new ResponseEntity<>(updatedIncident, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncident(@PathVariable Long id) {
        boolean deleted = incidentService.deleteIncident(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/reported")
    public ResponseEntity<List<IncidentDTO>> getReportedIncidents() {
        List<IncidentDTO> reportedIncidents = incidentService.getReportedIncidents().stream()
                .map(incidentMapper::toDTO)
                .toList();
        return new ResponseEntity<>(reportedIncidents, HttpStatus.OK);
    }

    @GetMapping("/resolved")
    public ResponseEntity<List<IncidentDTO>> getResolvedIncidents() {
        List<IncidentDTO> resolvedIncidents = incidentService.getResolvedIncidents().stream()
                .map(incidentMapper::toDTO)
                .toList();
        return new ResponseEntity<>(resolvedIncidents, HttpStatus.OK);
    }
}
