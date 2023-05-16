package pom.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pom.BasePage;

public class LoginPage extends BasePage {

        @FindBy(id = "loginusername")
        private WebElement UserName;

        @FindBy(id = "loginpassword")
        private WebElement Password;

        @FindBy(xpath ="//button[@type='button' and @onclick='logIn()']")
        private WebElement LogInButton;


        public LoginPage(WebDriver driver){
                super(driver);
        }

        public void clickLogin() throws Exception {
                this.click(LogInButton);
                Thread.sleep(5000);
        }

        public void setUser() throws Exception {

                setText(UserName, environment().user_login());
        }

        public void setPass() throws Exception {

                setText(Password, environment().pass_login());
        }

               public void goToIndexPage(){
                getDriver().get(environment().urlPantallaPrincipal());
        }


}
