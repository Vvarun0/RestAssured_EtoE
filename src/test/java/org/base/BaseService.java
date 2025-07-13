package org.base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.filters.LoggingFilter;

public class BaseService
//wrapper class for RestAssured that will contain all http methods to do abstractions
{
    private static final String BASE_URL ="https://fakerestapi.azurewebsites.net";

    private final RequestSpecification requestSpecification;

    static {
        RestAssured.filters(new LoggingFilter());
    }

    public BaseService(){
        requestSpecification = RestAssured.given().baseUri(BASE_URL);
    }

    protected Response postRequest(Object payload ,String path){
        return requestSpecification.contentType(ContentType.JSON).body(payload).post(path);
    }
    protected Response getRequest(String basePath){
        return requestSpecification.get();
    }

    protected void setAuthToken(String token){
         requestSpecification.header("Authorization","Bearer " + token);
    }

    protected Response putRequest(Object payload ,String path){
        return requestSpecification.contentType(ContentType.JSON).body(payload).put(path);
    }
}
