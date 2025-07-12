package org.base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService //wrapper class for RestAssured
{
    private static final String BASE_URL ="https://fakerestapi.azurewebsites.net";

    private final RequestSpecification requestSpecification;

    public BaseService(){
        requestSpecification = RestAssured.given().baseUri(BASE_URL);
    }

    protected Response postRequest(Object payload ,String path){
        return requestSpecification.contentType(ContentType.JSON).body(payload).post(path);


    }

}
