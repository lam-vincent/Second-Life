# Dépôt Sauvage

Dépôt Sauvage is a web application developed using Java 22 and the Spring framework. It serves as a platform for reporting and managing instances of illegal waste dumping, facilitating communication between citizens and local authorities to combat environmental hazards effectively.

## Description

Illegal waste dumping is a significant problem affecting many communities. Dépôt Sauvage aims to empower citizens by providing them with a tool to report such incidents swiftly. The platform also assists municipal services in efficiently managing reported incidents, thus enabling prompt actions to prevent environmental damage.

## Stack

- **Java 22**: The primary programming language for the application.
- **Spring Boot**: Facilitates rapid development and deployment of the web application.
- **Spring MVC**: Implements the Model-View-Controller design pattern for structured development.
- **Spring Data JPA**: Simplifies database operations using Spring and Hibernate.
- **Thymeleaf**: Provides server-side templating for rendering web pages.
- **Bootstrap**: Ensures responsive and modern user interface design.
- **MySQL/PostgreSQL**: Used as the relational database to store application data.
- **Maven/Gradle**: Manages project dependencies and builds.

## Features

- **User Registration and Authentication**: Users can sign up, log in, and manage their accounts.
- **Report Incident**: Users can report instances of illegal waste dumping by providing details and location.
- **View Incidents**: Authorities can view reported incidents and their details.
- **Update Incident Status**: Authorities can update the status of reported incidents (e.g., under review, resolved).
- **Interactive Map**: Display reported incidents on an interactive map for easy visualization.
- **Notifications**: Automatic notifications to users upon incident status changes.
- **Admin Dashboard**: Administrative panel to manage users, incidents, and system settings.

## Design Pattern

Dépôt Sauvage is designed following the **MVC (Model-View-Controller)** architectural pattern:

- **Model**: Represents data structures and business logic (e.g., Incident, User).
- **View**: Manages the presentation layer, rendering data to users (HTML templates using Thymeleaf).
- **Controller**: Handles incoming requests, processes data, and interacts with services.

Additionally, the application employs **Service Layer** to encapsulate business logic and **Repository Layer** for database interactions using Spring Data JPA.

## API Endpoints

The application exposes the following RESTful API endpoints:

- `POST /api/register`: User registration endpoint.
- `POST /api/login`: User authentication endpoint.
- `POST /api/incidents`: Endpoint to report a new incident.
- `GET /api/incidents`: Endpoint to fetch all reported incidents.
- `GET /api/incidents/{id}`: Endpoint to fetch details of a specific incident by ID.
- `PUT /api/incidents/{id}`: Endpoint to update the status of an incident by ID.

## Getting Started

1. **Clone the repository**:

   ```bash
   git clone https://github.com/your/repository.git
   cd depot-sauvage
   ```

2. **Set Up Database**:

   - Create a MySQL or PostgreSQL database.
   - Update `application.properties` with your database credentials.

3. **Build and Run**:

   - Using Maven:

     ```bash
     mvn spring-boot:run
     ```

   - Using Gradle:

     ```bash
     ./gradlew bootRun
     ```

4. **Access the Application**:

   Open a web browser and navigate to `http://localhost:8080` to use Dépôt Sauvage.
