package org.base;

import io.restassured.response.Response;
import org.models.request.SignUpRequest;
import org.models.request.UserRequest;

import java.util.HashMap;
import java.util.Map;

public class AllUserService extends BaseService {
//Each service will have a base class and each service method will be seperate method that will call base http methods
    private static final String BASE_PATH ="/api/v1/Users";

    public Response postUser(UserRequest payload)
    {
        return postRequest(payload,BASE_PATH);
    }

    public Response signUpUser(SignUpRequest payload)
    {
        return postRequest(payload,BASE_PATH);
    }

    public Response forgotPassword(String emailAddress)
    {
        Map<String,String> payload = new HashMap<>();
        payload.put("email",emailAddress);
        return postRequest(payload,BASE_PATH);
    }
}
