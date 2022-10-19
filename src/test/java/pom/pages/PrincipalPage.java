package pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pom.BasePage;

public class PrincipalPage extends BasePage {



        @FindBy(xpath = "//*[contains(text(), 'PGN')]")
        private WebElement titlePrincipalLocator;

        @FindBy(xpath = "//*[contains(text(), 'Cambio de NIM')]")
        private WebElement btnCambioDeNim;


        public PrincipalPage(WebDriver driver){
            super(driver);
        }

        public void clickOnCambioDeNim() throws Exception {
            this.click(btnCambioDeNim);
        }

        public boolean principalPageIsDisplayed() throws Exception {
            return isDisplayed(titlePrincipalLocator);
        }

        public void goToPrincipalPage(){
            getDriver().get(ambiente().urlPantallaPrincipal());
        }

    }
