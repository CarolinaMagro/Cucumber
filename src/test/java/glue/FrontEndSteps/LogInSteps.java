package glue.FrontEndSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import glue.TestBase;

import java.text.SimpleDateFormat;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class LogInSteps extends TestBase {
    @Given("^The user opens Log in modal$")
    public void theUserOpensLogInModal() throws Throwable {
    indexPage.ClickLogIn();
    Thread.sleep(1000);
    }
    @When("^The user write the Username$")
    public void theUserWriteHisUsername() throws Throwable {
        loginPage.setUser();
        }

    @When("^The user write the Password$")
    public void theUserWriteHisPassword() throws Throwable {
        loginPage.setPass();
    }
    @When("^Click into Log in$")
    public void clickIntoLogIn() throws Throwable {
        loginPage.clickLogin();
    }

    @Then("^The user is loged$")
    public void theUserIsLoged() throws Throwable {
        assertEquals ("Welcome Baufest2023.05.16.11.24.10",indexPage.GetWelcomeText());
    }
}

