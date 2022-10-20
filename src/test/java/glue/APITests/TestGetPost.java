package glue.APITests;


import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.hu.Ha;
import cucumber.api.java.it.Ma;
import glue.TestBase;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.hamcrest.core.IsNot;
import utilities.RestAssuredExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestGetPost extends TestBase {

    private static ResponseOptions<Response> response;



    @Given("^I perform GET operation for \"([^\"]*)\"$")
    public void iPerformGETOperationFor(String url) throws Throwable {
        String token = response.getBody().jsonPath().get("access_token");
        response = null;
        response = RestAssuredExtension.GetOpsWithToken(url, token);

    }


    @Then("^I should see the author name as \"([^\"]*)\"$")
    public void iShouldSeeTheAuthorNameAs(String author) throws Throwable {
        assertThat(response.getBody().jsonPath().get("author"), hasItem(author));
    }

    @Then("^I should see the author names$")
    public void iShouldSeeTheAuthorNames() throws Throwable {
        assertThat(response.getBody().jsonPath().get("author"),hasItems("Karthik KK", "Karthik KK",null,"ExecuteAutomation"));

    }



    @Then("^I should see verify Get parameter$")
    public void iShouldSeeVerifyGetParameter() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //BDDStyleMethod.PerformPathParameter();
        assertThat(response.getBody().jsonPath().get("author"), hasItem("Karthik KK"));
    }

    @Given("^I ensure to perform POST operation for \"([^\"]*)\" with body as$")
    public void iEnsureToPerformPOSTOperationForWithBodyAs(String url, DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        Map<String, String> body = new HashMap<>();
        body.put("id", data.get(1).get(0));
        body.put("title", data.get(1).get(1));
        body.put("author", data.get(1).get(2));
        String token= response.getBody().jsonPath().get("access_token");
        response = null;
        response = RestAssuredExtension.PostOpsWithBodyAndToken(url,body, token);

    }

    @And("^I  Perform DELETE operation  for \"([^\"]*)\"$")
    public void iPerformDELETEOperationFor(String url, DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("postid", data.get(1).get(0));
        String token = response.getBody().jsonPath().get("access_token");
        response = null;
        response = RestAssuredExtension.DeleteOpsWithPathParamsAndToken(url, pathParams,token);

    }

    @And("^I perform GET operation with path parameter for \"([^\"]*)\"$")
    public void iPerformGETOperationWithPathParameterFor(String url, DataTable table) throws Throwable {
        List<List<String>> data = table.raw();

        Map<String, String > pathParams = new HashMap<>();
        pathParams.put("postid", data.get(1).get(0));
        String token= response.getBody().jsonPath().get("access_token");
        response=null;
        response = RestAssuredExtension.GetWithPathParamsAndToken(url, pathParams,token);
    }

    @Then("^I \"([^\"]*)\" see the body with title as \"([^\"]*)\"$")
    public void iShouldNotSeeTheBodyWithTitleAs(String condition,String title) throws Throwable {
        if(condition.equalsIgnoreCase("should not")) {
            assertThat(response.getBody().jsonPath().get("title"), IsNot.not(title));
        }else {
            assertThat(response.getBody().jsonPath().get("title"), is(title));
        }
    }




    @Given("^I perform POST operation for \"([^\"]*)\" with body$")
    public void iPerformPOSTOperationForWithBody(String url, DataTable table) throws Throwable {
        List<List<String>> data = table.raw();

        //set body
        HashMap <String,String> body= new HashMap<>();
        body.put("name", data.get(1).get(0));

        //Path params
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("profileNo",data.get(1).get(1));

        String token = response.getBody().jsonPath().get("access_token");
        response=null;

        //perform post operation
        response=RestAssuredExtension.PostOpsWithBodyAndPathParamsAndToken(url, pathParams, body, token);
    }

    @Then("^I should the body has name as \"([^\"]*)\"$")
    public void iShouldTheBodyHasNameAs(String name) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertThat(response.getBody().jsonPath().get("name"),equalTo(name));

    }




    @And("^I  Perform PUT operation  for \"([^\"]*)\"$")
    public void iPerformPUTOperationFor(String url, DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        Map<String, String> body = new HashMap<>();
        body.put("id", data.get(1).get(0));
        body.put("title", data.get(1).get(1));
        body.put("author", data.get(1).get(2));

        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("postid",data.get(1).get(0));


        RestAssuredExtension.PUTOpsWithBodyAndPathParams(url,body,pathParams);
    }


    @Given("^I perform authentication operation for \"([^\"]*)\" with body$")
    public void iPerformAuthenticationOperationForWithBody(String url, DataTable table) throws Throwable {
        List<List<String>> data = table.raw();

        HashMap<String ,String> body = new HashMap<>();
        body.put("email", data.get(1).get(0));
        body.put("password", data.get(1).get(1));
        response=RestAssuredExtension.PostOpsWithBody(url, body);

    }



}
