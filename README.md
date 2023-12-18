# Homestore E-Shop Automated Tests

This repository contains automated tests for the **`Homestore E-Shop`** web application. These tests are written in Java using Selenium, AssertJ, and JUnit frameworks to validate various functionalities of the application.

## Prerequisites

Before running the automated tests, ensure the following tools are installed:
- **Java Development Kit (JDK) 8** or above installed
- **Maven** build tool installed

## Setup

1. **Clone this repository:**
   ```bash
   git clone https://github.com/ViktorijaGol/homestore.git
    ```
2. **Navigate** to the project directory:
    ```bash
   cd homestore
    ```
3. **Install** required dependencies by using **Maven:**
   ```bash
   mvn clean install
    ```

## Running Tests

Run the following Maven command to execute all the tests:
   ```bash
   mvn test
   ```
This command will trigger the test suite and display the test execution results in the console.

## Test Structure

Tests are structured using **POM (Page Object Model)**, allowing for easy readability and maintenance. Key test scenarios covered include:

- **Login:** Testing the login functionality with valid and invalid credentials.
- **Product Detailed Page:** Verifying the functionality and accuracy of the product detail page.
- **Product Exploration:** Testing the navigation and exploration of various products/categories
- **Checkout:** Verifying the checkout process from cart addition to order placement.

## Test Structure

- **Selenium:** Used for web browser automation.
- **AssertJ:** Assertion library for fluent assertions in tests.
- **JUnit:** Testing framework for organizing and executing test cases.

## Folder Structure

- **/src/main/java:** Contains the utility classes, test pages and bars.
- **/src/test/java:** Houses the test cases.
- **/src/test/resources:** Includes test data, etc.

## Contributors

- Viktorija Golovinova [(@ViktorijaGol)](https://github.com/ViktorijaGol)

## Acknowledgments

Special thanks to the Homestore E-Shop development team for providing the test environment.