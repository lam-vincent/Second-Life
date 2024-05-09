import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import parisMapImage from "../../assets/paris-map.jpg";

const MapPage: React.FC = () => {
  const [mousePosition, setMousePosition] = useState<{ x: number; y: number }>({
    x: 0,
    y: 0,
  });
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

    // Determine which state to update based on the event type
    const updatePosition =
      event.type === "mousemove" ? setMousePosition : setClickPosition;

    // Update state with the calculated position
    updatePosition({ x: imageX, y: imageY });
  };

  const handleReportButtonClick = () => {
    // Redirect to the report page and pass the clickPosition as state
    navigate("/report", { state: { clickPosition } });
  };

  return (
    <div>
      <h1>Map Page</h1>
      <div style={{ marginTop: "20px" }}>
        <strong>Mouse Position:</strong> ({mousePosition.x.toFixed(2)},{" "}
        {mousePosition.y.toFixed(2)})
      </div>
      <div>
        <strong>Click Position:</strong> ({clickPosition.x.toFixed(2)},{" "}
        {clickPosition.y.toFixed(2)})
      </div>
      <img
        src={parisMapImage}
        alt="Paris Map"
        style={{ maxWidth: "100%" }}
        onMouseMove={handleMouseEvent}
        onClick={handleMouseEvent}
      />
      <button onClick={handleReportButtonClick}>Go to Report Page</button>
    </div>
  );
};

export default MapPage;
