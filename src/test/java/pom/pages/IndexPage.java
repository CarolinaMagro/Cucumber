package pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pom.BasePage;

import java.util.List;

public class IndexPage extends BasePage {

        @FindBy(id = "signin2")
        private WebElement SignIn;

        @FindBy(id = "login2")
        private WebElement LogIn;

        @FindBy(id = "cartur")
        private WebElement Cart;

        @FindBy(id = "logout2")
        private WebElement LogOut;

        @FindBy(id = "nameofuser")
        private WebElement Welcome;

        @FindBy(className = "hrefch")
        private List<WebElement> Items;

        public IndexPage(WebDriver driver){
                super(driver);
        }

        public boolean IsDisplayedIndex(){
                return LogIn.isDisplayed();
        }
        public void ClickSignIn() throws Exception{
            click(SignIn);
        }
        public void ClickCart() throws Exception{
                click(Cart);
        }
        public void ClickLogIn() throws Exception{
            click(LogIn);
        }
        public void ClickLogOut() throws Exception{
                click(LogOut);
        }
        public String GetWelcomeText() throws Exception{
                String name = Welcome.getText();
                return name;
        }
        public String GetLogInText() throws Exception{
                String name = LogIn.getText();
                return name;
        }
        public String clickItem() throws Exception {
                String item = Items.get(0).getText();
                this.click(Items.get(0));
                Thread.sleep(5000);
                return item;
        }
        public void goToIndexPage(){
                getDriver().get(environment().urlPantallaPrincipal());
        }


}
