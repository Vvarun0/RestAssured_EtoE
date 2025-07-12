package org.base;

import io.restassured.response.Response;
import org.models.request.ProfileRequest;

public class UserProfileManagementService extends BaseService {
    private static final String BASE_PATH ="api/v1/Authors";

    public Response getProfile(String token){
        setAuthToken(token);
        return getRequest(BASE_PATH);
    }

    public Response updateProfile(String token , ProfileRequest payload){
        setAuthToken(token);
        return putRequest(payload,BASE_PATH);
    }

}
