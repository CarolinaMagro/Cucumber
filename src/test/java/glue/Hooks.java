package glue;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import runner.browser_manager.DriverManager;
import runner.browser_manager.DriverManagerFactory;
import utils.LogHelper;


import java.io.IOException;

import java.util.logging.Logger;


public class Hooks {

    private static final Logger LOGGER = LogHelper.getLogger(Hooks.class);
    private static WebDriver driver;
    private DriverManager driverManager;


    @Before("@baufest")
    public void setUp()  {
        driverManager = DriverManagerFactory.getManager(System.getProperty("browser"));
        driver = driverManager.getDriver();
        driver.get("about:blank");
        driver.manage().window().maximize();

    }
    @After("@baufest")
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()){
            byte[] screenshot= ((TakesScreenshot)driverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot,"image/png");
        }
        driverManager.quitDriver();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
