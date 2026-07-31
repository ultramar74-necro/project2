##Project 2

Project Description

This project demonstrates the use of a Continuous Integration (CI) pipeline for a Java application. The project uses GitHub for source control, Maven for project management, Jenkins for build automation, JUnit for unit testing, JaCoCo for code coverage and SonarQube for static code analysis.

The pipeline automatically builds the project, runs the unit tests, generates a code coverage report and performs static code analysis whenever a build is executed.

##Unit Testing

JUnit test cases were written for the following classes:

- Student.java
- ClassGroup.java

A total of **16 test cases** were created:

- 9 test cases for Student.java
- 7 test cases for ClassGroup.java

The tests cover:

- Object creation
- Getter and setter methods
- Positive test cases
- Negative test cases
- Boundary conditions
- Collection operations
- Expected outputs using assertions

The project achieved **91.9% code coverage**.

## CI Pipeline

The Jenkins pipeline performs the following steps:

1. Clean the project.
2. Build the project using Maven.
3. Run all JUnit test cases.
4. Generate the JaCoCo coverage report.
5. Perform SonarQube static code analysis.
6. Publish the test results.

## Tools Used

- Java 17
- Maven
- JUnit 5
- JaCoCo
- Jenkins
- SonarQube
- Git
- GitHub
