# CRM JDBC Project

A comprehensive command-line Customer Relationship Management (CRM) application built with Java. This project uses pure JDBC for database connectivity and Maven for dependency management and build automation. 

## Features

* **Database Schema Management**: Automatically creates a full 22-table CRM database schema.  

* **Structured Data Access**: Utilizes the DAO pattern to separate database logic from application logic. Each table is mapped to a Java model and managed by a corresponding DAO class.  

* **All CRUD Operations**  

* **Frequent Queries**: Includes a FrequentQueries DAO to run frequently asked queries on the database, such as:
    * Open opportunities by stage and value.
    * Monthly lead conversion rates.
    * Customer interaction summaries.
    * Overdue task tracking.
    * Top sales performer rankings.

## Prerequisites

Before you begin, ensure you have the following installed on your system:
* Java Development Kit (JDK) 11 or higher.
* Apache Maven.
* A running instance of MySQL Server.

## Setup and Configuration

Follow these steps to get the project running on your local machine.

**1. Clone the Repository**

git clone [https://github.com/Yashwardhan-ed/CRM-JDBC-.git](https://github.com/Yashwardhan-ed/CRM-JDBC-.git)
cd CRM-JDBC-

2. Create the MySQL Database
Log in to your MySQL client and create an empty database for the project.

CREATE DATABASE crm_db;

3. Configure Database Credentials
The project requires you to provide your local database credentials.

Navigate to src/main/java/com/crm/config/.

You will find a file named DatabaseConfig.java.template.

Make a copy of this file in the same directory and rename it to DatabaseConfig.java.

Open DatabaseConfig.java and replace the placeholder password with your actual MySQL database password.

// src/main/java/com/crm/config/DatabaseConfig.java
package com.crm.config;

public class DatabaseConfig {
    public static final String URL = "jdbc:mysql://localhost:3306/crm_db?serverTimezone=UTC";
    public static final String USER = "root";
    // Replace this with your real password
    public static final String PASSWORD = "YOUR_DATABASE_PASSWORD_HERE";
}

Note: The DatabaseConfig.java file is listed in .gitignore and will not be tracked by Git, keeping your credentials safe.

How to Run
All commands should be run from the root directory of the project.

1. Compile the Project
Use Maven to compile all source files and download dependencies.

mvn compile

2. Create the Database Schema
Run the SchemaInitializer application to create all the necessary tables in your database.

mvn exec:java -Dexec.mainClass="com.crm.app.SchemaInitializer"

3. Run the Reports
To see the reporting queries in action, run the Reports application.

mvn exec:java -Dexec.mainClass="com.crm.app.Reports"

Project Structure
The project follows a standard Maven directory structure, organized into packages based on responsibility.

└── src/main/java/com/crm/
    ├── app/          # Main runnable application classes (SchemaInitializer, Reports).
    ├── config/       # Database configuration files.
    ├── dao/          # Data Access Objects (DAOs) for all database interactions.
    ├── model/        # Plain Old Java Objects (POJOs) that model the database tables.
    └── setup/        # One-time setup classes, like SchemaSetup.
