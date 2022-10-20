package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utils.LogHelper;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.concurrent.TimeUnit.SECONDS;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/",
        glue = {"glue"},
        plugin = {"json:test/report/cucumber_report.json"},
        snippets = SnippetType.CAMELCASE
        ,tags = {"@rest,@browser"}
)

public class Testrunner {

    private static Process pr1;
    private static Process pr2;
    private static final Logger LOGGER = LogHelper.getLogger(Testrunner.class);

    @BeforeClass()
    public static void setUp(){
        //startLocalServer();
        LOGGER.log(Level.INFO, "Test browser execution begins...");
        LOGGER.log(Level.INFO, "Starting environment: "+System.getProperty("environment"));
        }




    @AfterClass
    public static void teardown(){
        //closeLocalServer();
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
                String[] initAppServer = {"cmd.exe", "/c", "cd C:\\Users\\sebastian.arrejin\\post-venta-movil && npm run start"};
                pr1 = Runtime.getRuntime().exec(initAppServer);


                String[] initJsonServer = {"cmd.exe", "/c", "cd C:\\json && npm run start-auth"};
                pr2 = Runtime.getRuntime().exec(initJsonServer);


                LOGGER.log(Level.INFO, "Starting Local server... ");
                Thread.sleep(4000);
            } catch (Exception e) {
                LOGGER.log(Level.INFO, "Error starting local server..");
            }
        }
    }

    private static void closeLocalServer() {
        if (System.getProperty("environment").equalsIgnoreCase("local")) {
            try {
                String[] closeServer = {"cmd.exe", "/c", "taskkill /im node.exe /t /f\n"};
                //pr1 = Runtime.getRuntime().exec(closeServer);
                LOGGER.log(Level.INFO, "Closing Local server... ");
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Error closing server... ");
            }
        }
    }


}
