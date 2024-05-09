import React, { useEffect, useState } from "react";
import axios from "axios";
import IncidentCard from "../common/IncidentCard";
import Incident from "../../types/Incident";

const IncidentPage: React.FC = () => {
  const [incidents, setIncidents] = useState<Incident[]>([]);
  const [loading, setLoading] = useState<boolean>(true);
  const [refreshCounter, setRefreshCounter] = useState<number>(0);

  const refreshIncidents = () => {
    setRefreshCounter((prevCounter) => prevCounter + 1);
  };

  useEffect(() => {
    const fetchIncidents = async () => {
      try {
        const response = await axios.get("http://localhost:8080/api/incidents");
        console.log("Incidents:", response.data);
        setIncidents(response.data);
        setLoading(false);
      } catch (error) {
        console.error("Error fetching incidents:", error);
        setLoading(false);
      }
    };

    fetchIncidents();
  }, [refreshCounter]);

  return (
    <div className="container mx-auto px-4 py-8">
      <h1 className="text-3xl font-bold mb-6">Recent Incidents</h1>
      {loading ? (
        <p className="text-gray-600">Loading incidents...</p>
      ) : (
        <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-4">
          {incidents.map((incident) => (
            <IncidentCard
              key={incident.id}
              incidentId={incident.id}
              onIncidentChange={refreshIncidents}
            />
          ))}
        </div>
      )}
    </div>
  );
};

export default IncidentPage;
