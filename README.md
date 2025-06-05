# Web Automation Framework

This project demonstrates a simple Selenium and Cucumber test setup that can be executed with Maven. The framework uses JUnit runners and reads browser configuration from property files.

## Prerequisites

* **Java** (JDK 17 or higher)
* **Maven** 3.x

### Installing Java on Ubuntu
```bash
sudo apt-get update
sudo apt-get install -y openjdk-17-jdk
java -version
```

### Installing Maven
```bash
sudo apt-get install -y maven
mvn -version
```

## Running Tests
1. Clone the repository and navigate to the project root.
2. Make sure the required browser driver is available under `drivers` or in your system `PATH`.
3. Execute the tests using Maven:
```bash
mvn test
```
This will run the scenarios tagged with `@test` and produce a Cucumber report at `target/cucumber/report.html`.

Any screenshots taken on failure are saved under `src/test/java/com/screenshots` and attached to the report.

## Configuration
Browser settings live in `src/browser.properties`:
```properties
browser=chrome
website.url=https://www.google.com.tr/
wait.timeout.seconds=10
```
Change the `browser` value (chrome, firefox, ie, opera) to switch drivers or update other properties for your target site.

![image](https://github.com/YasinBulgani/WepOtomasyonMimarisi/assets/119963496/bfe1e912-c0db-401f-a112-18410a9792a1)
