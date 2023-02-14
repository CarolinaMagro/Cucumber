package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pom.BasePage;

import java.util.ArrayList;
import java.util.List;

public class CambioDeEstadoPage extends BasePage {

        @FindBy(id ="input-billing_number")
        private WebElement inputBillingNumber;

        @FindBy(id ="button-search")
        private WebElement buttonSearch;



        @FindBy(xpath="//[contains(text()='Activo')]")
        private WebElement estadoActual;

        @FindBy(xpath="//[contains(text()='RazonActual')]")
        private WebElement razonActual;



        @FindBy(xpath="//[contains(text()='Cancelado')]")
        private WebElement btnCancelado;

        @FindBy(xpath="//[contains(text()='Suspendido')]")
        private WebElement btnSuspendido;

        @FindBy(xpath="//[contains(text()='Activo')]")
        private WebElement btnActivo;

        @FindBy(xpath="//[contains(text()='RazonActual')]")
        private WebElement selectRazon;




        @FindBy(xpath="//[contains(text()='RazonActual')]")
        private WebElement btnGuardarCambio;


        @FindBy(xpath="//[contains(text()='RazonActual')]")
        private WebElement btnCancelarCambio;



        public CambioDeEstadoPage(WebDriver driver){
                super(driver);
        }




        public void setEstadoCancelado() throws Exception {
                btnCancelado.click();
        }

        public void setEstadoActivo() throws  Exception{
                btnActivo.click();
        }

        public void setEstadoSuspendido() throws Exception{
                btnSuspendido.click();
        }

        public String getEstadoActual()throws Exception{
             return   estadoActual.getText();
        }

        public String getRazonActual()throws Exception{
                return razonActual.getText();
        }

        public void setRazon(String razon) throws Exception{
                selectRazon.click();
                Thread.sleep(200);
                getDriver().findElement(By.xpath("//*[contains(text()='"+razon+"')]"));
        }



}
