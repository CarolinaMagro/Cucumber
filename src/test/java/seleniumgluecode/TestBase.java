package seleniumgluecode;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pom.ComicsPage;
import pom.HomePage;
import utils.LogHelper;

import java.util.logging.Logger;

public class TestBase {
    private static final Logger LOGGER = LogHelper.getLogger(Test.class);
    protected WebDriver driver = Hooks.getDriver();
    protected HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    protected ComicsPage comicsPage = PageFactory.initElements(driver, ComicsPage.class);

}
