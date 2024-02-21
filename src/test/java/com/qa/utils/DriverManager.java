package com.qa.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;

public class DriverManager {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    // Diğer metodlar buraya eklenecek...

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void initializeDriver() {
        try {
            // ConfigReader sınıfını kullanarak browser.properties dosyasını yükleyerek verileri okuma
            String browser = ConfigReader.getProperty("browser");

            if (browser == null) {
                System.out.println("Tarayıcı belirtilmemiş.");
                return;
            }

            // WebDriverManager ile ilgili tarayıcı için sürücüyü otomatik olarak yönetme
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("ie")) {
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
            } else if (browser.equalsIgnoreCase("opera")) {
                WebDriverManager.operadriver().setup();
            } else {
                System.out.println("Belirtilen tarayıcı desteklenmiyor.");
                return;
            }

            // Web sayfasına gitme
            driver.get(ConfigReader.getProperty("website.url"));
            driver.manage().window().maximize();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void openAndSearch() {
        // Arama kutusunu bulma ve kullanma
        By searchBoxLocator = By.xpath(ConfigReader.getProperty("search.box.xpath"));
        WebElement searchButton = driver.findElement(searchBoxLocator);
        searchButton.click();

        // Ekran görüntüsü alma
        File screenshotsDir = new File("src/test/resources/screenshots");
        synchronized (screenshotsDir) {
            if (!screenshotsDir.exists()) {
                screenshotsDir.mkdirs();
            }
        }

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Ekstra işlemler
        // ...
    }
}