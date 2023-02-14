
package glue.FrontEndSteps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import glue.TestBase;
import org.junit.Assert;
import pom.pages.CambioDeEstadoPage.*;

import static junit.framework.TestCase.assertTrue;


public class CambioDeEstadoPageSteps extends TestBase {

    @And("^Se hace click en el boton Cancelado$")
    public void seHaceClickEnElBotonCancelado() throws Exception {
        ///HACER
        cambioDeEstadoPage.getEstadoActual();
    }
}
