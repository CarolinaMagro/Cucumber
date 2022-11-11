package glue.FrontEndSteps;


import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import glue.TestBase;
import org.junit.Assert;

import java.util.List;

public class CambioDeNimPageSteps extends TestBase {

    @Given("^El usuario se encuentra en la pantalla Cambio de Nim$")
    public void elUsuarioSeEncuentraEnLaPantallaCambioDeNim() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        cambioDeNimPage.goToCambioDeNimPage();
        Assert.assertTrue(cambioDeNimPage.cambioDeNimPageIsDisplayed());

    }



    @And("^Se hace click en el boton guardar nim$")
    public void seHaceClickEnElBotonGuardarNim() throws Throwable{
        cambioDeNimPage.clickOnGuardarNim();
        Thread.sleep(2000);
    }

    @Then("^Se debe visualizar el mensaje de confirmacion$")
    public void seDebeVisualizarElMensajeDeConfirmacion() throws Throwable {
        Assert.assertTrue("No se visualizo el msj de confirmacion", cambioDeNimPage.isMsjConfirmacionDisplayed());
    }

    @When("^Se setea el codigo de area con el numero (\\d+)$")
    public void seSeteaElCodigoDeAreaConElNumero(String codigoArea) throws Throwable {
        cambioDeNimPage.setInputCodigoArea(codigoArea);
        Thread.sleep(1000);
    }



    @Then("^Se debe actualizar el bloque con el numero A(\\d+)$")
    public void seDebeActualizarElBloqueConElNumeroA(String bloque) throws Throwable {
        Assert.assertTrue(cambioDeNimPage.getBloque().equalsIgnoreCase(bloque));
    }


}
