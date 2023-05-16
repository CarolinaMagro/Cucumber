package glue;


import junit.framework.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pom.pages.*;
import utils.LogHelper;


import java.util.logging.Logger;

public class TestBase {
    private static final Logger LOGGER = LogHelper.getLogger(Test.class);
    protected WebDriver driver = Hooks.getDriver();
    protected PrincipalPage principalPage = PageFactory.initElements(driver, PrincipalPage.class);
    protected LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

}
