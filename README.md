# App Universitaria Database Docker Setup

This repository contains the Docker configuration for the App Universitaria MySQL database.

## Prerequisites

- Docker
- Docker Compose

## Getting Started

1. Make sure you have Docker and Docker Compose installed on your system.

2. Clone this repository and navigate to the project directory.

3. Start the database container:
```bash
docker-compose up -d
```

4. The database will be accessible with the following credentials:
   - Host: localhost
   - Port: 3307
   - Database: app_universitaria
   - Username: root
   - Password: root
   - Root Password: rootpassword

5. To stop the container:
```bash
docker-compose down
```

## Database Structure

The database includes the following tables:
- modulo
- noticias
- topicos

## Notes

- The database data will persist in a Docker volume named `mysql_data`
- The initial database schema and data will be automatically loaded from `database/app_universitaria.sql` when the container starts for the first time
- The MySQL server is configured to use the native password authentication plugin for better compatibility

## Database Initialization

The database is automatically initialized using the `app_universitaria.sql` script when the container starts for the first time. This script:
- Creates the database schema
- Creates all necessary tables
- Inserts initial data
- Sets up all required relationships and constraints

If you need to reinitialize the database:
1. Stop the container: `docker-compose down`
2. Remove the volume: `docker volume rm app_universitaria_mysql_data`
3. Start the container again: `docker-compose up -d` 