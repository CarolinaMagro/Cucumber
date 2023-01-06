package glue.ApiSteps;


import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import glue.APIConstant;
import glue.RestAssuredExtension;
import glue.TestBase;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

import pojo.Examples.Address;
import pojo.Examples.Location;
import pojo.Examples.LoginBody;
import pojo.Examples.Posts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
public class TestGetPost extends TestBase {

    public static ResponseOptions<Response> response;
    public static  String token;
    private static String url= "http://localhost:8000";


    @Given("^I perform GET operation for \"([^\"]*)\"$")
    public void iPerformGETOperationFor(String uri) throws Throwable {

        RestAssuredExtension restAssuredExtension = new RestAssuredExtension(url,uri, "GET", token);
        response = restAssuredExtension.ExecuteWithoutBody();

    }


    @Then("^I should see the author name as \"([^\"]*)\"$")
    public void iShouldSeeTheAuthorNameAs(String authorName) throws Throwable {
        Posts posts = response.getBody().as(Posts.class);
        assertThat(posts.getAuthor(), equalTo(authorName));

   }


    @Then("^I should see the author names$")
    public void iShouldSeeTheAuthorNames() throws Throwable {

        assertThat(response.getBody().jsonPath().get("author"),hasItems("Karthik KK", "Karthik KK",null,"ExecuteAutomation"));

    }



    @Then("^I should see verify Get parameter$")
    public void iShouldSeeVerifyGetParameter() throws Throwable {
        assertThat(response.getBody().jsonPath().get("author"), hasItem("Karthik KK"));

    }

    @Given("^I ensure to perform POST operation for \"([^\"]*)\" with body as$")
    public void iEnsureToPerformPOSTOperationForWithBodyAs(String uri, DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        Posts body = new Posts();
        body.setId(Integer.parseInt(data.get(1).get(0)));
        body.setTitle(data.get(1).get(1));
        body.setAuthor(data.get(1).get(2));

        RestAssuredExtension restAssuredExtension = new RestAssuredExtension(url,uri, "POST", token);
        response = restAssuredExtension.ExecuteWithBody(body);

    }


    @And("^I  Perform DELETE operation  for \"([^\"]*)\"$")
    public void iPerformDELETEOperationFor(String uri, DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("postid", data.get(1).get(0));

        RestAssuredExtension restAssuredExtension = new RestAssuredExtension(url,uri, "DELETE", token);
        response = restAssuredExtension.ExecuteWithPathParams(pathParams);
    }

    @And("^I perform GET operation with path parameter for \"([^\"]*)\"$")
    public void iPerformGETOperationWithPathParameterFor(String uri, DataTable table) throws Throwable {
        List<List<String>> data = table.raw();

        Map<String, String > pathParams = new HashMap<>();
        pathParams.put("postid", data.get(1).get(0));

        response=null;
        RestAssuredExtension restAssuredExtension = new RestAssuredExtension(url,uri, "GET", token);
        response = restAssuredExtension.ExecuteWithPathParams(pathParams);

    }

    @Then("^I \"([^\"]*)\" see the body with title as \"([^\"]*)\"$")
    public void iShouldNotSeeTheBodyWithTitleAs(String condition,String title) throws Throwable {
        if(condition.equalsIgnoreCase("should not")) {
            //assertThat(response.getBody().jsonPath().get("title"), IsNot.not(title));
            Posts posts = response.getBody().as(Posts.class);
            assertThat(posts.getTitle(), not(title));

        }else {
            //assertThat(response.getBody().jsonPath().get("title"), is(title));
            Posts posts = response.getBody().as(Posts.class);
            assertThat(posts.getTitle(), equalTo(title));
        }
    }




    @Given("^I perform POST operation for \"([^\"]*)\" with body$")
    public void iPerformPOSTOperationForWithBody(String uri, DataTable table) throws Throwable {
        List<List<String>> data = table.raw();

        //set body
        HashMap <String,String> body= new HashMap<>();
        body.put("name", data.get(1).get(0));

        //Path params
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("profileNo",data.get(1).get(1));


        response=null;


        RestAssuredExtension restAssuredExtension = new RestAssuredExtension(url,uri, "GET", token);
        response = restAssuredExtension.ExecuteWithPathParamsAndBody(pathParams, body);


        //perform post operation
        //response=RestAssuredExtension.PostOpsWithBodyAndPathParamsAndToken(url, pathParams, body, token);


    }

    @Then("^I should the body has name as \"([^\"]*)\"$")
    public void iShouldTheBodyHasNameAs(String name) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertThat(response.getBody().jsonPath().get("name"),equalTo(name));

    }




    @And("^I  Perform PUT operation  for \"([^\"]*)\"$")
    public void iPerformPUTOperationFor(String uri, DataTable table) throws Throwable {
        List<List<String>> data = table.raw();


        Map<String, String> body = new HashMap<>();
        body.put("id", data.get(1).get(0));
        body.put("title", data.get(1).get(1));
        body.put("author", data.get(1).get(2));

        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("postid",data.get(1).get(0));

        RestAssuredExtension restAssuredExtension = new RestAssuredExtension(url,uri, "PUT", token);
        response = restAssuredExtension.PutWithBodyAndQueryParam(body, pathParams);
        //RestAssuredExtension.PUTOpsWithBodyAndPathParams(url,body,pathParams);


    }


    @Given("^I perform authentication operation for \"([^\"]*)\" with body$")
    public void iPerformAuthenticationOperationForWithBody(String uri, DataTable table) throws Throwable {
        List<List<String>> data = table.raw();

        LoginBody loginBody = new LoginBody();
        loginBody.setEmail(data.get(1).get(0));
        loginBody.setPassword(data.get(1).get(1));

        RestAssuredExtension restAssuredExtension = new RestAssuredExtension(url,uri, APIConstant.ApiMethods.POST,null);
        this.token= restAssuredExtension.Authenticate(loginBody);

    }


    @And("^I perform GET operation with path parameter for address \"([^\"]*)\"$")
    public void iPerformGETOperationWithPathParameterForAddress(String uri, DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<List<String>> data = table.raw();
        Map<String,String> queryParams = new HashMap<>();
        queryParams.put("id", data.get(1).get(0));

        RestAssuredExtension restAssuredExtension = new RestAssuredExtension(url,uri, "GET", token);
        response = restAssuredExtension.ExecuteWithQueryParams(queryParams);

    }



    @Then("^I should see the street name as \"([^\"]*)\" for the \"([^\"]*)\" address$")
    public void iShouldSeeTheStreetNameAsForTheAddress(String streetName, String type) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Location[] location;
                location= response.getBody().as(Location[].class);

        //Filter the address based on the type addresses
        Address address = location[0].getAddress().stream().filter(x->x.getType().equalsIgnoreCase(type))
                .findFirst().orElse(null);

        assertThat(address.getStreet(),equalTo(streetName));
    }

    @Then("^I should see the author name as \"([^\"]*)\" with json validation$")
    public void iShouldSeeTheAuthorNameAsWithJsonValidation(String arg0) throws Throwable {

        //returns the body as string
        String responseBody = response.getBody().asString();

        //assert
        assertThat(responseBody, matchesJsonSchemaInClasspath("post.json"));

    }



}
