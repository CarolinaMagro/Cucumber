package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.BasePage;

import java.util.ArrayList;
import java.util.List;

public class CambioDeEstadoPage extends BasePage {



        @FindBy(xpath="//*[@name='currentState']/p[2]")
        private WebElement currentState;




        @FindBy(id="input_input-sc")
        private WebElement razonActual;



        @FindBy(name="cancel_button")
        private WebElement btnCancelado;

        @FindBy(name="suspend_button")
        private WebElement btnSuspendido;

        @FindBy(name="activate_button")
        private WebElement btnActivo;

        @FindBy(id = "dropdown_dropdown-sc")
        private WebElement selectRazon;




        @FindBy(id="button_button-grabar")
        private WebElement btnGrabarCambio;


        @FindBy(id="button_button-cancelar")
        private WebElement btnCancelarCambio;



        public CambioDeEstadoPage(WebDriver driver){
                super(driver);
        }




        public void setEstadoCancelado() throws Exception {
                waitForEnable(btnCancelado);
                click(btnCancelado);

        }

        public void setEstadoActivo() throws  Exception{
                waitForEnable(btnActivo);
                click(btnActivo);
        }

        public void setEstadoSuspendido() throws Exception{
                waitForEnable(btnSuspendido);
                click(btnSuspendido);
        }

        public String getCurrentState()throws Exception{
             return   getText(currentState);
        }

        public String getRazonActual()throws Exception{
                return getValue(razonActual);
        }

        public void setRazon(String razon) throws Exception {
                waitForEnable(selectRazon);
                click(selectRazon);
                waitPresenceOfElement(By.xpath("//*[contains(text(),'" + razon + "')]"));
                click(getDriver().findElement(By.xpath("//*[contains(text(),'" + razon + "')]")));
        }

        public void goToCambioDeEstadoPage(){
                getDriver().get(environment().urlCambioEstado());
        }

        public boolean cambioDeEstadoPageIsDisplayed() throws InterruptedException {
                int time = 0;
                while (!currentState.isDisplayed() && time < 20) {
                        Thread.sleep(250);
                        time += 0.25;
                }
                return  currentState.isDisplayed();
        }

         public void clickBtnGrabarCambio() throws Exception {
                click(btnGrabarCambio);
         }

         public boolean isNewStateEnabled(String newState) throws InterruptedException {
                 waitPresenceOfElement(selectRazon);
                 switch (newState.toUpperCase()) {
                         case "ACTIVA" :
                               return  btnActivo.isEnabled();
                         case "SUSPENDIDA":
                                 return btnSuspendido.isEnabled();
                         case "CANCELADA":
                                 return btnCancelado.isEnabled();
                         default:
                                 System.out.println("Opciones validas ACTIVA, CANCELADA o SUSPENDIDA. Opcion ingresada: "+newState);
                                 return false;

                 }
         }
}

