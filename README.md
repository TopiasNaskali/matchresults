# Matchresults

This project is a Java Spring Boot application with Thymeleaf, designed for storing and managing sports match results. Each match is associated with a referee, and the application provides CRUD operations for managing both matches and referees. Additionally, the application features user authentication implemented with Spring Security, with defined user and admin roles. The H2 database is used to store the data.

## Features

1. **Authentication and Roles:**
   - Secure login functionality implemented using Spring Security.
   - Users can register and log in with defined roles (user and admin).

2. **Match Management:**
   - Create, Read, Update, and Delete (CRUD) operations for match results.
   - Each match includes information about the associated referee.

3. **Referee Management:**
   - CRUD operations for managing referees.

4. **Role-based Access Control:**
   - Different roles (user and admin) determine access levels within the application.
   - Admins have additional privileges compared to regular users.

## Technologies Used

- Java Spring Boot
- Thymeleaf
- Spring Security
- H2 Database

## Getting Started

1. Clone the repository.
2. Configure the database connection in the application.properties file.
3. Run the application using your preferred IDE or build tools.


