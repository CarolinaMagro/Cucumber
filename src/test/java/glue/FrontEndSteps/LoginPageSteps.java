package glue.FrontEndSteps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import glue.TestBase;
import org.junit.Assert;


public class LoginPageSteps extends TestBase {





    @Given("^El usuario se encuentra en la pantalla Login$")
    public void elUsuarioSeEncuentraEnLaPantallaLogin() throws Exception {
        loginPage.goToLoginPage();
        Assert.assertTrue(loginPage.isOnLoginPage());
    }


    @And("^setea credenciales e ingresa a la app$")
    public void seteaCredencialesEIngresaALaApp() throws Exception {
        loginPage.login();
    }


    @And("^Se debe dirigir a la pantalla con titulo \"([^\"]*)\"$")
    public void seDebeDirigirALaPantallaConTitulo(String title) throws Exception {
        Assert.assertTrue(loginPage.getTitle().equalsIgnoreCase(title));

    }


}