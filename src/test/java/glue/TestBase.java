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
    protected SingUpPage singUpPage = PageFactory.initElements(driver, SingUpPage.class);
    protected IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
    protected LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    protected CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
    protected ItemPage itemPage = PageFactory.initElements(driver, ItemPage.class);

}
