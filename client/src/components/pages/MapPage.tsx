import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import parisMapImage from "../../assets/paris-map.jpg";
import pinIcon from "../../assets/yellow-pin.svg";

const MapPage: React.FC = () => {
  const [clickPosition, setClickPosition] = useState<{ x: number; y: number }>({
    x: 0,
    y: 0,
  });
  const navigate = useNavigate();

  const handleMouseEvent = (event: React.MouseEvent<HTMLImageElement>) => {
    const { clientX, clientY, currentTarget } = event;
    const { left, top, width, height } = currentTarget.getBoundingClientRect();

    // Calculate position relative to the image
    const posX = (clientX - left) / width;
    const posY = (clientY - top) / height;

    // Normalize coordinates to image dimensions
    const imageX = posX * currentTarget.naturalWidth;
    const imageY = posY * currentTarget.naturalHeight;

    setClickPosition({ x: imageX, y: imageY });
  };

  const handleReportButtonClick = () => {
    navigate("/report", { state: { clickPosition } });
  };

  return (
    <div className="mx-auto max-w-4xl p-4">
      <h1 className="text-2xl font-bold mb-4">Map Page</h1>
      <div className="mb-2">
        <strong>Click Position:</strong> ({clickPosition.x.toFixed(2)},{" "}
        {clickPosition.y.toFixed(2)})
      </div>
      <div
        className="relative"
        style={{ width: "100%", height: "auto", position: "relative" }}
      >
        <img
          src={parisMapImage}
          alt="Paris Map"
          className="w-full rounded-lg cursor-pointer"
          onClick={handleMouseEvent}
          style={{ display: "block" }}
        />
        {clickPosition.x !== 0 && clickPosition.y !== 0 && (
          <img
            src={pinIcon}
            alt="Pin"
            className="absolute"
            style={{
              left: `${(clickPosition.x / 1440) * 100}%`,
              top: `${(clickPosition.y / 1024) * 100}%`,
              transform: "translate(-50%, -50%)",
              width: "32px",
              height: "32px",
            }}
          />
        )}
      </div>
      <button
        className="mt-4 bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded"
        onClick={handleReportButtonClick}
      >
        Go to Report Page
      </button>
    </div>
  );
};

export default MapPage;
