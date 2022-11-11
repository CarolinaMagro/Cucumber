package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pom.BasePage;

public class CambioDeNimPage extends BasePage {

        private String titlePage=environment().titlePage();


        @FindBy(id="title-assign_nim")
        private WebElement titleCambioDeNimLocator;

        @FindBy(id = "button-save_nim")
        private WebElement btnGuardarNim;

        @FindBy(id = "input-current_number")
        private WebElement inputNumeroActual;

        @FindBy(id = "input-area_code")
        private WebElement inputCodigoArea;

        @FindBy(id = "input-block_code")
        private WebElement inputBloque;

        @FindBy(id = "checkbox-special_number")
        private WebElement checkBoxNroEspecial;

        @FindBy(id = "dropwdown-special_number")
        private WebElement comboNuevoNumeroLinea;

        @FindBy(id = "input-new_number")
        private WebElement inputNuevoNumeroLinea;

        @FindBy(id = "input-previous_number")
        private WebElement inputNumeroAnterior;

        @FindBy(id = "input-change_date")
        private WebElement inputFecha;

        @FindBy(id = "button-save_undonim")
        private WebElement btnDeshacerNim;

        @FindBy(id = "mensaje-de-confirmacion")
        private WebElement msjConfirmacion;



        @FindBy(id = "title-assign_nim")
        private WebElement titleAssingDeNim;
        @FindBy(id = "title-undo_nim")
        private WebElement titleUndoNim;

        @FindBy(id = "input-special_number")
        private WebElement inputNroEspecial;

        @FindBy(id = "")
        private WebElement dropdownNuevoNumeroLinea;
        @FindBy(id ="input-billing_number")
        private WebElement inputBillingNumber;
        @FindBy(id ="button-search")
        private WebElement buttonSearch;




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






        public String getInputBloque() throws Exception {

                return inputBloque.getText();
        }







        public boolean isTitleUndoCambioDeNimDisplayed() throws Exception {
                return isDisplayed(titleUndoNim);
        }

        public void setInputBillingNumber(String text) throws Exception {
                clearField(inputBillingNumber);
                setText(inputBillingNumber, text);
        }
        public void clickOnButtonSearch() throws Exception {
                this.click(buttonSearch);
        }



}
