package org.work;

import io.restassured.response.Response;
import org.base.AllUserService;
import org.base.UserProfileManagementService;
import org.models.request.UserRequest;
import org.models.response.UserProfileResponse;
import org.models.response.UserResponse;
import org.testng.annotations.Test;

public class GetProfileRequestTest {

    @Test
    public void getProfileRequestTest(){
        //getting the token for sending it with get profile request
        AllUserService allUserService =new AllUserService();
        Response response = allUserService.postUser(new UserRequest(1,"ABC","123"));
        UserResponse userResponse = response.as(UserResponse.class);
        System.out.println("TOKEN IS : " +userResponse.getToken());

        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        Response response1 = userProfileManagementService.getProfile(userResponse.getToken());
//        System.out.println(response1);
        UserProfileResponse userProfileResponse = response1.as(UserProfileResponse.class);
        System.out.println(userProfileResponse.getUsername());
    }
}
