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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class BlockCode extends TestBase {

    public static ResponseOptions<Response> response;
    public static  String token = null;
    public static String url = "https://account-cellulars-service-product-dmain-bs-ar.apps.osen02.claro.amx/account-cellulars-service";

    @Given("^I perform operation for \"([^\"]*)\" with body$")
    public void iPerformOperationForWithBody(String uri, DataTable table) throws Throwable {
        RestAssuredExtension restAssuredExtension = new RestAssuredExtension(url,uri, "POST", "");

        List<List<String>> data = table.raw();

        pojo.blockCode.BlockCode body = new pojo.blockCode.BlockCode();
        body.setAreaCode(data.get(1).get(0));
        body.setIsCppOrMpp(data.get(1).get(1));
        body.setTecnology(data.get(1).get(2));


        response = restAssuredExtension.ExecuteWithBody(body);
        String asdf= "asdfa";


    }



    @Then("^I should see the blockCode as \"([^\"]*)\"$")
    public void iShouldSeeTheBlockCodeAs(String codigo) throws Throwable {
    //    assertThat(response.getBody().jsonPath().get("blockCode"),equalTo(codigo));


    }
}
