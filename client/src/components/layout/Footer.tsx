import React from "react";

const Footer: React.FC = () => {
  return (
    <footer className="bg-gray-800 text-gray-300 py-4">
      <div className="container mx-auto px-4">
        <div className="flex justify-between items-center">
          <p className="text-sm">
            &copy; {new Date().getFullYear()} Dépôt Sauvage
          </p>
          <div>
            <a
              href="#"
              className="text-gray-300 hover:text-gray-500 px-3 py-1 text-sm"
            >
              Home
            </a>
            <a
              href="#"
              className="text-gray-300 hover:text-gray-500 px-3 py-1 text-sm"
            >
              About
            </a>
          </div>
        </div>
      </div>
    </footer>
  );
};

export default Footer;
