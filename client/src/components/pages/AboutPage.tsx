import React from "react";

const AboutPage: React.FC = () => {
  return (
    <div>
      <h1>Dépôt Sauvage</h1>
      <p>
        Dépôt Sauvage is a web application developed using Java 22 and the
        Spring framework. It serves as a platform for reporting and managing
        instances of illegal waste dumping, facilitating communication between
        citizens and local authorities to combat environmental hazards
        effectively.
      </p>
      <h2>Description</h2>
      <p>
        Illegal waste dumping is a significant problem affecting many
        communities. Dépôt Sauvage aims to empower citizens by providing them
        with a tool to report such incidents swiftly. The platform also assists
        municipal services in efficiently managing reported incidents, thus
        enabling prompt actions to prevent environmental damage.
      </p>
      <h2>Stack</h2>
      <ul>
        <li>Java 22: The primary programming language for the application.</li>
        <li>
          Spring Boot: Facilitates rapid development and deployment of the web
          application.
        </li>
        <li>
          Spring MVC: Implements the Model-View-Controller design pattern for
          structured development.
        </li>
        <li>
          Spring Data JPA: Simplifies database operations using Spring and
          Hibernate.
        </li>
        <li>
          PostgreSQL: Used as the relational database to store application data.
        </li>
        <li>Maven: Manages project dependencies and builds.</li>
      </ul>
      <h2>Features</h2>
      <ul>
        <li>
          User Registration and Authentication: Users can sign up, log in, and
          manage their accounts.
        </li>
        <li>
          Report Incident: Users can report instances of illegal waste dumping
          by providing details and location.
        </li>
        <li>
          View Incidents: Authorities can view reported incidents and their
          details.
        </li>
        <li>
          Update Incident Status: Authorities can update the status of reported
          incidents (e.g., under review, resolved).
        </li>
        <li>
          Interactive Map: Display reported incidents on an interactive map for
          easy visualization.
        </li>
      </ul>
      <h2>Potential Future Improvements</h2>
      <ul>
        <li>
          Notifications: Automatic notifications to users upon incident status
          changes.
        </li>
        <li>
          Admin Dashboard: Administrative panel to manage users, incidents, and
          system settings.
        </li>
        <li>
          Data Analysis: Analyze reported incidents to identify patterns and
          trends.
        </li>
        <li>
          Mobile App: Develop a mobile application for easier reporting and
          access to the platform.
        </li>
        <li>
          Integration with Mapping Services: Integrate with popular mapping
          services for enhanced incident visualization.
        </li>
        <li>
          Multilingual Support: Add support for multiple languages to cater to a
          wider user base.
        </li>
        <li>
          Image Upload: Allow users to upload images as evidence when reporting
          incidents.
        </li>
        <li>
          Social Media Integration: Enable users to share reported incidents on
          social media platforms.
        </li>
        <li>
          Real-time Chat: Implement a chat feature for users to communicate with
          authorities or other users.
        </li>
        <li>
          Machine Learning: Utilize machine learning algorithms to automate
          incident classification and analysis.
        </li>
      </ul>
      <h2>Design Pattern</h2>
      <p>
        Dépôt Sauvage is designed following the MVC (Model-View-Controller)
        architectural pattern. The Model represents data structures and business
        logic, the View manages the presentation layer using React, and the
        Controller handles incoming requests, processes data, and interacts with
        services.
      </p>
      <p>
        Additionally, the application employs the Service Layer to encapsulate
        business logic and the Repository Layer for database interactions using
        Spring Data JPA.
      </p>
      <h2>API Endpoints</h2>
      <ul>
        <li>POST /api/register: User registration endpoint.</li>
        <li>POST /api/login: User authentication endpoint.</li>
        <li>POST /api/incidents: Endpoint to report a new incident.</li>
        <li>GET /api/incidents: Endpoint to fetch all reported incidents.</li>
        <li>
          GET /api/incidents/{"id"}: Endpoint to fetch details of a specific
          incident by ID.
        </li>
        <li>
          PUT /api/incidents/{"id"}: Endpoint to update the status of an
          incident by ID.
        </li>
      </ul>
      <h2>Getting Started</h2>
      <ol>
        <li>Clone the repository:</li>
        <pre>
          git clone https://github.com/lam-vincent/depot-sauvage.git cd
          depot-sauvage
        </pre>
        <li>Set Up Database:</li>
        <ul>
          <li>Create a PostgreSQL database.</li>
          <li>
            Update `application.properties` with your database credentials.
          </li>
        </ul>
        <li>Build and Run:</li>
        <ul>
          <li>Using Maven:</li>
          <pre>mvn spring-boot:run</pre>
        </ul>
        <li>Access the Application:</li>
        <p>
          Open a web browser and navigate to `http://localhost:8080` to use
          Dépôt Sauvage.
        </p>
      </ol>
    </div>
  );
};

export default AboutPage;
