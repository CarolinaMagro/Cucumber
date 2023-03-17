package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pom.BasePage;

public class HeaderPage extends BasePage {

        @FindBy(id ="input-billing_number")
        private WebElement inputBillingNumber;

        @FindBy(id ="button-search")
        private WebElement buttonSearch;

        @FindBy(xpath = "//*[@id='clientName']/p[2]")
        private WebElement clientName;



    public HeaderPage(WebDriver driver){
                super(driver);
        }


    public void setInputBillingNumber(String text) throws Exception {
        clearField(inputBillingNumber);
        setText(inputBillingNumber, text);
    }


    public String getClientName() throws Exception {
        return getText(clientName);
    }

    public void clickOnButtonSearch() throws Exception {
        this.click(buttonSearch);
    }


}
