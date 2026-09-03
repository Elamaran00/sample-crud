# Student Management JSF

A complete, legacy-style Java 8 + JSF 2.2 + JPA + H2 web application for managing students, departments, and courses.
This project intentionally uses `javax.*` packages (Java EE 7), Java 8, and standard Facelets to serve as a migration-test project.

## Requirements
- Java 8 JDK
- Gradle 7.x (wrapper included)

## Build Instructions

To build the project:
```bash
./gradlew clean build
```

This will produce a standard `WAR` file at `build/libs/StudentManagementJSF.war`.

## Running the Application

### Deploy to Application Server
1. Download a Java EE 7 / Servlet 3.1 compatible server (e.g., Tomcat 9, WildFly 14).
2. Copy `build/libs/StudentManagementJSF.war` to your server's deployment directory (e.g., `webapps/` in Tomcat).
3. Start the server and navigate to `http://localhost:8080/StudentManagementJSF/`.

## Architecture & Technology Stack
- **Language**: Java 8
- **Build Tool**: Gradle 7.6.4
- **Web Framework**: JavaServer Faces (JSF) 2.2 (`com.sun.faces`)
- **Persistence**: JPA 2.1 (Hibernate 5.4.33.Final)
- **Database**: H2 Database (File-based: `~/studentdb`)
- **Namespaces**: `javax.faces.*`, `javax.persistence.*`, `javax.servlet.*`

## Features
- CRUD operations for Students, Departments, and Courses.
- Dashboard with statistics.
- H2 database automatically configured and schemas auto-updated.
