
package glue.FrontEndSteps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import glue.TestBase;
import org.junit.Assert;
import pom.pages.HeaderPage;

import static junit.framework.TestCase.assertTrue;


public class HeaderPageSteps extends TestBase {

    String nuevoNumeroLinea;

    @Given("^Se ingresa el billing number \"([^\"]*)\"$")
    public void seIngresaElBillingNumber(String billingNumber) throws Throwable {

        headerPage.setInputBillingNumber(billingNumber);
    }

    @Given("^Se busca el billing number \"([^\"]*)\"$")
    public void seBuscaElBillingNumber(String billingNumber) throws Throwable {
        headerPage.setInputBillingNumber(billingNumber);
        headerPage.clickOnButtonSearch();
        float time = 0;
        while (headerPage.getClientName().isEmpty() && time < 20) {
            Thread.sleep(250);
            time += 0.25;
        }
        Assert.assertTrue(!headerPage.getClientName().isEmpty());
    }


}
