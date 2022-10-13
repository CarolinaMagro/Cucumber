package seleniumgluecode;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import db.MongoDBHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import runner.browser_manager.DriverManager;
import runner.browser_manager.DriverManagerFactory;
import utilities.RestAssuredExtension;
import utils.LogHelper;

import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.concurrent.TimeUnit.SECONDS;


public class Hooks {

    private static final Logger LOGGER = LogHelper.getLogger(Hooks.class);


    private static WebDriver driver;
    private DriverManager driverManager;
    private Process pr;


    @Before("@browser")
    public void setUp()  {

        startLocalServer();
        LOGGER.log(Level.INFO, "Iniciando ambiente: "+System.getProperty("ambiente"));
        LOGGER.log(Level.INFO, "Ejecutando setUp..");

        driverManager = DriverManagerFactory.getManager(System.getProperty("browser"));
        driver = driverManager.getDriver();
        driver.get("about:blank");


        driver.manage().window().maximize();
    }

    @Before("@backend")
    public void connectToMongoServer() throws IOException {
        new MongoDBHelper();
        MongoDBHelper.connectToServer();
    }

    @Before("@rest")
    public void RestSetUp(){
        RestAssuredExtension restAssuredExtension = new RestAssuredExtension();
    }


    @After("@browser")
    public void tearDown(Scenario scenario) {


        if(scenario.isFailed()){
            byte[] screenshot= ((TakesScreenshot)driverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot,"image/png");
        }

        driverManager.quitDriver();
        LOGGER.log(Level.INFO, "Cerrando WebDriver");
        closeLocalServer();
        this.pr.destroyForcibly();
    }

    public static WebDriver getDriver(){

        return driver;
    }

    public void startLocalServer() {
        if (System.getProperty("ambiente").equalsIgnoreCase("local")) {
            try {
                String[] initServer = {"cmd.exe", "/c", "cd C:\\Users\\sebastian.arrejin\\post-venta-movil && npm run start"};
                this.pr = Runtime.getRuntime().exec(initServer);
                LOGGER.log(Level.INFO, "Starting Local server... ");

                this.pr.wait(5000);
            } catch (Exception e) {
                LOGGER.log(Level.INFO, "Error starting local server..");
            }
        }
    }

    public void closeLocalServer() {
        if (System.getProperty("ambiente").equalsIgnoreCase("local")) {
            try {
                String[] closeServer = {"cmd.exe", "/c", "taskkill /im node.exe /t /f\n"};
                this.pr = Runtime.getRuntime().exec(closeServer);
                this.pr.waitFor(5, SECONDS);
                LOGGER.log(Level.INFO, "Closing Local server... ");
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Error closing server... ");
            }
        }
    }

}
