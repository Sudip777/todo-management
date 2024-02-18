# Todo Management with React and Spring Boot

This project is a Todo management application built with a React frontend for the user interface and a Spring Boot backend for the API.

## Table of Contents

- [Introduction](#introduction)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Development](#development)
- [Production](#production)
- [API Documentation](#api-documentation)


---

## Introduction

This Todo management application combines the power of React for the frontend and Spring Boot for the backend, creating a robust and efficient solution for managing Todo items.

---

## Project Structure

### React Frontend
#### Dependencies:

- React
- Axios
- Bootstrap
- Formik
- Moment
- React Icons
- React Router DOM

#### Scripts:

- `dev`: Run the development server with Vite.
- `build`: Build the production-ready application.
- `lint`: Run ESLint for code linting.
- `preview`: Preview the production build.

### Spring Boot Backend

The Spring Boot backend of the application is organized as follows:

#### Dependencies:

- Spring Boot Web
- Spring Boot Security
- Spring Boot OAuth2 Resource Server
- Spring Boot Validation
- Spring Boot Data JPA
- H2 Database
- Spring Boot DevTools
- Spring Boot Starter Test

---

## Getting Started

### Prerequisites

Before you begin, ensure you have the following installed:

- [Node.js](https://nodejs.org/) and [npm](https://www.npmjs.com/) for React development.
- [Java 17](https://adoptium.net/) and [Maven](https://maven.apache.org/) for Spring Boot development.

### Installation

1. **Clone the Repository**

    ```bash
    git clone https://github.com/your-username/todo.git
    cd todo
    ```

2. **Install Dependencies (React)**

    ```bash
    cd todo
    npm install
    ```

3. **Install Dependencies (Spring Boot)**

    - Open the `restful-web-services` folder in your preferred IDE.
    - Build the project to download Maven dependencies.

4. **Configure Database (Optional)**

    By default, the project uses an H2 in-memory database. Modify `application.properties` for other databases.

5. **Run the Application**

    - Start the React development server:

        ```bash
        npm run dev
        ```

    - Run the Spring Boot application.

6. **Access the Application**

    - Open your browser and go to `http://localhost:3000` to access the React frontend.
    - API endpoints are available at `http://localhost:8080`.

---

## Development

For React development, use `npm run dev` and access the development server at `http://localhost:3000`.

For Spring Boot development, run the application in your IDE.

---

## Production

To prepare for production:

- Build the React application using `npm run build`.
- Package the Spring Boot application using the Maven `spring-boot:repackage` goal.

---

## API Documentation



### Retrieve Todos


**Endpoint:**
GET /users/{username}/todos

**Description:**
Retrieve all Todo items for a specific user.

**Parameters:**
- `username` (path): The username of the user whose Todo items are to be retrieved.
  
**Example Request:**
```bash
curl -X GET http://localhost:8080/users/johndoe/todos

Example Response:
```json
[
  {
    "id": 1,
    "username": "johndoe",
    "description": "Complete task 1",
    "done": false
  },
  {
    "id": 2,
    "username": "johndoe",
    "description": "Read a book",
    "done": true
  }
]
```

### Retrieve a Todo


**Endpoint:**
GET /users/{username}/todos/{id}

**Description:**
Retrieve a specific Todo item for a user.

**Parameters:**
- `username` (path): The username of the user.
- `id` (path): The ID of the Todo item to retrieve.
- 
**Example Request:**
curl -X GET http://localhost:8080/users/johndoe/todos/1

**Example Response:**
```json
{
  "id": 1,
  "username": "johndoe",
  "description": "Complete task 1",
  "done": false
}
```

### Delete a Todo


**Endpoint:**
DELETE /users/{username}/todos/{id}

**Description:**
Delete a specific Todo item for a user.

**Parameters:**
- `username` (path): The username of the user.
- `path` (path): The ID of the Todo item to delete.
- 
**Example Request:**
curl -X DELETE http://localhost:8080/users/johndoe/todos/1

**Example Response:**
{} // Empty response with 204 No Content status

### Update a Todo


**Endpoint:**
PUT /users/{username}/todos/{id}

**Description:**
Update a specific Todo item for a user.

**Parameters:**
- `username` (path): The username of the user.
- `id` (path): The ID of the Todo item to update.
- `todo`(body): Updated Todo item in the request body.
- 
**Example Request:**
  
curl -X PUT -H "Content-Type: application/json" -d '{"id": 1, "username": "johndoe", "description": "Updated task", "done": true}' 
http://localhost:8080/users/johndoe/todos/1

**Example Response:**
```json
{
  "id": 1,
  "username": "johndoe",
  "description": "Updated task",
  "done": true
}
```

### Create a Todo


**Endpoint:**
POST /users/{username}/todos

**Description:**
Create a new Todo item for a user.

**Parameters:**
- `username` (path): The username of the user.
- `todo` (body): Todo item to create in the request body.
- 
**Example Request:**
  
curl -X POST -H "Content-Type: application/json" -d '{"username": "johndoe", "description": "New task", "done": false}' 
http://localhost:8080/users/johndoe/todos

**Example Response:**
```json
{
  "id": 3,
  "username": "johndoe",
  "description": "New task",
  "done": false
}
```







