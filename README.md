#Test SCM Poll 
#Project 2 

## Project Description

This project demonstrates the implementation of a Continuous Integration (CI) pipeline for a Java application. It integrates GitHub for version control, Maven for project management, Jenkins for build automation, JUnit 5 for unit testing, Mockito for mocking, JaCoCo for code coverage, and SonarQube for static code analysis.

The CI pipeline automatically builds the project, executes all unit tests, generates a code coverage report, performs static code analysis, and publishes the test results whenever a build is executed.

---

## Unit Testing

JUnit test cases were written for the following classes:

- Student.java
- ClassGroup.java

A total of **24 unit test cases** were implemented:

- **16 test cases** for `Student.java`
- **8 test cases** for `ClassGroup.java`

The test suite covers:

- Object construction
- Getter and setter methods
- Equality and hashCode validation
- Comparator methods
- String representation
- Positive and negative test cases
- Boundary and edge case testing
- Collection operations
- Expected outputs using assertions

### Mockito Testing

Mockito was introduced to test the `assignRandomUsername(Random random)` method in `Student.java`.

Since random number generation is non-deterministic and can produce different results each time the program runs, a mocked `Random` object was used to provide predictable values during testing. This allows the method to be tested consistently and demonstrates the use of mocking for isolating external behaviour.

### Edge Case Testing

Additional edge case tests were implemented to improve software quality and code coverage, including:

- Comparing a Student object with `null`
- Comparing a Student object with a different object type
- Comparing students with identical names
- Comparing students with identical birthdays
- Verifying `toString()` when a best friend exists
- Removing the only student in a class group
- Retrieving the oldest student from a class containing only one student

The project achieved:

- **99.3% JaCoCo code coverage (Eclipse)**
- **92.9% code coverage reported by SonarQube**
- **24/24 unit tests passing**

---

## Continuous Integration Pipeline

The Jenkins pipeline performs the following stages:

1. Clean the project
2. Build the project using Maven
3. Execute all JUnit test cases
4. Generate the JaCoCo code coverage report
5. Perform SonarQube static code analysis
6. Publish the JUnit test results

The pipeline provides automated verification of code quality after every build.

---

## Code Quality

The project successfully passed the SonarQube Quality Gate with:

- Quality Gate: **Passed**
- Security Rating: **A**
- Reliability Rating: **A**
- Maintainability Rating: **A**
- 0 Bugs
- 0 Vulnerabilities
- 0 Code Smells
- 0 Security Hotspots
- 0% Code Duplication

---

## Tools Used

- Java 17
- Maven
- JUnit 5
- Mockito
- JaCoCo
- Jenkins
- SonarQube Community Edition
- Git
- GitHub
- Eclipse IDE

---

## Git Workflow

Development was carried out using feature branches before merging into the `master` branch.

Feature branches included:

- `feature/student-tests`
- `feature/sonarqube-integration`
- `feature/mockito-tests`
- `feature/edge-case-tests`
- `refactor/sonarqube-cleanup`

This workflow allowed new functionality and improvements to be developed and tested independently before integration.

---

## About

Fork of **shittake/project2** for **CDV1C02 Project Part 2**.

The project demonstrates the practical application of Continuous Integration by combining automated builds, unit testing, code coverage analysis, static code analysis, and version control using industry-standard DevOps tools.