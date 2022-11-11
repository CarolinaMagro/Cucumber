package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pom.BasePage;

public class CambioDeNimPage extends BasePage {

        private String titlePage=environment().titlePage();


        @FindBy(xpath = "//*[contains(text(), 'Asignar Nuevo NIM')]")
        private WebElement titleCambioDeNimLocator;

        @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[2]/div/div[3]/div/form/div[3]/button")
        private WebElement btnGuardarNim;

        @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[2]/div/div[3]/div/form/div[1]/div[1]/input")
        private WebElement inputNumeroActual;

        @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[2]/div/div[3]/div/form/div[1]/div[2]/input")
        private WebElement inputCodigoArea;

        @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[2]/div/div[3]/div/form/div[1]/div[3]/input")
        private WebElement inputBloque;

        @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[2]/div/div[3]/div/form/div[2]/div[1]/div[1]/input")
        private WebElement checkBoxNroEspecial;

        @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[2]/div/div[3]/div/form/div[2]/div[1]/div[1]/input")
        private WebElement comboNuevoNumeroLinea;

        @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[2]/div/div[3]/div/form/div[2]/div[2]/input")
        private WebElement inputNuevoNumeroLinea;

        @FindBy(xpath = "/html/body/div/div[2]/div[2]/div/div[4]/div/form/div[1]/div[1]/input\n")
        private WebElement inputNumeroAnterior;

        @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[2]/div/div[4]/div/form/div[1]/div[2]/input")
        private WebElement inputFecha;

        @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[2]/div/div[4]/div/form/div[2]/button")
        private WebElement btnDeshacerNim;

        @FindBy(id = "mensaje-de-confirmacion")
        private WebElement msjConfirmacion;





        public CambioDeNimPage(WebDriver driver){
                super(driver);
        }




        public void setInputNumeroActual(String text) throws Exception {
                clearField(inputNumeroActual);
            setText(inputNumeroActual, text);
        }

        public void setInputCodigoArea(String text) throws Exception {
                clearField(inputCodigoArea);
                setText(inputCodigoArea, text);
        }

        public void setInputBloque(String text) throws Exception {
                clearField(inputBloque);
                setText(inputBloque, text);
        }



        public void selectOptionCombo(String option) throws Exception {
                WebElement optionCombo=getElementLocatorByText(option);
                click(comboNuevoNumeroLinea);
                Thread.sleep(3000);//WebElement optionCombo =getDriver().findElement(By.xpath("//*[text()[contains(.,'"+option+"')]]"));

        }


        public void clickOnGuardarNim() throws Exception {
            this.click(btnGuardarNim);

        }



        public boolean cambioDeNimPageIsDisplayed() throws Exception {
            return isDisplayed(titleCambioDeNimLocator);
        }

        public void goToCambioDeNimPage(){
            getDriver().get(environment().urlCambioNim());
        }


        public boolean isTitleCambioDeNimDisplayed() throws Exception {
                return isDisplayed(titleCambioDeNimLocator);
        }

        public boolean isMsjConfirmacionDisplayed() throws Exception {
                return getText(inputNuevoNumeroLinea).equalsIgnoreCase("asdf")&& getTitle().equalsIgnoreCase("asdfasdf");
        }


        public String getBloque() throws Exception {
              return getText(inputBloque);
        }

    }
