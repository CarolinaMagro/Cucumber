package runner.browser_manager;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

public class DriverManagerFactory {

    public static DriverManager getManager(String driver){

        DriverManager driverManager = null;

        switch (driver.toLowerCase()){
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
                default:
                    System.out.println("Invalid browser selected");
                    break;
        }

        return driverManager;

    }

}
