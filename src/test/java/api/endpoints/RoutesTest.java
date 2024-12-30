package api.endpoints;

/*
Swagger URI --> https://petstore.swagger.io

Create user(POST) : https://petstore.swagger.io/v2/user
Get user(GET) : https://petstore.swagger.io/v2/user/{username}
Update user(PUT) : https://petstore.swagger.io/v2/user/{username}
Delete user (DELETE): https://petstore.swagger.io/v2/user/{username}
 */

public class RoutesTest {

    public static String BASE_URL="https://petstore.swagger.io/v2";
    //reason to add static- I can access this variable directly by using class name without any object

    //User Model
    public static String POST_URL=BASE_URL+"/user";
    public static String GET_URL=BASE_URL+"/user/{username}";
    public static String PUT_URL=BASE_URL+"/user/{username}";
    public static String DELETE_URL=BASE_URL+"/user/{username}";

}
