package api.test;

import api.endpoints.UserEndpointTest;
import api.payload.User;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import api.utilities.DataProviders;

public class DataDrivenTest {

    //data provider will send the data and will have to recieve the data too.

    @Test(priority = 1, dataProvider="Data", dataProviderClass = DataProviders.class)
    public void testPostUser(String userID, String userName, String fname, String lname, String useremail, String pwd, String ph ) throws InterruptedException{

        User userPayload=new User();

        userPayload.setId(Integer.parseInt(userID));
        userPayload.setUsername(userName);
        userPayload.setFirstname(fname);
        userPayload.setLastname(lname);
        userPayload.setEmail(useremail);
        userPayload.setPassword(pwd);
        userPayload.setPhone(ph);

        Response response= UserEndpointTest.createUser(userPayload);
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
    public void testDeleteUser(String userName) {

        Response response=UserEndpointTest.deleteUser(userName);
        Assert.assertEquals(response.statusCode(),200);
    }
}
