
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
    public void elUsuarioSeEncuentraEnLaPantallaCambioDeEstado() throws InterruptedException {
            cambioDeEstadoPage.goToCambioDeEstadoPage();
    }

    @And("^Se selecciona la razon \"([^\"]*)\"$")
    public void seSeleccionaLaRazon(String razon) throws Throwable {
        cambioDeEstadoPage.setRazon(razon);
    }

    @When("^Se hace click en el boton guardar cambio de estado$")
    public void seHaceClickEnElBotonGuardarCambioDeEstado() {

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
}
