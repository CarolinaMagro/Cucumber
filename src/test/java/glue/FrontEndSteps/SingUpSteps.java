package glue.FrontEndSteps;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import glue.TestBase;
import pom.BasePage;
import pom.pages.IndexPage;
import pom.pages.SingUpPage;

import java.text.SimpleDateFormat;

import static junit.framework.TestCase.*;


public class SingUpSteps extends TestBase {
    @Given("^The user is on the Demoblaze Page$")
    public void theUserIsOnTheDemoblazePage() throws Throwable {
        loginPage.goToIndexPage();
        assertTrue(indexPage.IsDisplayedIndex());
    }

    @Given("^The user opens sing up modal$")
    public void theUserOpensSingUpModal() throws Throwable {
        indexPage.ClickSignIn();
    }

    @When("^The user write his Username$")
    public void theUserWriteHisUsername() throws Throwable {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        singUpPage.SetUsrName("Baufest"+timeStamp);
        System.out.println("----------------- username: Baufest"+timeStamp + " -------------");
    }

    @When("^The user write his Password$")
    public void theUserWriteHisPassword() throws Throwable {
        singUpPage.SetUsrPass("123456");
        System.out.println("----------------- pass: 123456 -------------");
    }

    @When("^Click into Sing Up$")
    public void clickIntoSingUp() throws Throwable {
        singUpPage.clickSingUp();

    }

    @Then("^The user is registred$")
    public void theUserIsRegistred() throws Throwable {
        assertTrue(singUpPage.AceptModal());
    }
}