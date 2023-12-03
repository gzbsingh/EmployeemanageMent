# Employee Management System

## Project Overview

The Employee Management System is a RestApi application that allows you to manage and keep track of employees and departments within your organization. It provides features for adding, updating, and deleting employees and departments, as well as retrieving employee and department details.

## Technologies Used

- Java
- Spring Boot
- PostgreSQL (for Employee data)
- MongoDB (for Department data)
- Unit testing
## Project Structure

The project is structured as follows:

- `com.EmployeeManagement`: Root package for the application.
  - `Controller`: Contains the RESTful API controllers for both employees and departments.
  - `Model`: Defines the data models (Employee and Department).
  - `Repository`: Data repositories for Employee and Department entities.
  - `Service`: Contains the business logic and services for managing employees and departments.
  - `Exception`: Custom exception classes for handling errors.
- `resources`: Application configuration files, such as `application.properties`.
- `pom.xml`: Maven project configuration.

## RESTful API Endpoints

### Employee Management

- `GET /employees`: Retrieve a list of all employees.
- `GET find/employees/{id}`: Retrieve an employee by ID.
- `POST add/employees`: Create a new employee.
- `PUT update/employees/{id}`: Update an existing employee.
- `DELETE delete/employees/{id}`: Delete an employee by ID.

### Department Management

- `GET /departments`: Retrieve a list of all departments.
- `GET find/departments/{id}`: Retrieve a department by ID.
- `POST add/departments`: Create a new department.
- `PUT update/departments/{id}`: Update an existing department.
- `DELETE delete/departments/{id}`: Delete a department by ID.

## How to Run

1. Clone the repository from GitHub.
2. Open the project in your preferred Java IDE.
3. Configure the database settings in `application.properties`.
4. Run the application as a Spring Boot application.

## Testing

The project includes unit and integration tests for the services and controllers. You can run the tests using Maven:

```bash
mvn test
