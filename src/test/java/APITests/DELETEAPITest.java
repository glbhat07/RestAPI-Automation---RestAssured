package APITests;

import Util.UtilHelpers;
import files.APITest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DELETEAPITest {

    String objectId;

    @Test()
    public void deleteApiTest() {
        objectId = POSTAPITest.ApiTest();
        String URL = APITest.deleteURL.replace("{objectId}", objectId);

        Response response = UtilHelpers.deleteApi(URL);

        Assert.assertTrue(response.getStatusCode() == 200);
        Assert.assertNotNull(response.body().path("message"));
        Assert.assertTrue(response.body().path("message").toString().contains("deleted"));
    }
}
