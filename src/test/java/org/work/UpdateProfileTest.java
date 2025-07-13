package org.work;

import io.restassured.response.Response;
import org.base.AllUserService;
import org.base.UserProfileManagementService;
import org.models.request.ProfileRequest;
import org.models.request.UserRequest;
import org.models.response.UserProfileResponse;
import org.models.response.UserResponse;
import org.testng.annotations.Test;

public class UpdateProfileTest {

    @Test
    public void updateProfileTest () {
        AllUserService allUserService = new AllUserService();
        Response response = allUserService.postUser(new UserRequest(1, "ABC", "123"));
        UserResponse userResponse = response.as(UserResponse.class);
        System.out.println("TOKEN IS : " + userResponse.getToken());

        UserProfileManagementService userProfileManagementService =new UserProfileManagementService();
        response = userProfileManagementService.getProfile(userResponse.getToken());
        System.out.println(response.asPrettyString());

        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        System.out.println(userProfileResponse.getFirstName());

//Using builder design pattern to pass the payload easily and in any sequence
        ProfileRequest profileRequest=new ProfileRequest.Builder()
                .firstName("ABC")
                .lastName("CVB")
                .email("enac@gmail.com")
                .mobileNumber("908867676")
                .build();


        response = userProfileManagementService.updateProfile(userResponse.getToken(),profileRequest);
        System.out.println(response.asPrettyString());



    }
}
