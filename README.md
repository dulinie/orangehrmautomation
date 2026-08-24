# OrangeHRM Test Automation Framework

A Selenium-based test automation framework for the [OrangeHRM](https://opensource-demo.orangehrmlive.com/) demo application, built with Java and Maven.

## 🎯 Purpose

This project demonstrates a scalable UI test automation framework covering core OrangeHRM workflows (login, employee management, leave management, etc. — *update with your actual covered flows*). It was built to practice and showcase modern test automation design patterns and best practices.

## 🛠️ Tech Stack

- **Language:** Java
- **Build Tool:** Maven
- **Automation Tool:** Selenium WebDriver
- **Test Runner:** TestNG 
- **Design Pattern:** Page Object Model (POM)
- **Test Data:** External data-driven approach via `orangehrmTestData`
- **Reporting:** Extent Reports, TestNG default HTML report
- **Screenshot Capture:** Automatic screenshot on test failure (see `screenshots/`)
- ** L

## 📁 Project Structure

```
orangehrmautomation/
├── .mvn/                  # Maven wrapper files
├── orangehrmTestData/     # External test data files
├── screenshots/           # Captured screenshots (e.g. on failure)
├── src/
│   ├── main/java/         # Framework core: Page Objects, utilities, base classes
│   └── test/java/         # Test classes / test cases
├── pom.xml                # Maven dependencies and build configuration
```

## ✅ Features

- Page Object Model for maintainable, reusable page interactions
- Data-driven testing using external test data files
- Automatic screenshot capture on test failure for easier debugging
- Configurable browser/environment setup 

## 🚀 Getting Started

### Prerequisites
- Java JDK 11+ *(update to your version)*
- Maven 3.6+
- Chrome/Firefox browser installed

### Installation
```bash
git clone https://github.com/dulinie/orangehrmautomation.git
cd orangehrmautomation
mvn clean install
```

### Running Tests
```bash
mvn test
```

*(Update this section if you use a specific TestNG suite XML file, e.g. `mvn test -DsuiteXmlFile=testng.xml`)*

## 📊 Sample Test Coverage

*(List a few example test scenarios here, e.g.:)*
- Verify successful login with valid credentials
- Verify error message on invalid login
- Add new employee record
- Apply for leave and verify leave request submission

## 📸 Reports & Screenshots

Test execution reports are generated in `target/surefire-reports` *(update path to match your reporting tool)*. Failure screenshots are automatically saved to the `screenshots/` folder.

## 🔄 CI/CD
This framework has been integrated with Jenkins for automated test execution.
Pipeline configuration: (Jenkinsfile / freestyle job — describe briefly)
Triggers: (on-demand / scheduled / on push — whichever applies)

## 📌 Future Improvements

- [ ] Add GitHub Actions CI pipeline
- [ ] Integrate Extent/Allure reporting
- [ ] Add cross-browser test execution
- [ ] Add API-level tests alongside UI tests

## 👤 Author

**Dulinie** — [GitHub Profile](https://github.com/dulinie)

---
*This framework was built as part of ongoing QA/SDET skill development.*
