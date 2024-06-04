# Selenium-Java-Cucumber Automation Project

This project is a Selenium-Cucumber automation framework for testing the Accenture website. It uses Java for step definitions, Selenium for browser automation, and Cucumber for behavior-driven development (BDD).

## Project Structure

- **stepDefinitions:** Contains the Cucumber step definitions.
- **pageObjects:** Contains the Page Object Model (POM) classes.
- **utils:** Contains utility and helper classes for configuration and assertions.
- **resources:** Contains configuration file `config.properties`.

## Prerequisites

- Java 11 or later
- Maven
- ChromeDriver (WebDriverManager is used to manage this automatically)

## Running Tests

Use TestRunner:

1. Open your IDE (e.g., IntelliJ IDEA, Eclipse).
2. Navigate to **src/test/java/testRunner/TestRunner.java**
3. Right-click on the TestRunner class and select Run 'TestRunner'.

This will execute the Cucumber tests and generate the report.

Or execute the following command:

```sh
mvn test
