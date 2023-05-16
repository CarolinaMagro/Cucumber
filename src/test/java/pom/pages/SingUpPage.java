package pom.pages;

import org.openqa.selenium.Alert;
import pom.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SingUpPage extends BasePage {
    //Web Elements Locators
    @FindBy(id = "sign-username")
    private WebElement userNameText;

    @FindBy(id = "sign-password")
    private WebElement passwordText;
   //By signUpButton = By.cssSelector("[type='button'][onclick='register()']");
    @FindBy(xpath ="//button[@type='button' and @onclick='register()']")
    private WebElement signUpButton;




    public SingUpPage(WebDriver driver) {
        super(driver);
    }

    public void clickSingUp() throws Exception {
        this.click(signUpButton);
        Thread.sleep(5000);
    }
    public boolean IsDisplayedSignUp(){
        return signUpButton.isDisplayed();
    }
    public void SetUsrName(String name)throws Exception{
        Thread.sleep(5000);
        setText(userNameText, name);
    }
    public void SetUsrPass(String pass)throws Exception{
        clearField(passwordText);
        setText(passwordText, pass);
    }
    public boolean AceptModal(){
        Alert alert = getDriver().switchTo().alert();
        String message= alert.getText();
        alert.accept();
        return true;
    }
}

