import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import BasicLayout from "./components/layout/BasicLayout";
import HomePage from "./components/pages/HomePage";
import IncidentPage from "./components/pages/IncidentPage";
import ReportPage from "./components/pages/ReportPage";
import MapPage from "./components/pages/MapPage";
import AboutPage from "./components/pages/AboutPage";

const App: React.FC = () => {
  return (
    <BrowserRouter>
      <BasicLayout>
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/report" element={<ReportPage />} />
          <Route path="/incidents" element={<IncidentPage />} />
          <Route path="/map" element={<MapPage />} />
          <Route path="/about" element={<AboutPage />} />
        </Routes>
      </BasicLayout>
    </BrowserRouter>
  );
};

export default App;
