package glue.FrontEndSteps;


import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import glue.TestBase;
import org.junit.Assert;

import java.util.List;

public class CambioDeNimPageTest extends TestBase {

    @Given("^El usuario se encuentra en la pantalla Cambio de Nim$")
    public void elUsuarioSeEncuentraEnLaPantallaCambioDeNim() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        cambioDeNimPage.goToCambioDeNimPage();
        Assert.assertTrue(cambioDeNimPage.cambioDeNimPageIsDisplayed());

    }

    @When("^Se completan los campos$")
    public void seCompletanLosCampos(DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        //setea Campos

        //Thread.sleep(500);
        //cambioDeNimPage.setInputNumeroActual(data.get(1).get(0));
        Thread.sleep(500);
        cambioDeNimPage.setInputCodigoArea(data.get(1).get(1));
        //Thread.sleep(500);
        //cambioDeNimPage.setInputBloque(data.get(1).get(2));
        Thread.sleep(500);
        cambioDeNimPage.selectOptionCombo(data.get(1).get(3));
        Thread.sleep(500);

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

}
