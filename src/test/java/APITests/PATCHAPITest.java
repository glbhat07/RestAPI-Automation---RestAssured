package APITests;

import Util.UtilHelpers;
import Util.Utilities;
import com.google.gson.JsonObject;
import files.APITest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PATCHAPITest extends POSTAPITest{
    String objectId;

    @Test(dependsOnMethods = "POSTAPITest.postApiTest")
    public void patchApiTest() {
        objectId = POSTAPITest.ApiTest();
        String formattedDate = Utilities.getDate("YYYY-MM-DD");
        String URL = APITest.patchURL.replace("{objectId}", objectId);

        System.out.println("URL>>>>>" + URL);

        Response response = UtilHelpers.patchApi(URL, getPayloads().toString());

        Assert.assertTrue(response.getStatusCode() == 200);
        Assert.assertNotNull(response.body().path("updatedAt"));
        Assert.assertTrue(response.body().path("updatedAt").toString().contains(formattedDate));
        Assert.assertTrue(response.getBody().path("name").equals(getPayload().get("name").getAsString()));
    }


    public JsonObject getPayloads() {
        JsonObject payload = new JsonObject();
        payload.addProperty("name", "Apple MacBook Pro 16 (Updated Name)");

        return payload;
    }


}
