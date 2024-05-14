import React from "react";

const HomePage: React.FC = () => {
  return (
    <div className="bg-gray-100 min-h-screen flex  rounded-2xl">
      <div className="container mx-auto px-4 py-8 ml-8">
        <h1 className="text-5xl font-bold mb-4 font-serif text-green-700 mt-8">
          Clean Streets Make 🍃
        </h1>
        <h2 className="text-5xl font-bold mb-4 font-serif text-green-700">
          😎 Better Lives
        </h2>
        <p className="text-lg text-green-700 font-light mb-6">
          Reporting and tracking incidents of illegal waste dumping made easy.
        </p>
        <div className="flex justify-center">
          <a
            href="map"
            className="text-white font-medium py-3 px-8 font-sans bg-gradient-to-l from-green-500 to-green-700 rounded hover:from-green-700 hover:to-green-900 mt-6"
          >
            Go Report
          </a>
        </div>
      </div>
      <div className="container mx-auto px-4 py-8">
        <div className="flex justify-center mt-8">
          <img
            src="homepage.jpeg"
            alt="Clean Streets Make Better Lives"
            className="rounded-lg"
          />
        </div>
      </div>
    </div>
  );
};

export default HomePage;
