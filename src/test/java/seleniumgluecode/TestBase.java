package seleniumgluecode;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pom.CambioDeNimPage;
import pom.ComicsPage;
import pom.HomePage;
import pom.PrincipalPage;
import utils.LogHelper;

import java.util.logging.Logger;

public class TestBase {
    private static final Logger LOGGER = LogHelper.getLogger(Test.class);
    protected WebDriver driver = Hooks.getDriver();
    protected CambioDeNimPage cambioDeNimPage = PageFactory.initElements(driver, CambioDeNimPage.class);
    protected PrincipalPage principalPage = PageFactory.initElements(driver, PrincipalPage.class);
    protected HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    protected ComicsPage comicsPage = PageFactory.initElements(driver, ComicsPage.class);

}
