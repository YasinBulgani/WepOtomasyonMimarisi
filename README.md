# Web Otomasyon Mimarisi

This repository contains a sample Selenium+Cucumber setup. Test data and reports are kept under the `src/test` tree.

## Test Data

Data-driven scenarios can read from `src/test/java/com/data/test_data.csv`. The file currently includes sample user credentials:

```csv
username,password
user1@example.com,Password123
user2@example.com,Secret456
```

You can replace these rows or generate your own CSV file for additional scenarios.

## Test Reports

Cucumber generates an HTML report at `target/cucumber/report.html` when you run the tests with Maven:

```bash
mvn test
```

The `src/test/java/com/reports` folder will be populated automatically if you configure tools like ExtentReports. The previous placeholder file has been removed to avoid confusion.

