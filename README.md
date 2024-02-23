# Dépôt Sauvage

Dépôt Sauvage is a web application designed to help communities and local authorities combat illegal waste dumping. It provides a platform for users to report and track instances of unauthorized waste disposal, enabling efficient communication between citizens and municipal services. The app aims to create awareness, prevent environmental harm, and streamline the process of reporting and managing waste-related incidents.

## Tech Stack

- **Frontend:**

  - Vite
  - React
  - TypeScript

- **Backend:**
  - NestJS
  - TypeScript
  - Express.js (implicitly used by NestJS)

## Installation and Usage

### Prerequisites

Make sure you have the following installed on your machine:

- [Node.js](https://nodejs.org/)
- [npm](https://www.npmjs.com/)

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/lam-vincent/depot-sauvage.git
   ```

2. Navigate to the project directory:

   ```bash
   cd depot-sauvage
   ```

3. Install dependencies for the frontend:

   ```bash
   cd client
   npm i
   ```

4. Install dependencies for the backend:

   ```bash
   cd ../server
   npm i
   ```

### Usage

1. Start the NestJS server:

   ```bash
   cd server
   npm run start
   ```

2. Start the Vite development server for the frontend:

   ```bash
   cd client
   npm run dev
   ```

3. Click on the link from the frontend server to access the web app.

### Build for Production

To build the frontend for production:

```bash
cd client
npm run build
```

The optimized production-ready files will be in the `client/dist` directory.

### Additional Configuration

- You need to configure environment variables in order to get the application up and running.

## License

This project is licensed under the [MIT License](LICENSE).
