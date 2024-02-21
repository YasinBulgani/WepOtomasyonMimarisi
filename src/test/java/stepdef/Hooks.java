package stepdef;

import com.qa.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

public class Hooks {

    private final DriverManager driverManager = new DriverManager();

    @Before
    public void initialize() throws Exception {
        driverManager.initializeDriver();
    }

    @After
    public void quit(Scenario scenario) throws IOException {
        try {
            if (scenario.isFailed()) {
                // Senaryo başarısızsa ekran görüntüsü al
                TakesScreenshot ts = (TakesScreenshot) driverManager.getDriver();
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            }

            // İsteğe bağlı olarak başarısız senaryo durumunu logla
            if (scenario.isFailed()) {
                System.out.println("Senaryo başarısız: " + scenario.getName());
            }
        } finally {
            // WebDriver'ı kapat
            driverManager.quitDriver();
        }
    }
}
