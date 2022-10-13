package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utils.LogHelper;
import java.util.logging.Level;
import java.util.logging.Logger;
import db.BaseDB;

import static java.util.concurrent.TimeUnit.SECONDS;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/",
        glue = {"seleniumgluecode"},
        plugin = {"json:test/report/cucumber_report.json"},
        snippets = SnippetType.CAMELCASE
        ,tags = {"@browser"}
)

public class Testrunner {

    private static Process pr;
    private static final Logger LOGGER = LogHelper.getLogger(Testrunner.class);

    @BeforeClass()
    public static void setUp(){
        startLocalServer();
        LOGGER.log(Level.INFO, "Test execution begins...");

    }

    @AfterClass
    public static void teardown(){
        closeLocalServer();
        try {
            LOGGER.log(Level.INFO, "Generating report...");
            String[] cmd = {"cmd.exe", "/c", "npm run report"};
            Runtime.getRuntime().exec(cmd);
            LOGGER.log(Level.INFO, "Report successfully generated!");
        }catch (Exception ex){
            LOGGER.log(Level.WARNING, "The report could not be generated.");
            ex.printStackTrace();
        }
    }



    private static void startLocalServer() {
        if (System.getProperty("environment").equalsIgnoreCase("local")) {
            try {
                String[] initServer = {"cmd.exe", "/c", "cd C:\\Users\\sebastian.arrejin\\post-venta-movil && npm run start"};
                pr = Runtime.getRuntime().exec(initServer);
                LOGGER.log(Level.INFO, "Starting Local server... ");

                pr.wait(5000);
            } catch (Exception e) {
                LOGGER.log(Level.INFO, "Error starting local server..");
            }
        }
    }

    private static void closeLocalServer() {
        if (System.getProperty("environment").equalsIgnoreCase("local")) {
            try {
                String[] closeServer = {"cmd.exe", "/c", "taskkill /im node.exe /t /f\n"};
                pr = Runtime.getRuntime().exec(closeServer);
                pr.waitFor(5, SECONDS);
                LOGGER.log(Level.INFO, "Closing Local server... ");
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Error closing server... ");
            }
        }
    }


}
