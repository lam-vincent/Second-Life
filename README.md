<br/>
<div align="center">

![Vite](https://img.shields.io/badge/Vite-B73BFE?style=for-the-badge&logo=vite&logoColor=FFD62E)
![React](https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB)
![TypeScript](https://img.shields.io/badge/TypeScript-007ACC?style=for-the-badge&logo=typescript&logoColor=white)
![Tailwind CSS](https://img.shields.io/badge/Tailwind_CSS-38B2AC?style=for-the-badge&logo=tailwind-css&logoColor=white)
![Material UI](https://img.shields.io/badge/Material%20UI-007FFF?style=for-the-badge&logo=mui&logoColor=white)
![GitHub Pages](https://img.shields.io/badge/GitHub%20Pages-222222?style=for-the-badge&logo=GitHub%20Pages&logoColor=white)

![NestJS](https://img.shields.io/badge/nestjs-E0234E?style=for-the-badge&logo=nestjs&logoColor=white)
![GraphQl](https://img.shields.io/badge/GraphQl-E10098?style=for-the-badge&logo=graphql&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=JSON%20web%20tokens&logoColor=white)

![Node js](https://img.shields.io/badge/Node%20js-339933?style=for-the-badge&logo=nodedotjs&logoColor=white)
![Prettier](https://img.shields.io/badge/prettier-1A2C34?style=for-the-badge&logo=prettier&logoColor=F7BA3E)
![Docker](https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=whitee)

<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRJgYKHcjaMek7hg2RJ0yly8M8BnEjj9Xdcj08BLw-jE2LeEm2_YK2NClOeQ9UJ_x3YZYY&usqp=CAU" alt="Logo" width="80" style="border-radius: 100%;">

<h1 align="center" id="top">Dépôt Sauvage</h3>

</div>

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
