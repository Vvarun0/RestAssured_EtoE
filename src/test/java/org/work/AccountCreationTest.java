package org.work;

import io.restassured.response.Response;
import org.base.AllUserService;
import org.models.request.SignUpRequest;
import org.testng.annotations.Test;

public class AccountCreationTest {
    @Test(description = "Verify the Account creation")
    public void createAccountTest(){
        //we can do this with constructor as well but here we don't need to remember the sequence
        SignUpRequest signUpRequest = new SignUpRequest.Builder().username("varun7")
                .email("varun@gmail.com")
                .firstName("Varun")
                .password("12345")
                .lastName("singh")
                .mobileNumber("01918292")
                .build();

        AllUserService allUserService =new AllUserService();
        Response response = allUserService.signUpUser(signUpRequest);
        System.out.println(response.prettyPrint());

    }
}
