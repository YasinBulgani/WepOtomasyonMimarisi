package com.example.project.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class DriverManager {
    public static void main(String[] args) {
        WebDriver driver = null;

        try {
            // WebDriverManager ile ChromeDriver'ı otomatik olarak yönetme
            WebDriverManager.chromedriver().setup();

            // ChromeDriver'ı oluşturma
            driver = new ChromeDriver();

            // Web sayfasına gitme
            driver.get("https://www.example.com");
            WebDriverWait wait = new WebDriverWait(driver, 20); // 20 saniye bekleyin (istediğiniz süreyi ayarlayabilirsiniz)
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Search']")));
            searchBox.sendKeys("Selenium WebDriver");

            WebElement searchButton = driver.findElement(By.name("btnK"));
            searchButton.click();

            // Sayfanın yüklenmesini beklemek için WebDriverWait kullanma
            WebElement resultsDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));

            // Ekran görüntüsü alma
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destinationFile = new File("screenshot.png");
            Files.copy(screenshotFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            // Test raporlama
            // Bu örnekte bir raporlama kütüphanesi kullanılmamıştır. Genellikle ExtentReports veya Allure gibi kütüphaneler tercih edilir.

            // Ekstra işlemler
            // ...

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // WebDriver'ı kapatma
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
