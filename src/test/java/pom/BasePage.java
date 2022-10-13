package pom;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import seleniumgluecode.Hooks;
import utils.LogHelper;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BasePage {

    private WebDriver driver;
    private static Ambiente ambiente;
    private static final Logger LOGGER = LogHelper.getLogger(Hooks.class);

    public WebDriver getDriver() {
        return driver;
    }

    public Ambiente ambiente() {
        return this.ambiente;
    }


    public BasePage(WebDriver driver) {
        this.ambiente = ConfigFactory.create(Ambiente.class);
        this.driver = driver;
    }

    public void click(By element) throws Exception {
        try {
            driver.findElement(element).click();
        } catch (Exception e) {
            throw new Exception("Could not click on the button " + element);
        }
    }

    public void click(WebElement element) throws Exception {
        try {
            element.click();
        } catch (Exception e) {
            throw new Exception("Could not click on the button " + element);
        }
    }

    public boolean isDisplayed(By element) throws Exception {
        try {
            return driver.findElement(element).isDisplayed();
        } catch (Exception e) {
            String msj="The element " + element + " is not visible in the DOM";
            LOGGER.log(Level.INFO,msj);
        }
        return false;
    }

    public boolean isDisplayed(WebElement element){
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            String msj="The element " + element + " is not visible in the DOM";
            LOGGER.log(Level.INFO,msj);
        }
        return false;
    }


    public String getText(By element) throws Exception {
        try {
            return driver.findElement(element).getText();
        } catch (Exception e) {
            throw new Exception("Could not get the text of the following element: " + element);
        }

    }

    public String getText(WebElement element) throws Exception {
        try {
            return element.getText();
        } catch (Exception e) {
            throw new Exception("Could not get the text of the following element: " + element);
        }
    }

    public void setText(By element, String text) throws Exception {
        try {
            driver.findElement(element).sendKeys(text);
        } catch (Exception e) {
            throw new Exception("Could not set the text of the following element: " + element);
        }
    }

    public void setText(WebElement element, String text) throws Exception {
        try {
            element.sendKeys(text);
        } catch (Exception e) {
            throw new Exception("Could not set the text of the following element: " + element);
        }
    }


    public void clearField(By element) throws Exception {
        try {
            driver.findElement(element).clear();
        } catch (Exception e) {
            throw new Exception("Could not clear the text of the following element: " + element);
        }
    }

    public void clearField(WebElement element) throws Exception {
        try {
            element.clear();
        } catch (Exception e) {
            throw new Exception("Could not clear the text of the following element: " + element);
        }
    }



    public String getTitle() throws Exception {
        try {
            return driver.getTitle();
        }catch (Exception e){
            throw new Exception("Could not get the tab title");
        }

    }

    public WebElement getElementLocatorByText(String textOfElement) {
        WebElement element = null;
        try {
           element= driver.findElement(By.xpath("//*[contains(text(), '"+textOfElement+"')]"));
        } catch (Exception e) {
            String msj="Could not find the element with the following text: " + textOfElement;
            LOGGER.log(Level.INFO,msj);
        }
        return element;
    }



}
