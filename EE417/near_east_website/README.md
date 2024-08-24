# Spring Boot Application - History_local

## Overview

This Spring Boot application serves as the server-side component of the project, integrating authentication, database connectivity, and functionalities from previous assignments. It works in tandem with the front-end project **Full_front_local**.

## Configuration

- **Tomcat Port**: 8081
- **IDE Used**: Eclipse for Web
- **Application Name**: History_local
- **Description**: The server-side section of the project includes authentication, database connectivity, and combines all functionalities from previous assignments into one project.
- **Corresponding Web Project**: Full_front_local

## Setup and Running the Application

1. **Unzip the Folders**: Extract both the front-end and back-end project folders.
   
2. **Install MySQL**: Ensure that MySQL is installed and running on your machine.

3. **Run the Spring Boot Application**:
   - Navigate to the app directory.
   - Run the following command to start the Spring Boot application:
     ```bash
     mvn spring-boot:run
     ```
   - The application will be available at `http://localhost:8081`.

4. **Deploy the Front-End**:
   - Start the Tomcat Manager at the default port (8080).
   - Deploy the `ROOT.war` file.
   - Access the front-end via the root path `/` at `http://localhost:8080`.

5. **Database Setup**: 
   - SQL scripts located in the `resources` folder will be executed upon initialization (DDL and DML).
   - The database is configured to automatically clean and initialize during app startup.

## User Credentials for Testing

You can access different functionalities with the following test accounts:

1. **Admin Account**:
   - **Username**: nancy.levant@info.org
   - **Password**: password

2. **User Account** (limited access):
   - **Username**: howard.egypt@info.org
   - **Password**: password1

3. **Writer Account**:
   - **Username**: joch.levant@info.org
   - **Password**: password

### User Roles and Permissions

- The difference between user roles is reflected in their access to different pages from the menu. If a user attempts to access a restricted page directly via URL, they will be redirected to the home page if they lack sufficient privileges.
- Permissions are managed both via browser-stored tokens and the security configuration in the Spring Boot application (endpoints are role-restricted).

## Application Functionalities

### Creating New Articles

- Navigate to the **New Article** tab in the navigation menu.
- Ensure each field is filled out as per the placeholders.
- Tags should be added in the format: `#tag1 #tag2` (space-separated).
- It's recommended to use small values (1-4) for the `user_id`.
  
> **Note**: Occasionally, submissions may fail due to database connection issues on the first try. If this happens, reload the page and try submitting again with a different `user_id`.

### Other Functionalities

- All `GET` requests from Assignment 3 have been carried over. You can:
  - Access user and article records independently.
  - Use the **Accordion List** to display article-user relationships.
