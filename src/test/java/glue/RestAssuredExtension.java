package glue;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.util.Map;


public class RestAssuredExtension {

    private RequestSpecBuilder builder = new RequestSpecBuilder();
    private String method;
    private String url;

    /**
     * RestAssuredExtension constructor to pass the initial settings for the following method
     * @param url
     * @param uri
     * @param method
     * @param token
     */
    public RestAssuredExtension(String url, String uri, String method, String token){
        //this.url="http://localhost:8000"+uri;
        this.url=url+uri;
        this.method= method;

        if (token !=null)
            builder.addHeader("Authorization", "Bearer "+ token);
    }

    public RestAssuredExtension(){
    }


    /**
     * Execute API to execute the API for GET/POST/DELETE
     * @return ResponseOptions <Response>
     */
    private ResponseOptions<Response> ExecuteAPI(){
        RequestSpecification requestSpecification = builder.build();
        RequestSpecification request = RestAssured.given();
        request.contentType(ContentType.JSON);
        request.spec(requestSpecification);


        if(this.method.equalsIgnoreCase(APIConstant.ApiMethods.POST))
            return request.post(this.url);
        else if(this.method.equalsIgnoreCase(APIConstant.ApiMethods.GET))
            return request.get(this.url);
        else if(this.method.equalsIgnoreCase(APIConstant.ApiMethods.DELETE))
            return request.delete(this.url);
        else if(this.method.equalsIgnoreCase(APIConstant.ApiMethods.PUT))
            return request.put(this.url);
        return null;
    }


    /**
     * Authenticate to get token variable
     * @param body
     * @return String token
     */
    public String Authenticate(Object body){
        builder.setBody(body);
        return ExecuteAPI().getBody().jsonPath().get("access_token");
    }

    /**
     * Execute API with query params being passed as the input of it
     * @param queryPath
     * @return Response
     */
    public ResponseOptions<Response> ExecuteWithQueryParams(Map<String,String> queryPath){
        builder.addQueryParams(queryPath);
        return ExecuteAPI();
    }

    /**
     * ExecuteWithPathParams
     * @param pathParams
     * @return
     */
    public ResponseOptions<Response> ExecuteWithPathParams(Map<String,String> pathParams){
        builder.addPathParams(pathParams);
        return ExecuteAPI();
    }

    /**
     * ExecuteWithPathParamsAndBody
     * @param pathParams
     * @param body
     * @return
     */
    public ResponseOptions<Response> ExecuteWithPathParamsAndBody(Map<String,String> pathParams, Map<String,String> body){
        builder.setBody(body);
        builder.addPathParams(pathParams);
        return ExecuteAPI();
    }

    public ResponseOptions<Response> ExecuteWithBody(Object body){
        builder.setBody(body);
        return ExecuteAPI();
    }


    public ResponseOptions<Response> ExecuteWithoutBody(){
        return ExecuteAPI();
    }

    public ResponseOptions<Response> PutWithBodyAndQueryParam(Object body,Map<String,String> pathParams){
        builder.addPathParams(pathParams);
        builder.setBody(body);
        return ExecuteAPI();
    }



}
