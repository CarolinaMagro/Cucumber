
package glue.FrontEndSteps;



import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import glue.TestBase;
import org.junit.Assert;

import static junit.framework.TestCase.assertTrue;


public class CambioDeNimPageSebaSteps extends TestBase {

    String nuevoNumeroLinea;



    @Given("^Se ingresa el billing number \"([^\"]*)\"$")
    public void seIngresaElBillingNumber(String billingNumber) throws Throwable {

    }

    @And("^Se setea el codigo de area con \"([^\"]*)\"$")
    public void seSeteaElCodigoDeAreaConElNumero(String codArea) throws Throwable {
        cambioDeNimPage.setInputCodigoArea(codArea);
        float time = 0;
        while (cambioDeNimPage.getNuevoNumeroLinea().isEmpty() && time < 10) {
            Thread.sleep(250);
            time += 0.25;
        }
    }

    @And("^Se obtiene el nuevo numero de linea$")
    public void seObtieneElNuevoNumeroDeLinea() throws Exception {
        this.nuevoNumeroLinea = null;

        if (!cambioDeNimPage.getNuevoNumeroLinea().isEmpty()){
            Thread.sleep(500);
            this.nuevoNumeroLinea = cambioDeNimPage.getNuevoNumeroLinea();
        }else{
            System.out.println("No se pudo obtener el nuevo numero de linea");
        }
        Assert.assertTrue("No se encontró nuevo numero de linea", !cambioDeNimPage.getNuevoNumeroLinea().isEmpty());
    }







    @Then("^Se debe actualizar billing number con nuevo numero de linea obtenido$")
    public void seDebeActualizarBillingNumberConNuevoNumeroDeLineaObtenido() throws Exception {
        float time = 0;
        while (!cambioDeNimPage.getBillingNumber().equalsIgnoreCase(nuevoNumeroLinea) && time < 10) {
            Thread.sleep(250);
            time += 0.25;
        }
        if (nuevoNumeroLinea!=null) {
            Assert.assertTrue("El campo 'billing number' deberia tener el valor '"+nuevoNumeroLinea+"', pero se encontró el valor '"+cambioDeNimPage.getBillingNumber()+"'", cambioDeNimPage.getBillingNumber().equalsIgnoreCase(nuevoNumeroLinea));
            Assert.assertTrue("El campo 'numero actual' deberia tener el valor '"+nuevoNumeroLinea+"', pero se encontró el valor '"+cambioDeNimPage.getNumeroActual()+"'", cambioDeNimPage.getNumeroActual().equalsIgnoreCase(nuevoNumeroLinea));
        }{
            Assert.assertTrue(false);
        }
    }


    @Given("^Se busca el billing number \"([^\"]*)\"$")
    public void seBuscaElBillingNumber(String billingNumber) throws Throwable {
        cambioDeNimPage.setInputBillingNumber(billingNumber);
        cambioDeNimPage.clickOnButtonSearch();
        float time = 0;
        while (!cambioDeNimPage.getNumeroActual().equalsIgnoreCase(billingNumber) && time < 10) {
            Thread.sleep(250);
            time += 0.25;
        }
        Assert.assertTrue(cambioDeNimPage.getNumeroActual().equalsIgnoreCase(billingNumber));
    }


    @And("^Se debe actualizar numero actual con nuevo numero de linea obtenido$")
    public void seDebeActualizarNumeroActualConNuevoNumeroDeLineaObtenido() throws Exception {
        float time = 0;
        while (!cambioDeNimPage.getNumeroActual().equalsIgnoreCase(nuevoNumeroLinea) && time < 10) {
            Thread.sleep(250);
            time += 0.25;
        }
        if (nuevoNumeroLinea!=null) {
            Assert.assertTrue("El campo 'numero actual' deberia tener el valor '"+nuevoNumeroLinea+"', pero se encontró el valor '"+cambioDeNimPage.getNumeroActual()+"'", cambioDeNimPage.getNumeroActual().equalsIgnoreCase(nuevoNumeroLinea));
        }{
            Assert.assertTrue(false);
        }
    }


