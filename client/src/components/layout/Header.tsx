import React from "react";

const Header: React.FC = () => {
  return (
    <header className="text-emerald-700 py-4">
      <div className="container mx-auto px-4 flex justify-between items-center">
        <div>
          <h1 className="text-2xl font-bold">Dépôt Sauvage</h1>
        </div>
        <nav className="space-x-4">
          <a href="/" className="hover:text-green-500">
            Home
          </a>
          <a href="incidents" className="hover:text-green-500">
            Incidents
          </a>
          <a href="map" className="hover:text-green-500">
            Map
          </a>
          <a href="report" className="hover:text-green-500">
            Report
          </a>
          <a href="about" className="hover:text-green-500">
            About
          </a>
        </nav>
      </div>
    </header>
  );
};

export default Header;
