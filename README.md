# OrangeHRM Test Automation Framework

A Selenium-based test automation framework for the [OrangeHRM](https://opensource-demo.orangehrmlive.com/) demo application, built with Java and Maven.

## 🎯 Purpose

This project demonstrates a UI test automation framework covering core OrangeHRM workflows — login, dashboard navigation, admin user management, and employee creation. It was built to practice and showcase test automation design patterns, framework architecture, and CI integration.

## 🛠️ Tech Stack

- **Language:** Java (JDK 25)
- **Build Tool:** Maven
- **Automation Tool:** Selenium WebDriver 4 (with `EventFiringDecorator` for centralized event handling)
- **Driver Management:** WebDriverManager (automatic browser driver resolution — no manual driver downloads)
- **Test Runner:** TestNG
- **Design Pattern:** Page Object Model (POM)
- **Test Data:** Data-driven testing via Excel (`orangehrmTestData/`), read using Apache POI
- **Logging:** Log4j2 — structured logging to console and rolling file appender (`logs/application.log`)
- **Reporting:** TestNG HTML report, Extent Report
- **Screenshot Capture:** Automatic screenshot capture on any Selenium action failure, via a custom `WebEventListener`
- **CI:** Jenkins (Maven-based freestyle job)

## 📁 Project Structure

```
orangehrmautomation/
├── orangehrmTestData/          # Excel test data files (read via Apache POI)
├── screenshots/                # Auto-captured screenshots on failure
├── logs/                       # Log4j2 output (application.log)
├── src/
│   ├── main/java/
│   │   ├── base/                # BaseTest - WebDriver lifecycle, config loading
│   │   ├── pages/                # Page Objects (POM)
│   │   └── Utilities/             # WaitUtils, DataProviderUtils, ScreenshotUtils, WebEventListener
│   ├── main/resources/
│   │   ├── config.properties      # Browser, URL, credentials config
│   │   ├── log4j2.xml              # Logging configuration
│   │   └── testng.xml               # TestNG suite definition
│   └── test/java/tests/            # Test classes
├── pom.xml                      # Maven dependencies and build configuration
```

## ✅ Features

- **Page Object Model** for maintainable, reusable page interactions
- **Data-driven testing** — employee creation test data pulled from Excel via Apache POI, decoupling test logic from test data
- **Centralized WebDriver lifecycle** — a `BaseTest` class handles driver initialization/teardown, reading browser and environment settings from `config.properties` (loaded via classpath, so the framework runs on any machine without hardcoded paths)
- **Custom wait strategy** — explicit `WebDriverWait` utilities instead of hardcoded sleeps
- **Event-driven logging & error capture** — a `WebEventListener` (via Selenium's `EventFiringDecorator`) logs every browser interaction and automatically captures a screenshot the moment any Selenium action throws an error
- **Structured logging** with Log4j2, written to both console and a rolling log file
- **Configurable browser selection** (Chrome/Firefox/Edge) via `config.properties`, with WebDriverManager handling driver binaries automatically

## 🚀 Getting Started

### Prerequisites
- Java JDK 25
- Maven 3.9+
- Chrome, Firefox, or Edge installed

### Installation
```bash
git clone https://github.com/dulinie/orangehrmautomation.git
cd orangehrmautomation
mvn clean install
```

### Running Tests
```bash
mvn clean test
```

The active browser, base URL, and login credentials are configured in `src/main/resources/config.properties`.

## 📊 Test Coverage

- **Login:** Page title and OrangeHRM logo validation
- **Home/Dashboard:** Title and dashboard header validation after login; navigation to Admin, PIM, and Leave tabs
- **Admin:** Page title, header, and "Add Employee" button visibility
- **Add Employee:** Data-driven creation of new employee user accounts, with role, status, and credentials pulled from an Excel sheet (multiple test data rows run automatically via a TestNG `DataProvider`)

## 📸 Logs, Reports & Screenshots

- **Logs:** Every browser interaction, test action, and error is logged via Log4j2 to `logs/application.log` and the console — useful for tracing exactly what happened leading up to a failure.
- **Reports:** TestNG HTML reports are generated under `target/surefire-reports` after each run.
- **Screenshots:** Captured automatically the moment any Selenium action fails (not just at test end), saved to the `screenshots/` folder with a timestamped filename — via a centralized event listener rather than manual calls in each test.

## 🔄 CI/CD

This framework runs through a **Jenkins** freestyle job configured to execute the Maven build (`clean install`) against this project. The job currently points directly at the local project workspace and is triggered manually; the natural next step is configuring Jenkins with SCM polling (or a webhook) against this GitHub repository so builds trigger automatically on every push, rather than running against the local filesystem directly.

## 📌 Known Limitations / Next Steps

- [ ] Wire Jenkins to check out from GitHub (SCM polling) instead of building from the local workspace directly
- [ ] Add a `Jenkinsfile` to define the pipeline as code
- [ ] Extend data-driven coverage and assertions to the PIM and Leave modules
- [ ] Add cross-browser execution as part of CI
- [ ] Add API-level tests alongside UI tests

## 👤 Author

**Dulinie Egodawatta** — [GitHub Profile](https://github.com/dulinie)

---
*This framework was built as part of ongoing QA/SDET skill development, with a focus on realistic framework design, debugging, and CI integration rather than tutorial-following.*