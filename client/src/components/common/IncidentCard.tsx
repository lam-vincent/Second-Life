import React, { useEffect, useState } from "react";
import axios from "axios";

interface Incident {
  id: number;
  description: string;
  reportedAt: string;
  location: string;
  status: string;
}

interface IncidentCardProps {
  incidentId: number;
  onIncidentChange: () => void;
}

const IncidentCard: React.FC<IncidentCardProps> = ({
  incidentId,
  onIncidentChange,
}) => {
  const [incident, setIncident] = useState<Incident | null>(null);

  const fetchIncident = async () => {
    try {
      const response = await axios.get(
        `http://localhost:8080/api/incidents/${incidentId}`
      );
      setIncident(response.data);
    } catch (error) {
      console.error("Error fetching incident:", error);
    }
  };

  useEffect(() => {
    const fetchIncident = async () => {
      try {
        const response = await axios.get(
          `http://localhost:8080/api/incidents/${incidentId}`
        );
        setIncident(response.data);
      } catch (error) {
        console.error("Error fetching incident:", error);
      }
    };

    fetchIncident();
  }, [incidentId]);

  const handleDelete = async () => {
    if (!incident) return;

    try {
      await axios.delete(`http://localhost:8080/api/incidents/${incident.id}`);
      console.log("Incident deleted successfully");
      onIncidentChange();
    } catch (error) {
      console.error("Error deleting incident:", error);
    }
  };

  const handleUpdate = async () => {
    if (!incident) return;

    const updatedIncident = { ...incident, status: "RESOLVED" };

    try {
      await axios.put(
        `http://localhost:8080/api/incidents/${incident.id}`,
        updatedIncident
      );
      console.log("Incident updated successfully");
      fetchIncident();
    } catch (error) {
      console.error("Error updating incident:", error);
    }
  };

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
          <div className="flex space-x-4">
            <button
              onClick={handleUpdate}
              className="bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded"
            >
              Update
            </button>
            <button
              onClick={handleDelete}
              className="bg-red-500 hover:bg-red-600 text-white font-bold py-2 px-4 rounded"
            >
              Delete
            </button>
          </div>
        </>
      ) : (
        <p>Loading incident details...</p>
      )}
    </div>
  );
};

export default IncidentCard;
