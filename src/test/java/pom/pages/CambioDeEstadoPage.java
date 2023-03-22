package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pom.BasePage;


public class CambioDeEstadoPage extends BasePage {


        @FindBy(name = "currentState")
        private WebElement currentState;


        @FindBy(id = "input_input-sc")
        private WebElement currentReason;


        @FindBy(name = "cancel_button")
        private WebElement btnCancelado;

        @FindBy(name = "suspend_button")
        private WebElement btnSuspendido;

        @FindBy(name = "activate_button")
        private WebElement btnActivo;

        @FindBy(id = "dropdown_dropdown-sc")
        private WebElement selectRazon;


        @FindBy(id = "button_button-grabar")
        private WebElement btnGrabarCambio;


        @FindBy(id = "button_button-cancelar")
        private WebElement btnCancelarCambio;


        public CambioDeEstadoPage(WebDriver driver) {
                super(driver);
        }


        public void setEstadoCancelado() throws Exception {
                waitForEnable(btnCancelado);
                click(btnCancelado);

        }

        public void setEstadoActivo() throws Exception {
                waitForEnable(btnActivo);
                click(btnActivo);
        }

        public void setEstadoSuspendido() throws Exception {
                waitForEnable(btnSuspendido);
                click(btnSuspendido);
        }

        public String getCurrentState() throws Exception {
                return getValue(currentState);
        }

        public String getCurrentReason() throws Exception {
                return getValue(currentReason);
        }

        public void setRazon(String razon) throws Exception {
                waitForEnable(selectRazon);
                Thread.sleep(500);
                click(selectRazon);
                waitPresenceOfElement(By.xpath("//*[contains(text(),'" + razon + "')]"));
                click(getDriver().findElement(By.xpath("//*[contains(text(),'" + razon + "')]")));
                Thread.sleep(500);
        }

        public void goToCambioDeEstadoPage() {
                getDriver().get(environment().urlCambioEstado());

        }

        public boolean cambioDeEstadoPageIsDisplayed() throws Exception {
                int time = 0;
                while (!currentState.isDisplayed() && time < 20) {
                        Thread.sleep(250);
                        time += 0.25;
                }
                return currentState.isDisplayed();
        }

        public void clickBtnGrabarCambio() throws Exception {
                click(btnGrabarCambio);
        }

        public boolean isNewStateEnabled(String newState) throws Exception {
                waitForEnable(selectRazon);
                switch (newState.toUpperCase()) {
                        case "ACTIVA":
                                return btnActivo.isEnabled();
                        case "SUSPENDIDA":
                                return btnSuspendido.isEnabled();
                        case "CANCELADA":
                                return btnCancelado.isEnabled();
                        default:
                                System.out.println("Opciones validas ACTIVA, CANCELADA o SUSPENDIDA. Opcion ingresada: " + newState);
                                return false;

                }
        }

        public boolean isCurrentStateContainingNewString(String newState) throws Exception {
                waitForValue(currentState, newState);
                if (getValue(currentState).toUpperCase().contains(newState.toUpperCase())) {
                        return true;
                } else {
                        return false;
                }
        }

        public boolean isCurrentReasonContainingNewString(String newReason) throws Exception {
                waitForValue(currentReason, newReason);
                if (getValue(currentReason).toUpperCase().contains(newReason.toUpperCase())) {
                        return true;
                } else {
                        return false;
                }
        }

        public boolean isMsgDisplayed(String msg) throws Exception {
                waitPresenceOfElement(By.xpath("//*[contains(text(),'" + msg + "')]"));
                if (getDriver().findElement(By.xpath("//*[contains(text(),'" + msg + "')]")).isDisplayed()) {
                        return true;
                } else {
                        return false;
                }

        }
}

