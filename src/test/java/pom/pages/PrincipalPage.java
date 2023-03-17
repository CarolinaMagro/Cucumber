package pom.pages;

import pom.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PrincipalPage extends BasePage {

        @FindBy(id="div-change_nim")
        private WebElement btnCambioDeNim;

        @FindBy(id="div-status")
        private WebElement btnEstados;

        @FindBy(id="div-packages")
        private WebElement btnPaquetes;

        @FindBy(id="div-_content")
        private WebElement divContent;



        public PrincipalPage(WebDriver driver){
            super(driver);
        }

        public void clickOnCambioDeNim() throws Exception {
            this.click(btnCambioDeNim);
        }

        public boolean principalPageIsDisplayed() throws Exception {
            return isDisplayed(divContent);
        }



    public void goToPrincipalPage(){
            getDriver().get(environment().urlPantallaPrincipal());
        }

    }
