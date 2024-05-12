package com.example.depotsauvage.repository;

import com.example.depotsauvage.model.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long> {

    @Query("SELECT i FROM Incident i WHERE i.status = 'REPORTED'")
    List<Incident> findReportedIncidents();

    @Query("SELECT i FROM Incident i WHERE i.status = 'RESOLVED'")
    List<Incident> findResolvedIncidents();
}
