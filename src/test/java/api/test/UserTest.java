package api.test;

import api.endpoints.UserEndpointTest;
import api.payload.User;
import io.restassured.response.Response;
import net.datafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTest {

    Faker faker;
    User userPayload;

    @BeforeClass
    public void setUpData(){
        faker=new Faker();
        userPayload=new User();

        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstname(faker.name().firstName());
        userPayload.setLastname(faker.name().lastName());
        userPayload.setEmail(faker.internet().emailAddress());
        userPayload.setPassword(faker.internet().password(5,10));
        userPayload.setPhone(faker.phoneNumber().cellPhone());
    }

    @Test (priority = 1)
    public void testPOSTUser() {
        Response response=UserEndpointTest.createUser(userPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test (priority = 2)
    public void testGETUser() {
        Response response=UserEndpointTest.readUser(this.userPayload.getUsername());
        response.then().log().body();
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test (priority = 3)
    public void testPUTUser() {

        //update new data
        userPayload.setFirstname(faker.name().firstName());
        userPayload.setLastname(faker.name().lastName());
        userPayload.setEmail(faker.internet().emailAddress());

        Response response=UserEndpointTest.updateUser(this.userPayload.getUsername(),userPayload);
        response.then().log().body();
        Assert.assertEquals(response.statusCode(),200);

        //checking the data after update
        Response responseAfterUpdate=UserEndpointTest.readUser(this.userPayload.getUsername());
        Assert.assertEquals(responseAfterUpdate.statusCode(),200);
    }


    @Test (priority = 4)
    public void testDELETEUser() {
        Response response=UserEndpointTest.deleteUser(this.userPayload.getUsername());
        response.then().log().body();
        Assert.assertEquals(response.statusCode(),200);
    }
}
