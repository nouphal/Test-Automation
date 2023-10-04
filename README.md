# Automated Test for Web Application Using Java and Selenium

# Google Finace Page Test Automation

This project contains an automated test script written in Java using Selenium WebDriver and TestNG. The script performs the following tasks:

1. Opens the Google Finance webpage.
2. Verifies the page title.
3. Retrieves stock symbols listed under the section "You may be interested in info."
4. Compares the retrieved stock symbols with the expected stock symbols.
5. Prints stock symbols that are missing in either the expected or actual list.

## Prerequisites

Before running the test script, ensure you have the following set up:

1. Java Development Kit (JDK) installed on your system.
2. Selenium WebDriver set up in your Java project.
3. TestNG framework installed in your development environment.
4. The Chrome WebDriver executable (chromedriver.exe) compatible with your Chrome browser version.

## Usage

1. Clone or download this repository to your local machine.

2. Open the project in your Java development environment (e.g., Eclipse, IntelliJ IDEA).

3. Update the path to the Chrome WebDriver executable in the `GoogleFinanceAutomationTest` class:System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");

4. mvn test -DsuiteXmlFile=testng.xml



