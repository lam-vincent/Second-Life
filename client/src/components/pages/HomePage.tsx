import React from "react";

const HomePage: React.FC = () => {
  return (
    <div className="bg-gray-100 min-h-screen">
      <div className="container mx-auto px-4 py-8">
        <h1 className="text-3xl font-bold mb-4">Welcome to Dépôt Sauvage</h1>
        <p className="text-lg text-gray-700 mb-6">
          Reporting and tracking incidents of illegal waste dumping made easy.
        </p>
        <div className="flex justify-center">
          <a
            href="report"
            className="bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded"
          >
            Go Report your First Incident
          </a>
        </div>
      </div>
    </div>
  );
};

export default HomePage;
