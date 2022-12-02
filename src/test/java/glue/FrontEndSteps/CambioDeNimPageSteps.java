package glue.FrontEndSteps;




import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import glue.TestBase;
import org.junit.Assert;

import java.util.List;

import static junit.framework.TestCase.*;


public class CambioDeNimPageSteps extends TestBase {

    String nuevoNumeroLinea;




    @When("^Se setea el codigo de area con el numero (\\d+)$")
    public void seSeteaElCodigoDeAreaConElNumero(String codigoArea) throws Throwable {
        cambioDeNimPage.setInputCodigoArea(codigoArea);
        Thread.sleep(1000);
    }

    @Then("^Se debe actualizar el bloque con el numero A(\\d+)$")
    public void seDebeActualizarElBloqueConElNumeroA(String bloque) throws Throwable {
        assertEquals(bloque, cambioDeNimPage.getBloque());
    }




    //Caro
    @Given("^El usuario se encuentra en la pantalla Cambio de Nim$")
    public void elUsuarioSeEncuentraEnLaPantallaCambioDeNim() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        cambioDeNimPage.goToCambioDeNimPage();
        assertTrue(cambioDeNimPage.cambioDeNimPageIsDisplayed());

    }

    @Then("^Se completa el codigo de area$")
    public void CompletarCodigoDeArea(DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        //setea Campos
        for (int i = 1; i < 7; i++){
            // setea el codigo de area
            cambioDeNimPage.setInputCodigoArea(data.get(i).get(1));
            // valida los bloques
            assertEquals(data.get(i).get(2), cambioDeNimPage.getInputBloque());
            System.out.println("-----------------------");
            System.out.println(data.get(i).get(2));
            System.out.println( cambioDeNimPage.getInputBloque());
            System.out.println("-----------------------");
        }
    }



    @And("^Se hace click en el boton guardar nim$")
    public void seHaceClickEnElBotonGuardarNim() throws Throwable{
        cambioDeNimPage.clickOnGuardarNim();
    }

    @Then("^Se debe visualizar el mensaje de confirmacion$")
    public void seDebeVisualizarElMensajeDeConfirmacion() throws Throwable {
        assertTrue("No se visualizo el msj de confirmacion", cambioDeNimPage.isMsjConfirmacionDisplayed());
    }

    @When("^Se completa el (\\d+)$")
    public void seCompletaElCodigoDeArea(String codigoDeArea) throws Throwable {
        // setea el codigo de area
        cambioDeNimPage.setInputCodigoArea(codigoDeArea);
        // valida los bloques
        assertEquals(codigoDeArea, cambioDeNimPage.getInputBloque());
        System.out.println("-----------------------");
        System.out.println(codigoDeArea);
        System.out.println( cambioDeNimPage.getInputBloque());
        System.out.println("-----------------------");
    }



    @When("^Se utiliza el (\\d+)$")
    public void seUtilizaElNumero(String billingNumber) throws Exception {
        cambioDeNimPage.setInputBillingNumber(billingNumber);
        cambioDeNimPage.clickOnButtonSearch();

    }

    @Then("^Se debe visualizar cambio de NIM$")
    public void seDebeVisualizarCambioDeNIM() {

    }

    @Then("^Se debe visualizar deshacer cambio de NIM$")
    public void seDebeVisualizarDeshacerCambioDeNIM() {
    }

    @Then("^El campo AC(\\\\d+) debe actualizarse$")
    public void elCampoDebeActualizarseBloque(String bloque) throws Exception {
        assertEquals(cambioDeNimPage.getInputBloque(), bloque);


    }

}
