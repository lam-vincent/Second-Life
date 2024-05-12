import React from "react";

const AboutPage: React.FC = () => {
  return (
    <div className="p-8 bg-green-100 rounded-lg">
      <h2 className="text-2xl font-bold mt-4 mb-2">🌱 Our Mission</h2>
      <p className="text-lg">
        Illegal waste dumping is a significant problem affecting many
        communities. Dépôt Sauvage aims to empower citizens by providing them
        with a tool to report such incidents swiftly. The platform also assists
        municipal services in efficiently managing reported incidents, thus
        enabling prompt actions to prevent environmental damage.
      </p>

      <h2 className="text-2xl font-bold mt-8 mb-2">👩‍👩‍👦‍👦 Our Team</h2>
      <ul className="list-disc ml-8">
        <li>Alice</li>
        <li>Alyson</li>
        <li>Charles</li>
        <li>Thaïs</li>
        <li>Saul</li>
        <li>Vincent</li>
      </ul>

      <h2 className="text-2xl font-bold mt-8 mb-2">🗺️ What You'll Find Here</h2>
      <p className="text-lg">
        On our platform, you'll find a map that displays reported incidents of
        illegal waste dumping. You can click on the pins to view more details
        about each incident. You can also report new incidents by clicking on
        the map and providing relevant information. Our platform is designed to
        be user-friendly and accessible to everyone.
      </p>
      <ul className="list-disc ml-8 mt-4">
        <li>Report incidents of illegal waste dumping</li>
        <li>View reported incidents on a map</li>
        <li>Track the status of reported incidents</li>
        <li>Collaborate with your community to keep your environment clean</li>
      </ul>
      <h2 className="text-2xl font-bold mt-8 mb-2">🌍 Our Vision</h2>
      <p className="text-lg">
        Our vision is to create a world where illegal waste dumping is a thing
        of the past. We envision a future where citizens, communities, and
        governments work together to keep our environment clean and safe for
        future generations.
      </p>
    </div>
  );
};

export default AboutPage;
