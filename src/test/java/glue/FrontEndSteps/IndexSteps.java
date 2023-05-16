package glue.FrontEndSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import glue.TestBase;
import static junit.framework.TestCase.assertEquals;

public class IndexSteps extends TestBase {
    @When("^Click log out$")
    public void clickLogOut() throws Throwable {
        indexPage.ClickLogOut();
        Thread.sleep(1000);
    }

    @Then("^The user is loged out$")
    public void theUserIsLogedOut() throws Throwable {
        assertEquals ("Log in",indexPage.GetLogInText());

    }
    @When("^Select a item$")
    public void selectAItem() throws Throwable {
        indexPage.clickItem();
        Thread.sleep(3000);
    }
}

