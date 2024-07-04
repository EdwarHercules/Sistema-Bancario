# Banking System - README

This repository contains the source code and necessary resources for the project developed using Spring Boot and MySQL.

## Repository Contents

- **BaseDatos.sql**: MySQL database script that includes table structures and initial data.
- **Prueba_API_Devsu_Company.postman_collection.json**: Postman collection for validating the API endpoints of the banking system.
- **src/**: Source code of the Java Spring Boot project.
- **README.md**: This file provides information on how to configure and run the project.

## Deployment Instructions

### Database and Data Schema

1. **Database Script**: Run the `BaseDatos.sql` script to create the database and necessary tables in MySQL.
   Ensure MySQL is running on port 3308.

### RabbitMQ Configuration

1. **Access RabbitMQ Interface**: Access the RabbitMQ interface at [http://localhost:15672](http://localhost:15672).
2. **Create a New Queue**: Create a new queue named `clienteQueue` for message handling.

### Postman File

1. **Postman Collection**: Use the `Prueba_API_Devsu_Company.postman_collection.json` collection to validate the endpoints and their functionality.

### Application Deployment

1. **Clone and Open the Project**: Clone this repository and open the project in your development environment.
2. **Configure Environment Variables**: If necessary, configure the following environment variables in your development environment:

   ```properties
   SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3308/sistema_bancario
   SPRING_DATASOURCE_USERNAME= designated_host
   SPRING_DATASOURCE_PASSWORD= designated_password
   SPRING_RABBITMQ_HOST=localhost
   SPRING_RABBITMQ_PORT=5672
