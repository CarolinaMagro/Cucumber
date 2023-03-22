package glue.FrontEndSteps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import glue.TestBase;
import static junit.framework.TestCase.*;




public class LoginPageSteps extends TestBase {





    @Given("^El usuario se encuentra en la pantalla Login$")
    public void elUsuarioSeEncuentraEnLaPantallaLogin() throws Exception {
        loginPage.goToLoginPage();
        assertTrue("No se pudo ingresar a la pantalla de login",loginPage.isInLogginPage());
    }


    @And("^setea credenciales e ingresa a la app$")
    public void seteaCredencialesEIngresaALaApp() throws Exception {
        loginPage.login();
    }


    @And("^Se debe dirigir a la pantalla con titulo \"([^\"]*)\"$")
    public void seDebeDirigirALaPantallaConTitulo(String title) throws Exception {
        assertEquals(title,loginPage.getTitle());

    }


}

