package api.endpoints;

// created for CURD requests for the user API.

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserEndpointTest {

    public static Response createUser(User payload){
        Response response=given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                    .post(RoutesTest.POST_URL);
        return response;
    }

    public static Response readUser(String userName){
        Response response=given()
                .pathParam("username",userName)
                .when()
                    .get(RoutesTest.GET_URL);
        return response;
    }

    public static Response updateUser(String userName, User payload){
        Response response= given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .pathParam("username",userName)
                    .body(payload)
                .when()
                    .put(RoutesTest.PUT_URL);
        return response;
    }

    public static Response deleteUser(String userName){
        Response response=given()
                    .pathParam("username",userName)
                .when()
                    .delete(RoutesTest.DELETE_URL);
        return response;
    }
}
