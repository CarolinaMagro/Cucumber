package utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.core.Is;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredExtension{

    public static RequestSpecification Request;

    public RestAssuredExtension(){
        //Arrange
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("http://localhost:3000");
        builder.setContentType(ContentType.JSON);
        RequestSpecification requestSpec = builder.build();
        Request = given().spec(requestSpec);
    }

    public static void GetOpsWithPathParameters(String url, Map<String, String> pathParams){
        //Act
        Request.pathParams(pathParams);
        try {
            Request.get(new URI(url));
        }catch (URISyntaxException e){
            e.printStackTrace();
        }
    }



    public static ResponseOptions<Response> GetOps(String url){
        //Act
        try{
            return Request.get(new URI(url));
        }catch (URISyntaxException e){
            e.printStackTrace();
        }
        return null;
    }


    public ResponseOptions<Response> GetOpsQueryParams(String url, String queryParams){
        try{
            Request.queryParam(queryParams);
            return Request.get(new URI(url));

        }catch (URISyntaxException e){
            e.printStackTrace();
        }
        return null;
    }


    public ResponseOptions<Response> PostOpsWithBodyAndPathParams(String url, Map<String, String>pathParams, Map<String, String>body){
        Request.pathParams(pathParams);
        Request.body(body);
        try{
            return Request.post(new URI(url));
        }catch (URISyntaxException e){
            e.printStackTrace();
        }
        return null;
    }

}
