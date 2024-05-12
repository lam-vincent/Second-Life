import React, { useEffect, useState } from "react";
import axios from "axios";
import IncidentCard from "../common/IncidentCard";
import Incident from "../../types/Incident";

const IncidentPage: React.FC = () => {
  const [incidents, setIncidents] = useState<Incident[]>([]);
  const [loading, setLoading] = useState<boolean>(true);
  const [refreshCounter, setRefreshCounter] = useState<number>(0);
  const [filterStatus, setFilterStatus] = useState<string>("all");

  const refreshIncidents = () => {
    setRefreshCounter((prevCounter) => prevCounter + 1);
  };

  const fetchIncidents = async (status: string) => {
    setLoading(true);
    try {
      let url = "http://localhost:8080/api/incidents";
      if (status === "reported") {
        url = "http://localhost:8080/api/incidents/reported";
      } else if (status === "resolved") {
        url = "http://localhost:8080/api/incidents/resolved";
      }

      const response = await axios.get(url);
      setIncidents(response.data);
      setLoading(false);
    } catch (error) {
      console.error("Error fetching incidents:", error);
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchIncidents(filterStatus);
  }, [refreshCounter, filterStatus]);

  const handleFilterChange = (status: string) => {
    setFilterStatus(status);
  };

  return (
    <div className="container mx-auto px-4 py-8">
      <h1 className="text-3xl font-bold mb-6 text-green-700">
        Recent Incidents
      </h1>
      <div className="flex justify-center mb-4 space-x-4">
        <button
          className={`${
            filterStatus === "all"
              ? "bg-gradient-to-l from-green-500 to-green-700"
              : "bg-gray-300"
          } hover:from-green-700 hover:to-green-900 text-white font-bold py-2 px-4 rounded`}
          onClick={() => handleFilterChange("all")}
        >
          All
        </button>
        <button
          className={`${
            filterStatus === "reported"
              ? "bg-gradient-to-l from-green-500 to-green-700"
              : "bg-gray-300"
          } hover:from-green-700 hover:to-green-900 text-white font-bold py-2 px-4 rounded`}
          onClick={() => handleFilterChange("reported")}
        >
          Reported
        </button>
        <button
          className={`${
            filterStatus === "resolved"
              ? "bg-gradient-to-l from-green-500 to-green-700"
              : "bg-gray-300"
          } hover:from-green-700 hover:to-green-900 text-white font-bold py-2 px-4 rounded`}
          onClick={() => handleFilterChange("resolved")}
        >
          Resolved
        </button>
      </div>
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
