import React from "react";
import BasicLayout from "./components/layout/BasicLayout";
import HomePage from "./components/pages/HomePage";

const App: React.FC = () => {
  return (
    <BasicLayout>
      <HomePage />
    </BasicLayout>
  );
};

export default App;
