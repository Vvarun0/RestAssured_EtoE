package org.work;

import com.beust.ah.A;
import io.restassured.response.Response;
import org.base.AllUserService;
import org.models.request.SignUpRequest;
import org.testng.annotations.Test;

public class ForgotPasswordTest {
    @Test(description = "Verify the forgot password")
    public void forgotPasswordTest(){
        //we can do this with constructor as well but here we don't need to remember the sequence
        AllUserService allUserService=new AllUserService();
        Response response = allUserService.forgotPassword("abcd@gmail.com");
        System.out.println(response.asPrettyString());
    }
}
