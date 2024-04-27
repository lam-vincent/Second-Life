package com.example.depotsauvage.repository;

import com.example.depotsauvage.model.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long> {

    // Custom query method to find incident by description
    Incident findByDescription(String description);

    // Add more custom query methods as needed based on your requirements
}
