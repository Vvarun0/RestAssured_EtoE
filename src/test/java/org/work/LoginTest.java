package org.work;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.restassured.response.Response;
import org.base.UserService;
import org.models.request.UserRequest;
import org.models.response.UserResponse;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest {
    @Test(description = "Verify the User Login")
    public void userPost(){
        UserRequest userRequest = new UserRequest(2,"A","A");
        UserService userService = new UserService();
        Response response = userService.postUser(userRequest);
        UserResponse userResponse = response.as(UserResponse.class); //deserialization using as method
        System.out.println("Response Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.prettyPrint());
        System.out.println(("User Response " + userResponse.getId() + userResponse.getUsername() + userResponse.getEmail()));

        Assert.assertNotNull(userResponse.getToken());


    }
}
