package runners;

import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.logging.log4j.ThreadContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"
                , "html:target/cucumber/report.html"
                , "summary"
//                , "me.jvt.cucumber.report.PrettyReports:target/Pixel3/cucumber-html-reports"
        }
        ,features = {"src/test/resources"}
        ,glue = {"com.qa.java.stepdef"}
        ,snippets = CAMELCASE
        ,dryRun=false
        ,monochrome=true
       ,tags = "@test"

)


public class MyRunnerTest {

    @BeforeClass
    public static void initialize() throws Exception {
        GlobalParams params = new GlobalParams();
        params.initializeGlobalParams();

        ThreadContext.put("ROUTINGKEY", params.getPlatformName() + "_"
                + params.getDeviceName());

        new DriverManager().initializeDriver();

    }

    @AfterClass
    public static void quit(){
        DriverManager driverManager = new DriverManager();
        DriverManager.quitDriver();



        }

    }

