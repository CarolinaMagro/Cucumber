package seleniumgluecode;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtension;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestGetPost extends TestBase{

    private static ResponseOptions<Response> response;

    @Given("^I perform GET operation for \"([^\"]*)\"$")
    public void iPerformGETOperationFor(String url) throws Throwable {
        //given().contentType(ContentType.JSON);
    }




    @And("^I perform GET for the post number \"([^\"]*)\"$")
    public void iPerformGETForThePostNumber(String postNumber) throws Throwable {
        //when().get(String.format("http://localhost:3000/post/%s",postNumber)).
        //        then().body("author", is("Karthik KK"));
        BDDStyleMethod.SimpleGETPost(postNumber);
    }


    @Then("^I should see the author name as \"([^\"]*)\"$")
    public void iShouldSeeTheAuthorNameAs(String author) throws Throwable {
        //assertThat(this.response.getBody().jsonPath().get("author"), hasItem("Karthik KK"));
    }

    @Then("^I should see the author names$")
    public void iShouldSeeTheAuthorNames() throws Throwable {
        BDDStyleMethod.PerformContainsCollection();
    }



    @Then("^I should see verify Get parameter$")
    public void iShouldSeeVerifyGetParameter() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        BDDStyleMethod.PerformPathParameter();

    }

    @Given("^I perform POST operation for \"([^\"]*)\"$")
    public void iPerformPOSTOperationFor(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       BDDStyleMethod.PerformPOSTWithBodyParameter();

    }

   @Then("^I should see verify GET parameter$")
    public void iShouldSeeVerifyGETParameter() throws Throwable {
        BDDStyleMethod.PerformQueryParameter();
    }


}
