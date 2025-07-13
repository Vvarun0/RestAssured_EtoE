package org.work;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginApiTest_test {
    @Test(description = "Verify the User Login")
    public void loginTest1(){
        //scripts like this are hard to maintain
        RestAssured.baseURI = "https://fakerestapi.azurewebsites.net/";

        String requestBody = "{\n" +
                "  \"id\": 2,\n" + // Note: 'id' might not be used for login but for user creation.
                "  \"userName\": \"A\",\n" +
                "  \"password\": \"A\"\n" +
                "}";

        Response response = RestAssured.given()
                .log().all() // Log request details
                .contentType(ContentType.JSON) // Set Content-Type correctly
                .body(requestBody)
                .post("api/v1/Users"); // This endpoint likely isn't for login/auth
        Assert.assertEquals(response.getStatusCode(),200);
//        System.out.println("Response Status Code: " + response.statusCode());
//        System.out.println("Response Body: " + response.prettyPrint());
    }
}