package glue.FrontEndSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import glue.TestBase;
import pom.pages.CartPage;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class CartSteps extends TestBase {

    @Then("^The item is on the cart$")
    public void theItemIsOnTheCart() throws Throwable {
        indexPage.goToIndexPage();
        Thread.sleep(1000);
        indexPage.ClickCart();
        Thread.sleep(1000);
        String Item = cartPage.GetNumberOfItemsInCart().toString();
        assertEquals("1" ,Item);
        cartPage.DeleteItem();
        Thread.sleep(2000);
    }

}

