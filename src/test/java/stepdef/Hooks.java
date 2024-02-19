
package stepdef;

import com.qa.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class Hooks {

    @Before
    public void initialize() throws Exception {
        new DriverManager().initializeDriver();
    }

    @After
    public void quit(Scenario scenario) throws IOException {



    }



}
