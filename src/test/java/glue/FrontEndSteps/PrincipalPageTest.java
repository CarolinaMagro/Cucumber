package glue.FrontEndSteps;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import glue.TestBase;
import org.junit.Assert;

public class PrincipalPageTest extends TestBase {


    @Given("^El usuario se encuentra en la pantalla principal$")
    public void elUsuarioSeEncuentraEnLaPantallaPrincipal() throws Throwable {
        principalPage.goToPrincipalPage();
        Assert.assertTrue(principalPage.principalPageIsDisplayed());
        Thread.sleep(3000);
    }

    @When("^Se hace click en el boton cambio de nim$")
    public void seHaceClickEnElBotonCambioDeNim() throws Throwable {
        principalPage.clickOnCambioDeNim();
    }

    @Then("^Se debe redirigir a la pantalla Cambio de nim$")
    public void seDebeRedirigirALaPantallaCambioDeNim() throws Throwable {
        Assert.assertTrue("No se redirecciono correctamente a la pantalla Cambio de Nim", cambioDeNimPage.isTitleCambioDeNimDisplayed());
    }


}