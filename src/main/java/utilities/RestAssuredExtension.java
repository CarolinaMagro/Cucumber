package utilities;

import cucumber.api.java.it.Ma;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.core.Is;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.patch;

public class RestAssuredExtension{

    public static RequestSpecification Request;


    public RestAssuredExtension(){
        //Arrange
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("http://localhost:8000");
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

    public static ResponseOptions<Response> GetOpsWithToken(String url, String token){
        //Act
        try{
            Request.header(new Header("Authorization", "Bearer "+ token));
            return Request.get(new URI(url));
        }catch (URISyntaxException e){
            e.printStackTrace();
        }
        return null;
    }


    public static ResponseOptions<Response> PUTOpsWithBodyAndPathParams(String url, Map<String, String> body, Map<String, String> pathParams) {
        Request.body(body);
        Request.pathParams(pathParams);
        return Request.put(url);
    }
    public static ResponseOptions<Response> PUTOpsWithBodyAndPathParamsAndToken(String url, Map<String, String> body, Map<String, String> pathParams, String token) {
        Request.header(new Header("Authorization", "Bearer "+ token));
        Request.body(body);
        Request.pathParams(pathParams);
        return Request.put(url);
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
    public ResponseOptions<Response> GetOpsQueryParamsAndToken(String url, String queryParams, String token){
        try{
            Request.header(new Header("Authorization", "Bearer "+ token));
            Request.queryParam(queryParams);
            return Request.get(new URI(url));

        }catch (URISyntaxException e){
            e.printStackTrace();
        }
        return null;
    }


    public static ResponseOptions<Response> PostOpsWithBodyAndPathParams(String url, Map<String, String> pathParams, Map<String, String> body) throws URISyntaxException {
        Request.pathParams(pathParams);
        Request.body(body);
        return Request.post(url);
    }
    public static ResponseOptions<Response> PostOpsWithBodyAndPathParamsAndToken(String url, Map<String, String> pathParams, Map<String, String> body,String token) throws URISyntaxException {
        Request.header(new Header("Authorization", "Bearer "+ token));
        Request.pathParams(pathParams);
        Request.body(body);
        return Request.post(url);
    }


    public static ResponseOptions<Response> PostOpsWithBody(String url, Map<String,String> body){
        Request.body(body);
        return Request.post(url);
    }
    public static ResponseOptions<Response> PostOpsWithBodyAndToken(String url, Map<String,String> body,String token){
        Request.header(new Header("Authorization", "Bearer "+ token));
        Request.body(body);
        return Request.post(url);
    }


    public static ResponseOptions<Response> DeleteOpsWithPathParams(String url, Map<String, String>pathParams){
        Request.pathParams(pathParams);
        return Request.delete(url);
    }
    public static ResponseOptions<Response> DeleteOpsWithPathParamsAndToken(String url, Map<String, String>pathParams, String token){
        Request.header(new Header("Authorization", "Bearer "+ token));
        Request.pathParams(pathParams);
        return Request.delete(url);
    }

    public static ResponseOptions<Response> GetWithPathParams(String url, Map<String, String> pathParams){
        Request.pathParams(pathParams);
        return Request.get(url);
    }
    public static ResponseOptions<Response> GetWithPathParamsAndToken(String url, Map<String, String> pathParams, String token){
        Request.header(new Header("Authorization", "Bearer "+ token));
        Request.pathParams(pathParams);
        return Request.get(url);
    }




}

