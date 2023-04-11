
package glue.FrontEndSteps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import glue.TestBase;
import org.junit.Assert;
import pom.pages.packagesObjets.*;

import java.util.ArrayList;
import java.util.List;


public class PaquetesPageSteps extends TestBase {


  //  @And("^El usuario se encuentra en la pantalla Cambio de estado$")
  //  public void elUsuarioSeEncuentraEnLaPantallaCambioDeEstado() throws Throwable {
  //          //paquetesPage.goToCambioDeEstadoPage();
  //  }
//
  //  @And("^Se selecciona la razon \"([^\"]*)\"$")
  //  public void seSeleccionaLaRazon(String razon) throws Throwable {
//
  //      paquetesPage.setRazon(razon);
//
  //  }
//
  //  @When("^Se hace click en el boton guardar cambio de estado$")
  //  public void seHaceClickEnElBotonGuardarCambioDeEstado() throws Exception {
  //      cambioDeEstadoPage.clickBtnGrabarCambio();
  //  }
//
//
  //  @And("^clickear en la opcion \"([^\"]*)\"$")
  //  public void clickearEnLaOpcion(String opcion) throws Throwable {
//
  //      switch (opcion.toUpperCase()) {
  //          case "ACTIVA":
  //              cambioDeEstadoPage.setEstadoActivo();
  //              break;
  //          case "SUSPENDIDA":
  //              cambioDeEstadoPage.setEstadoSuspendido();
  //              break;
  //          case "CANCELADA":
  //              cambioDeEstadoPage.setEstadoCancelado();
  //              break;
  //          default:
  //              System.out.println("Opciones validas ACTIVA, CANCELADA o SUSPENDIDA. Opcion ingresada: "+opcion);
  //      }
//
  //  }
//
//
  //  @And("^No se encuentra disponible el estado \"([^\"]*)\"$")
  //  public void noSeEncuentraDisponibleElEstado(String option) throws Throwable {
  //      Assert.assertTrue("El estado ("+option+") no deberia estar disponible",!cambioDeEstadoPage.isNewStateEnabled(option));
  //  }
//
  //  @And("^Se encuentra disponible el estado \"([^\"]*)\"$")
  //  public void seEncuentraDisponibleElEstado(String option) throws Throwable {
  //      Assert.assertTrue("El estado ("+option+") deberia estar disponible", cambioDeEstadoPage.isNewStateEnabled(option));
  //  }
//
  //  @Then("^Se actualiza el estado actual a \"([^\"]*)\"$")
  //  public void seActualizaElEstadoActualA(String newState) throws Throwable {
  //      Assert.assertTrue("Expected ("+newState+"), but found ("+cambioDeEstadoPage.getCurrentState()+")",
  //              cambioDeEstadoPage.isCurrentStateContainingNewString(newState));
  //  }
//
//
  //  @Then("^Se actualiza la razon actual a \"([^\"]*)\"$")
  //  public void seActualizaLaRazonActualA(String newReason) throws Throwable {
  //      Assert.assertTrue("Expected: ("+newReason+"), but found: ("+cambioDeEstadoPage.getCurrentReason()+")",
  //              cambioDeEstadoPage.isCurrentReasonContainingNewString(newReason));
  //  }
//
//
  //  @Then("^Se debe visualzar un mensaje de \"([^\"]*)\"$")
  //  public void seDebeVisualzarUnMensajeDe(String msg) throws Throwable {
  //      // Write code here that turns the phrase above into concrete actions
  //      Assert.assertTrue("No se visualiza el mensaje ("+msg+")",cambioDeEstadoPage.isMsgDisplayed(msg));
  //  }

    @Given("^quiero hacer un test$")
    public void quieroHacerUnTest() throws Exception {
        List<Vigentes> CurrentTable = new ArrayList<Vigentes>();
        CurrentTable = paquetesPage.GetCurrents();
        List<Servicios> ServicesTable = new ArrayList<Servicios>();
        ServicesTable = paquetesPage.GetServices();
        List<Comportamientos> BehaviorTable = new ArrayList<Comportamientos>();
        BehaviorTable = paquetesPage.GetBehavior();
        List<ComportamientosHistorico> BehaviorHistoricTable = new ArrayList<ComportamientosHistorico>();
        BehaviorHistoricTable = paquetesPage.GetBehaviorHistoric();
        List<Tickler> TicklerTable = new ArrayList<Tickler>();
        TicklerTable = paquetesPage.GetTickler();
        List<Historico> HistoricTable = new ArrayList<Historico>();
        HistoricTable = paquetesPage.GetHistoric();
        Object row = paquetesPage.SearchRow("COILIX", CurrentTable );
        Historico rowHistoric= (Historico) paquetesPage.SearchRow("COILIX", HistoricTable );
        paquetesPage.goToPaquetesPageTiclkerTab();
        paquetesPage.goToPaquetesPageBehaviorTab();
        paquetesPage.goToPaquetesPageServicesTab();
    }

    @When("^asdfasd$")
    public void asdfasd() {
        
    }

    @Then("^dfgdsf$")
    public void dfgdsf() {
    }

    @And("^El usuario se encuentra en la pantalla Paquetes$")
    public void elUsuarioSeEncuentraEnLaPantallaPaquetes() throws Throwable {
        paquetesPage.goToPaquetesPage();
    }
}
