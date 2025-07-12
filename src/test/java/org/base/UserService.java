package org.base;

import io.restassured.response.Response;
import org.models.request.UserRequest;

public class UserService extends BaseService {

    private static final String BASE_PATH ="/api/v1/Users";

    public Response postUser(UserRequest payload)
    {
        return postRequest(payload,BASE_PATH);
    }
}
