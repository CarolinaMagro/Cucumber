package seleniumgluecode;


import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtension;
import utils.LogHelper;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.*;
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

    @Given("^I perform POST operation for \"([^\"]*)\" with body$")
    public void iPerformPOSTOperationForWithBody(String url, DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        List<List<String>> data = table.raw();

        //set body
        HashMap <String,String>body= new HashMap<>();
        body.put("name", data.get(1).get(0));

        //Path params
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("profileNo",data.get(1).get(1));


        //perform post operation
        response=RestAssuredExtension.PostOpsWithBodyAndPathParams(url, pathParams, body);
    }

    @Then("^I should the body has name as \"([^\"]*)\"$")
    public void iShouldTheBodyHasNameAs(String name) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertThat(response.getBody().jsonPath().get("name"),equalTo(name));
    }


}
