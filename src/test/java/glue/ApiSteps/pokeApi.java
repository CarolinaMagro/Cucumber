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

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class pokeApi extends TestBase {

    public static ResponseOptions<Response> response;
    public static  String token;
    private static String url= "https://pokeapi.co/api/v2/pokemon";

    @Given("^I perform post operation for \"([^\"]*)\"$")
    public void iPerformPostOperationFor(String pokemon) throws Throwable {
        RestAssuredExtension restAssuredExtension = new RestAssuredExtension(url,pokemon, "GET", "");

        ResponseOptions<Response> asdf = restAssuredExtension.ExecuteWithoutBody();
        response = asdf;
    }


    @Then("^I should see the pokemon as \"([^\"]*)\"$")
    public void iShouldSeeThePokemonAs(String pokemon) throws Throwable {
        assertThat(response.getBody().jsonPath().get("name"), equalTo(pokemon));

    }
}
