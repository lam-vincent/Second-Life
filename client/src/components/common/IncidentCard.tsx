import React, { useEffect, useState } from "react";
import axios from "axios";

interface Incident {
  id: number;
  description: string;
  reportedAt: string;
  location: string;
  status: string;
}

const IncidentCard: React.FC<{ incidentId: number }> = ({ incidentId }) => {
  const [incident, setIncident] = useState<Incident | null>(null);

  useEffect(() => {
    const fetchIncident = async () => {
      try {
        const response = await axios.get(`/api/incidents/${incidentId}`); // Example API endpoint
        setIncident(response.data);
      } catch (error) {
        console.error("Error fetching incident:", error);
      }
    };

    fetchIncident();
  }, [incidentId]);

  return (
    <div className="bg-white rounded-lg shadow-md p-6 mb-4">
      {incident ? (
        <>
          <h2 className="text-xl font-bold mb-2">{incident.description}</h2>
          <p className="text-gray-600 mb-2">
            Reported at: {new Date(incident.reportedAt).toLocaleString()}
          </p>
          <p className="text-gray-600 mb-2">Location: {incident.location}</p>
          <p className="text-gray-600 mb-2">Status: {incident.status}</p>
        </>
      ) : (
        <p>Loading incident details...</p>
      )}
    </div>
  );
};

export default IncidentCard;
