package stepdef;

import com.qa.utils.TestUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static com.qa.utils.DriverManager.driver;

public class MySteps {
    TestUtils utils = new TestUtils();
    private Properties locators;
    private Map<String, String> savedVariables = new HashMap<>();


    @And("User waits for {int} seconds")
    public void userWaitsForSeconds(int saniye) throws InterruptedException {
        Thread.sleep(saniye * 1000); // Saniyeyi milisaniye cinsine çevirerek bekleyin
    }

    @And("I clicks the {string}")
    public void userClicksOnElementById(String elementName) {
        String xpath = locators.getProperty(elementName);
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
    }
    @When("I see {string} page")
    public void IseePage(String element) throws Exception {
        locators = new Properties();
        try {
            String fileName = "src/test/resources/XpathFile/" + element + ".properties";
            FileInputStream input = new FileInputStream(fileName);
            locators.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @And("User enters text {string} without clicking")
    public void userEntersTextWithoutClicking(String text) {
        // Belirli bir element tanımlanmadan sadece metin girişi yapılıyor
        Actions actions = new Actions(driver);
        actions.sendKeys(text).perform();
    }
    @And("User presses {string} key")
    public void userPressesKey(String key) {
        Actions actions = new Actions(driver);

        switch (key.toLowerCase()) {
            case "enter":
                actions.sendKeys(Keys.ENTER).perform();
                break;
            case "esc":
                actions.sendKeys(Keys.ESCAPE).perform();
                break;

            // Diğer tuşlar için gerekirse eklemeler yapabilirsiniz
            default:
                System.out.println("Belirtilen tuş desteklenmiyor.");
                break;
        }
    }



    @And("User waits to see the element with {string}")
    public void userWaitsToSeeElementById(String elementId) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementId)));
    }

    @And("User waits to not see the element with id {string}")
    public void userWaitsToNotSeeElementById(String elementId) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean elementNotVisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(elementId)));
        Assert.assertTrue(elementNotVisible);
    }

    @And("User waits to see the element with id {string} with text {string}")
    public void userWaitsToSeeElementWithText(String elementId, String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementId)));
        Assert.assertEquals(expectedText, element.getText());
    }

    @And("User waits for the element with id {string} to be clickable")
    public void userWaitsForElementToBeClickable(String elementId) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(elementId)));
    }

    @And("User waits for the element with id {string} to be not clickable")
    public void userWaitsForElementToNotBeClickable(String elementId) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean elementNotClickable = wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.id(elementId))));
        Assert.assertTrue(elementNotClickable);
    }

    @And("User waits for the element with id {string} to be clickable and clicks it")
    public void userWaitsForElementToBeClickableAndClicksIt(String elementId) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(elementId)));
        element.click();
    }
}
