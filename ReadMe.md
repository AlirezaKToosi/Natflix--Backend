# Natflix Backend Project 

## Backend

### Project Overview

Natflix functions as a Spring Boot application that establishes a connection with a MySQL database and serves as a server for the Natflix frontend and offering a diverse selection of movies, series, and documentaries. The platform comprises a web application employing React for the frontend and Spring Boot for the backend.
Users have the capability to log in to the platform and peruse an extensive range of content categories, including movies, series, and documentaries. Furthermore, users can employ filtering and search functionalities to locate specific content and initiate playback.
For administrative purposes, authorized users possess the ability to introduce new content items and modify existing ones within the system.
You can locate the Natflix frontend in its dedicated repository, where it can be run independently on port 3000. The backend accepts requests originating from localhost:3000.
Within the target directory in this repository, you'll find a dockerfile and docker images of the project.

## Backend

The backend for this project will be developed using Java with the SpringBoot framework and Hibernate for database interaction. connect the backend to a MySQL database using IntelliJ IDEA.

## Run the application
### A:  with use of Docker image:
To run this application do the following steps.
1. git clone https://github.com/rashmoni/Natflix
2. docker compose up
3. Access the application on port 8000,8085.

### B:  with use of Jar file:
### Prerequisites
Before you can run the  program , make sure you have the following prerequisites installed on your system:

   1. Java Development Kit (JDK) - Ensure you have Java 8 or higher installed.
   2. MySQL - You need a MySQL database instance.


### Setting Up the Database

   1. Create a database in your MySQL
   2. Update the application.properties file located in the src/main/resources 
        spring.datasource.url: Set the URL of your MySQL database.
        spring.datasource.username: Set the username for your MySQL instance.
        spring.datasource.password: Set the password for your MySQL instance.
### Running the Backend

1. Open a terminal in the ShoppingCard-Backend folder. 
2. Build the project using Maven 
3. Run the backend application using the following command:
4. java -jar Natflix__Backend_jar 
5. Running the app at http://localhost:8080.

## Document
1. [Class Diagram](https://drive.google.com/file/d/1W3l04KgrZ5CY9UkKY_5K5j0e9mKcpefR/view?usp=sharing) <br />
3. [Stories and tasks - Trello](https://trello.com/invite/b/E8J3szG7/ATTI876c4faaeff425510319c735b14ed3cc996FED4D/natflix)<br />
4. [Use case diagram](https://drive.google.com/file/d/11kok_6lyryNMcmKk8B_fbMF1f60dIstP/view?usp=drive_link)<br />


##  Java version
17.0.2






