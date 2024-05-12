package com.example.depotsauvage;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.depotsauvage.controller.IncidentController;
import com.example.depotsauvage.dto.IncidentDTO;
import com.example.depotsauvage.model.IncidentStatus;
import com.example.depotsauvage.service.IncidentService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(IncidentController.class)
@AutoConfigureMockMvc
public class IncidentControllerIntegrationTest {

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private ObjectMapper objectMapper;

        @MockBean
        private IncidentService incidentService;

        @Test
        public void testCreateIncident() throws Exception {
                // Mock incident data
                IncidentDTO incidentDTO = new IncidentDTO(null, "Test Description", LocalDateTime.now(),
                                "Test Location",
                                IncidentStatus.IN_PROGRESS, "(0.00, 0.00)");

                // Mock service method to save incident
                given(incidentService.createIncident(any(IncidentDTO.class))).willReturn(incidentDTO);

                // Perform POST request to create incident
                mockMvc.perform(post("/api/incidents")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(incidentDTO)))
                                .andExpect(status().isCreated())
                                .andExpect(jsonPath("$.description").value("Test Description"));
        }

        @Test
        public void testGetIncidentById() throws Exception {
                // Mock incident data
                Long incidentId = 1L;
                IncidentDTO incidentDTO = new IncidentDTO(incidentId, "Test Description", LocalDateTime.now(),
                                "Test Location",
                                IncidentStatus.IN_PROGRESS, "(0.00, 0.00)");

                // Mock service method to retrieve incident by ID
                given(incidentService.getIncidentById(incidentId)).willReturn(incidentDTO);

                // Perform GET request to retrieve incident by ID
                mockMvc.perform(get("/api/incidents/{id}", incidentId)
                                .contentType(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.description").value("Test Description"));
        }

        @Test
        public void testGetAllIncidents() throws Exception {
                // Mock data
                IncidentDTO incidentDTO1 = new IncidentDTO(null, "Description 1", LocalDateTime.now(), "Location 1",
                                IncidentStatus.IN_PROGRESS, "(0.00, 0.00)");
                IncidentDTO incidentDTO2 = new IncidentDTO(null, "Description 2", LocalDateTime.now(), "Location 2",
                                IncidentStatus.IN_PROGRESS, "(0.00, 0.00)");
                List<IncidentDTO> incidentDTOs = Arrays.asList(incidentDTO1, incidentDTO2);

                // Mock service method to return incidents
                given(incidentService.getAllIncidents()).willReturn(incidentDTOs);

                // Perform GET request and verify response
                mockMvc.perform(get("/api/incidents")
                                .contentType(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                                .andExpect(jsonPath("$[0].description").value("Description 1"))
                                .andExpect(jsonPath("$[1].description").value("Description 2"));
        }

        @Test
        public void testUpdateIncident() throws Exception {
                // Mock incident data
                Long incidentId = 1L;
                IncidentDTO updatedIncidentDTO = new IncidentDTO(null, "Updated Description", LocalDateTime.now(),
                                "Updated Location",
                                IncidentStatus.IN_PROGRESS, "(0.00, 0.00)");

                // Mock service method to update incident
                given(incidentService.updateIncident(eq(incidentId), any(IncidentDTO.class)))
                                .willReturn(updatedIncidentDTO);

                // Perform PUT request to update incident
                mockMvc.perform(put("/api/incidents/{id}", incidentId)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(updatedIncidentDTO)))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.description").value("Updated Description"));
        }

        @Test
        public void testDeleteIncident() throws Exception {
                // Mock incident ID
                Long incidentId = 1L;

                // Mock service method to delete incident
                given(incidentService.deleteIncident(incidentId)).willReturn(true);

                // Perform DELETE request to delete incident by ID
                mockMvc.perform(delete("/api/incidents/{id}", incidentId)
                                .contentType(MediaType.APPLICATION_JSON))
                                .andExpect(status().isNoContent());
        }
}
