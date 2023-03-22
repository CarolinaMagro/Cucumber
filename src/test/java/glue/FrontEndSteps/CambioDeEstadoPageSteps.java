
package glue.FrontEndSteps;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import glue.TestBase;
import org.junit.Assert;


public class CambioDeEstadoPageSteps extends TestBase {


    @And("^El usuario se encuentra en la pantalla Cambio de estado$")
    public void elUsuarioSeEncuentraEnLaPantallaCambioDeEstado() throws Throwable {
            cambioDeEstadoPage.goToCambioDeEstadoPage();
    }

    @And("^Se selecciona la razon \"([^\"]*)\"$")
    public void seSeleccionaLaRazon(String razon) throws Throwable {

        cambioDeEstadoPage.setRazon(razon);

    }

    @When("^Se hace click en el boton guardar cambio de estado$")
    public void seHaceClickEnElBotonGuardarCambioDeEstado() throws Exception {
        cambioDeEstadoPage.clickBtnGrabarCambio();
    }


    @And("^clickear en la opcion \"([^\"]*)\"$")
    public void clickearEnLaOpcion(String opcion) throws Throwable {

        switch (opcion.toUpperCase()) {
            case "ACTIVA":
                cambioDeEstadoPage.setEstadoActivo();
                break;
            case "SUSPENDIDA":
                cambioDeEstadoPage.setEstadoSuspendido();
                break;
            case "CANCELADA":
                cambioDeEstadoPage.setEstadoCancelado();
                break;
            default:
                System.out.println("Opciones validas ACTIVA, CANCELADA o SUSPENDIDA. Opcion ingresada: "+opcion);
        }

    }


    @And("^No se encuentra disponible el estado \"([^\"]*)\"$")
    public void noSeEncuentraDisponibleElEstado(String option) throws Throwable {
        Assert.assertTrue("El estado ("+option+") no deberia estar disponible",!cambioDeEstadoPage.isNewStateEnabled(option));
    }

    @And("^Se encuentra disponible el estado \"([^\"]*)\"$")
    public void seEncuentraDisponibleElEstado(String option) throws Throwable {
        Assert.assertTrue("El estado ("+option+") deberia estar disponible", cambioDeEstadoPage.isNewStateEnabled(option));
    }

    @Then("^Se actualiza el estado actual a \"([^\"]*)\"$")
    public void seActualizaElEstadoActualA(String newState) throws Throwable {
        Assert.assertTrue("Expected ("+newState+"), but found ("+cambioDeEstadoPage.getCurrentState()+")",
                cambioDeEstadoPage.isCurrentStateContainingNewString(newState));
    }


    @Then("^Se actualiza la razon actual a \"([^\"]*)\"$")
    public void seActualizaLaRazonActualA(String newReason) throws Throwable {
        Assert.assertTrue("Expected: ("+newReason+"), but found: ("+cambioDeEstadoPage.getCurrentReason()+")",
                cambioDeEstadoPage.isCurrentReasonContainingNewString(newReason));
    }


    @Then("^Se debe visualzar un mensaje de \"([^\"]*)\"$")
    public void seDebeVisualzarUnMensajeDe(String msg) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("No se visualiza el mensaje ("+msg+")",cambioDeEstadoPage.isMsgDisplayed(msg));
    }
}
