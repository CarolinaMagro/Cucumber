package pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pom.BasePage;

public class LoginPage extends BasePage {

        @FindBy(id = "username")
        private WebElement user;

        @FindBy(id = "password")
        private WebElement pass;

        @FindBy(id = "kc-login")
        private WebElement btnIngresar;


        public LoginPage(WebDriver driver){
                super(driver);
        }


        public void setUser(String text) throws Exception {
                clearField(user);
                setText(user, text);
        }

        public void setPass(String text) throws Exception {
                clearField(pass);
                setText(pass, text);
        }


        public void login() throws Exception {
                if (environment().user_login().isEmpty()) {
                        setUser(System.getProperty("user_login"));
                        setPass(System.getProperty("pass_login"));
                }else {
                        setUser(environment().user_login());
                        setPass(environment().pass_login());
                }

                click(btnIngresar);
        }


        public boolean isOnLoginPage() throws Exception {
                return getTitle().contains("Iniciar sesión en Claro");
        }

        public void goToLoginPage(){
                getDriver().get(environment().urlPantallaPrincipal());
        }


}
