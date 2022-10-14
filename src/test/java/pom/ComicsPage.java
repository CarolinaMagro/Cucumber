package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ComicsPage extends BasePage{

    @FindBy(className = "page-title")
    private WebElement titleLocator;


    private String titlePage=ambiente().titlePage();




    public ComicsPage(WebDriver driver){
        super(driver);
    }

    public boolean isTitleComicsDisplayed() throws Exception {
        return false;
        //return isDisplayed(titleLocator) && this.getText(titleLocator).equals(titlePage);
    }



}
