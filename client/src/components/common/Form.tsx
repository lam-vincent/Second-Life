import React, { useState, useEffect } from "react";
import axios from "axios";

interface FormProps {
  initialPosition: { x: number; y: number };
}

const Form: React.FC<FormProps> = ({ initialPosition }) => {
  const [description, setDescription] = useState("");
  const [location, setLocation] = useState("");
  const [coordinates, setCoordinates] = useState("");
  const [status] = useState("REPORTED");

  useEffect(() => {
    // Set initial location based on clickPosition from MapPage
    setCoordinates(
      `(${initialPosition.x.toFixed(2)}, ${initialPosition.y.toFixed(2)})`
    );
  }, [initialPosition]);

  const handleFormSubmit = async (event: React.FormEvent) => {
    event.preventDefault();

    try {
      // Make POST request to API endpoint to add new incident
      const response = await axios.post("http://localhost:8080/api/incidents", {
        description,
        location,
        coordinates,
        status,
      });

      console.log("Incident added successfully:", response.data);
      alert("Incident added successfully!");

      // Reset form fields after successful submission
      setDescription("");
      setLocation("");
    } catch (error) {
      console.error("Error adding incident:", error);
    }
  };

  return (
    <div className="container mx-auto px-4 py-8">
      <h2 className="text-2xl font-bold mb-4">Report New Incident</h2>
      <form onSubmit={handleFormSubmit} className="space-y-4">
        <div>
          <label
            htmlFor="description"
            className="block text-sm font-medium text-gray-700"
          >
            Description
          </label>
          <input
            type="text"
            id="description"
            value={description}
            onChange={(e) => setDescription(e.target.value)}
            className="mt-1 block w-full border-gray-300 rounded-md shadow-sm focus:ring-blue-500 focus:border-blue-500 sm:text-sm"
            required
          />
        </div>
        <div>
          <label
            htmlFor="location"
            className="block text-sm font-medium text-gray-700"
          >
            Location
          </label>
          <input
            type="text"
            id="location"
            value={location}
            onChange={(e) => setLocation(e.target.value)}
            className="mt-1 block w-full border-gray-300 rounded-md shadow-sm focus:ring-blue-500 focus:border-blue-500 sm:text-sm"
            required
          />
        </div>
        <div>
          <label
            htmlFor="coordinates"
            className="block text-sm font-medium text-gray-700"
          >
            Coordinates
          </label>
          <input
            type="text"
            id="coordinates"
            value={coordinates}
            onChange={(e) => setCoordinates(e.target.value)}
            className="mt-1 block w-full border-gray-300 rounded-md shadow-sm focus:ring-blue-500 focus:border-blue-500 sm:text-sm"
            required
          />
        </div>
        <button
          type="submit"
          className="bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded"
        >
          Submit
        </button>
      </form>
    </div>
  );
};

export default Form;