    @Then("^Se debe resetear el campo codArea$")
    public void seDebeResetearElCampoCodArea() throws Exception {
        float time = 0;
        while (!cambioDeNimPage.getCodArea().isEmpty() && time < 10) {
            Thread.sleep(250);
            time += 0.25;
        }
        Assert.assertTrue("El campo Código de area no se blanqueo!",cambioDeNimPage.getCodArea().isEmpty());
    }


    @Then("^Se debe resetear el campo bloque$")
    public void seDebeResetearElCampoBloque() throws Exception {
        float time = 0;
        while (!cambioDeNimPage.getBloque().isEmpty() && time < 10) {
            Thread.sleep(250);
            time += 0.25;
        }

        Assert.assertTrue("El campo 'bloque' no se blanqueo!",cambioDeNimPage.getBloque().isEmpty());
    }


    @And("^Se habilita el check especial$")
    public void seHabilitaElCheckEspecial() throws Exception {
        cambioDeNimPage.clickOnCheckSpecialNumber();
        Thread.sleep(300);
    }


    @And("^Se obtiene el nuevo numero de linea especial$")
    public void seObtieneElNuevoNumeroDeLineaEspecial() throws Exception {
        this.nuevoNumeroLinea=null;
        float time = 0;
        while (cambioDeNimPage.getNumeroEspecial().isEmpty() && time < 10) {
            Thread.sleep(250);
            time += 0.25;
        }
        if (!cambioDeNimPage.getNumeroEspecial().isEmpty()){
            Thread.sleep(500);
            this.nuevoNumeroLinea = cambioDeNimPage.getNumeroEspecial();
        }else{
            Assert.assertTrue("No se pudo obtener el nuevo numero de linea",false);
        }

    }


    @And("^Se setea un numero especial \"([^\"]*)\"$")
    public void seSeteaUnNumeroEspecial(String numeroEspecial) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.nuevoNumeroLinea=null;

        cambioDeNimPage.setNumeroEspecial(numeroEspecial);

        Thread.sleep(1000);

        if (!cambioDeNimPage.getNumeroEspecial().isEmpty()){
            Thread.sleep(500);
            this.nuevoNumeroLinea = numeroEspecial;
        }else{
            Assert.assertTrue(false);
        }
    }

    @Then("^Se debe visualizar el mensaje de error$")
    public void seDebeVisualizarElMensajeDeError() throws Exception {
        Thread.sleep(4000);
        assertTrue("Expected: Error, But found: "+cambioDeNimPage.catch_messages() , cambioDeNimPage.catch_messages().contains("Error"));
    }

    @Then("^Se verifica el mensaje esperado \"([^\"]*)\"$")
    public void seVerificaSegunElnumeroElMensaje(String mensaje_esperado) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(cambioDeNimPage.ValidateCompanyRules(mensaje_esperado));
    }


    @And("^El campo bloque debe actualizarse con el numero \"([^\"]*)\"$")
    public void elCampoBloqueDebeActualizarseConElNumero(String bloque) throws Throwable {
        Assert.assertTrue("No se actualizo el bloque",cambioDeNimPage.getBloque().equals(bloque));

    }

    //Caro
    @And("^El usuario se encuentra en la pantalla Cambio de Nim$")
    public void elUsuarioSeEncuentraEnLaPantallaCambioDeNim() {
            cambioDeNimPage.goToCambioDeNimPage();
            //assertTrue(cambioDeNimPage.cambioDeNimPageIsDisplayed());
    }

    @And("^Se hace click en el boton guardar nim$")
    public void seHaceClickEnElBotonGuardarNim() throws Throwable{
        cambioDeNimPage.clickOnGuardarNim();
    }

}
