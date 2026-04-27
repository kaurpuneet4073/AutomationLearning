# AutomationLearning

A comprehensive Selenium-based test automation framework built with Java, Cucumber, and Playwright for learning and implementing automation best practices.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [Running Tests](#running-tests)
- [Project Architecture](#project-architecture)
- [Technologies Used](#technologies-used)
- [Reports](#reports)
- [Contributing](#contributing)
- [License](#license)

## 🎯 Overview

AutomationLearning is an educational test automation project designed to demonstrate industry best practices in web automation testing. The project utilizes the **BDD (Behavior-Driven Development)** approach with Cucumber to write human-readable test scenarios.

### Key Highlights:
- ✅ Cucumber BDD Framework for Gherkin-based testing
- ✅ Page Object Model (POM) pattern implementation
- ✅ Selenium 4.40.0 with WebDriver support
- ✅ Microsoft Playwright integration for cross-browser testing
- ✅ Extent Reports for detailed test reporting
- ✅ Screenshot capture on test failure
- ✅ Logback logging framework
- ✅ TestNG integration for test execution

## ✨ Features

- **BDD Framework**: Write tests in plain English using Gherkin syntax
- **Page Object Model**: Organized structure with separate methods and step definitions
- **Automated Screenshot Capture**: Screenshots are captured on test failure and attached to reports
- **Comprehensive Logging**: Logback logging for better debugging and troubleshooting
- **Cross-Browser Testing**: Support for Chrome and other browsers via Selenium WebDriver
- **Detailed Reports**: ChainTest reporting for visual test results
- **Hooks Support**: Before and After hooks for setup and teardown operations
- **Maven Build System**: Easy dependency management and project build

## 📁 Project Structure

```
AutomationLearning/
├── src/
│   └── test/
│       ├── java/
│       │   ├── LearningBasics/          # Basic automation learning examples
│       │   │   └── First.java           # First test class example
│       │   ├── page/                    # Page Object Model implementation
│       │   │   ├── methods/             # Page-specific methods
│       │   │   │   └── HomeMethods.java # Home page methods
│       │   │   └── steps/               # Step definitions
│       │   │       ├── HomeSteps.java   # Home page step implementations
│       │   │       └── Hooks.java       # Cucumber hooks (Before/After)
│       │   └── runner/                  # Test execution runner
│       │       └── Execution.java       # Cucumber test runner
│       └── resources/
│           ├── Features/                # Gherkin feature files
│           │   └── Home.feature         # Home page feature scenarios
│           ├── chaintest.properties     # ChainTest reporting configuration
│           └── logback.xml              # Logging configuration
├── ApplicationLogs/                     # Directory for application logs
├── ExtentReports/                       # Directory for test reports
├── Screenshots/                         # Directory for failure screenshots
├── pom.xml                              # Maven project configuration
└── README.md                            # This file
```

## 🔧 Prerequisites

Before getting started, ensure you have the following installed:

- **Java Development Kit (JDK)**: Version 26 or higher
- **Maven**: Version 3.6.0 or higher
- **Git**: For version control
- **Chrome Browser**: For Selenium WebDriver tests
- **IDE**: IntelliJ IDEA or Eclipse (optional)

### Verify Installation:

```bash
java -version
mvn -version
```

## 📦 Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/kaurpuneet4073/AutomationLearning.git
   cd AutomationLearning
   ```

2. **Install dependencies**:
   ```bash
   mvn clean install
   ```

3. **Download ChromeDriver** (if using Selenium WebDriver):
   - Download from [ChromeDriver](https://chromedriver.chromium.org/)
   - Ensure your Chrome version matches the ChromeDriver version
   - Place it in your system PATH or project directory

## ⚙️ Configuration

### ChainTest Configuration

Edit `src/test/resources/chaintest.properties` to customize reporting:

```properties
chaintest.project.name=Automation Learning
chaintest.generator.simple.enabled=true
chaintest.generator.simple.document-title=Automation Results
chaintest.generator.simple.output-file=ExtentReports/index-${run.timestamp}.html
chaintest.generator.simple.dark-theme=true
```

### Logging Configuration

Modify `src/test/resources/logback.xml` to adjust logging levels and output:

```xml
<logger name="page.steps" level="DEBUG" />
<appender name="FILE" class="ch.qos.logback.core.FileAppender">
    <file>ApplicationLogs/automation.log</file>
</appender>
```

## 🚀 Usage

### Understanding the Project Structure

#### Feature Files (BDD)
Feature files written in Gherkin syntax define test scenarios in human-readable language:

```gherkin
Feature: Verify the Homepage functionality
  @SmokeTest
  Scenario: Verify I am able to launch browser using Selenium
    Given User launch the Chrome browser
    When I enter the url "https://alphabetaops.com/"
    Then I should be able to access the homepage
```

#### Step Definitions
Java implementations of Gherkin steps handle the test logic:

```java
@Given("User launch the Chrome browser")
public void user_launch_the_chrome_browser() {
   System.out.println("Browser is launched");
}

@When("I enter the url {string}")
public void i_enter_the_url(String url) {
  driver.get(url);
}
```

#### Page Methods
Encapsulate page-specific interactions and locators in dedicated method classes.

#### Hooks
Global setup and teardown operations executed before and after each scenario.

## 🧪 Running Tests

### Run All Tests:
```bash
mvn test
```

### Run Specific Feature File:
```bash
mvn test -Dcucumber.features=src/test/resources/Features/Home.feature
```

### Run Tests with Specific Tag:
```bash
mvn test -Dcucumber.options="--tags @SmokeTest"
```

### Run from IDE:
1. Right-click on `Execution.java` (test runner)
2. Select "Run" or "Run with Coverage"

## 🏗️ Project Architecture

### Design Patterns Used

1. **Page Object Model (POM)**
   - Each web page has a corresponding methods class
   - Locators are centralized and maintainable
   - Reduces code duplication

2. **BDD (Behavior-Driven Development)**
   - Tests are written in human-readable Gherkin language
   - Bridges gap between business and technical teams
   - Easy to maintain and understand

3. **Step Definition Pattern**
   - Separates business logic from technical implementation
   - Reusable step definitions across multiple scenarios

### Workflow

```
Feature File (Gherkin)
        ↓
    Step Definitions
        ↓
    Page Methods (POM)
        ↓
    Selenium WebDriver
        ↓
    Test Execution & Reporting
```

## 🛠️ Technologies Used

| Technology | Version | Purpose |
|-----------|---------|---------|
| **Selenium WebDriver** | 4.40.0 | Web automation |
| **Cucumber** | 7.11.0 | BDD framework |
| **TestNG** | 7.12.0 | Test execution engine |
| **Playwright** | 1.58.0 | Cross-browser automation |
| **ChainTest** | 1.0.12 | Test reporting |
| **Logback** | 1.5.32 | Logging framework |
| **Java** | 26 | Programming language |
| **Maven** | Latest | Build tool |

## 📊 Reports

### Test Reports
Reports are generated in the `ExtentReports/` directory:
- **Location**: `ExtentReports/index-<timestamp>.html`
- **Format**: HTML with detailed test metrics
- **Theme**: Dark theme enabled for better readability
- **Includes**: Test steps, duration, and failure details

### Screenshots
Failed test screenshots are automatically captured:
- **Location**: `Screenshots/` directory
- **Format**: PNG files with scenario name
- **Attachment**: Screenshots are also attached to HTML reports

### Logs
Application logs are stored for debugging:
- **Location**: `ApplicationLogs/` directory
- **Configuration**: Defined in `logback.xml`

## 🤝 Contributing

Contributions are welcome! Please follow these guidelines:

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/your-feature`
3. Commit changes: `git commit -am 'Add new feature'`
4. Push to branch: `git push origin feature/your-feature`
5. Submit a pull request

### Code Standards:
- Follow Java naming conventions
- Write clear and descriptive test names
- Add comments for complex logic
- Keep methods focused and single-responsibility
- Use meaningful variable names

## 📝 License

This project is open source and available under the MIT License. See `LICENSE` file for details.

## 📞 Support & Contact

For questions, issues, or suggestions:
- Open an issue on GitHub
- Contact: [@kaurpuneet4073](https://github.com/kaurpuneet4073)

---

## 🚀 Quick Start Guide

```bash
# Clone the repo
git clone https://github.com/kaurpuneet4073/AutomationLearning.git
cd AutomationLearning

# Install dependencies
mvn clean install

# Run tests
mvn test

# View reports
# Open ExtentReports/index-<timestamp>.html in browser
```

---

**Happy Testing! 🎉**

Last Updated: April 27, 2026
