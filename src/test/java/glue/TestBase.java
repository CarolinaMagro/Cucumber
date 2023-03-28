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
    protected CambioDeNimPage cambioDeNimPage = PageFactory.initElements(driver, CambioDeNimPage.class);
    protected PrincipalPage principalPage = PageFactory.initElements(driver, PrincipalPage.class);
    protected LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    protected CambioDeEstadoPage cambioDeEstadoPage = PageFactory.initElements(driver, CambioDeEstadoPage.class);
    protected HeaderPage headerPage = PageFactory.initElements(driver, HeaderPage.class);
    protected PaquetesPage paquetesPage = PageFactory.initElements(driver, PaquetesPage.class);

}
