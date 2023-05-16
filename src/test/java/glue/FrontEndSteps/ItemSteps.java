package glue.FrontEndSteps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import glue.TestBase;

public class ItemSteps extends TestBase {

    @When("^Add to cart item$")
    public void addToCartItem() throws Throwable {
        itemPage.ClickAddToCart();
        Thread.sleep(1000);
        itemPage.AceptModal();
    }
}

