# OrangeHRM Automation Framework

This project is a Selenium-based test automation suite for the OrangeHRM demo application. It is built with Java, Maven, TestNG, and the Page Object Model (POM) to cover login, dashboard navigation, admin actions, and employee creation workflows.

## Overview

The framework is designed to automate UI validation against the OrangeHRM demo environment and keep tests maintainable through reusable page objects, centralized browser setup, and externalized configuration.

## Tech Stack

- Java 25
- Maven
- Selenium WebDriver 4
- TestNG
- WebDriverManager
- Apache POI
- Log4j2
- ExtentReports
- Page Object Model (POM)
- Leveraged GitHub Copilot in VS Code for AI-assisted code completion and Claude AI for code review and debugging support.

## Project Structure

```text
orangehrmautomation/
├── logs/                          # Log output generated during test execution
├── orangehrmTestData/             # Excel files used for data-driven tests
├── screenshots/                  # Screenshot artifacts captured during failures
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── base/
│   │   │   │   └── BaseTest.java
│   │   │   ├── pages/
│   │   │   │   ├── AddEmployeePage.java
│   │   │   │   ├── AdminPage.java
│   │   │   │   ├── HomePage.java
│   │   │   │   ├── LeavePage.java
│   │   │   │   ├── LoginPage.java
│   │   │   │   └── PIMPage.java
│   │   │   ├── Utilities/
│   │   │   │   ├── DataProviderUtils.java
│   │   │   │   ├── ScreenshotUtils.java
│   │   │   │   ├── WaitUtils.java
│   │   │   │   └── WebEventListener.java
│   │   │   └── com/orangehrmautomation/qa/ExtentReportListener/
│   │   └── resources/
│   │       ├── config.properties
│   │       ├── log4j2.xml
│   │       ├── testng.xml
│   │       ├── testng_regression.xml
│   │       └── testng_sanity.xml
│   └── test/
│       └── java/
│           └── tests/
│               ├── AddEmployeePageTest.java
│               ├── AdminPageTest.java
│               ├── HomePageTest.java
│               ├── LoginTest.java
│               └── TestBase.java
├── pom.xml
├── build.txt
├── README.md
├── target/                       # Maven build output and test reports
└── .gitignore
```

## Key Features

- POM-based test design for cleaner maintenance and readability
- Centralized browser initialization and configuration in `BaseTest`
- Browser selection through `config.properties` (Chrome, Firefox, or Edge)
- Automatic driver provisioning with WebDriverManager
- Data-driven employee creation using Excel files via Apache POI
- Log4j2 logging for runtime traceability
- Screenshot capture on failure through Selenium event listeners
- ExtentReports integration for richer reporting
- TestNG-based suite execution with reusable test classes

## Covered Test Scenarios

The suite includes tests for:

- Login functionality
- Dashboard and page title validation
- Navigation to Admin, PIM, and Leave sections
- Admin page interactions
- Add employee workflow using test data from Excel

The default suite in `src/main/resources/testng.xml` runs:

- `tests.LoginTest`
- `tests.HomePageTest`
- `tests.AdminPageTest`
- `tests.AddEmployeePageTest`

## Prerequisites

Before running the tests, make sure you have:

- JDK 25 installed
- Maven 3.9+ installed
- Chrome, Firefox, or Edge installed locally

## Configuration

The application URL, username, password, and browser are stored in:

`src/main/resources/config.properties`

Example values:

```properties
url = https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
username = Admin
password = admin123
browser = chrome
```

## Running the Tests

Run the full suite:

```bash
mvn clean test
```

Run a specific test class:

```bash
mvn -Dtest=LoginTest test
mvn -Dtest=HomePageTest test
mvn -Dtest=AddEmployeePageTest test
```

Run a specific TestNG suite file if needed:

```bash
mvn test -DsuiteXmlFile=src/main/resources/testng.xml
```

## Reports and Artifacts

After execution, reports and artifacts are generated in:

- `target/surefire-reports/` — TestNG HTML/XML reports
- `screenshots/` — failure screenshots
- `logs/` — runtime log files

## CI/CD
This framework is integrated with Jenkins using two Maven-based freestyle jobs:

Local build job — runs directly against the local project workspace, useful for quick validation during active development.
GitHub-integrated job — checks out this repository from GitHub and runs the same Maven build, keeping CI results tied to the actual pushed code rather than the local filesystem.
Both jobs execute the full TestNG suite and publish HTML test reports.

## Notes

- The project uses a data-driven pattern for employee creation through `orangehrmTestData/OrangeHRMDemData.xlsx`.
- Test execution depends on the OrangeHRM demo environment being available.
- If Maven encounters a stale file issue during `clean`, close the browser or any process holding the generated report files and rerun the command.

## Author

Dulinie Egodawatta

## Project Purpose

This repository demonstrates hands-on automation testing practice for a real-world web application using Java-based UI automation, maintainable test design, and reporting best practices.