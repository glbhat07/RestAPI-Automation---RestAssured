package APITests;

import APITests.POSTAPITest;
import Util.UtilHelpers;
import Util.Utilities;
import com.google.gson.JsonObject;
import files.APITest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PUTAPITest {

    String objectId;

    @Test()
    public void putApiTest() {
        objectId = POSTAPITest.ApiTest();
        String formattedDate = Utilities.getDate("YYYY-MM-DD");
        String URL = APITest.putURL.replace("{objectId}", objectId);

        Response response = UtilHelpers.putApi(URL, getPayload().toString());

        Assert.assertTrue(response.getStatusCode() == 200);
        Assert.assertNotNull(response.body().path("updatedAt"));
        Assert.assertTrue(response.body().path("updatedAt").toString().contains(formattedDate));
        Assert.assertTrue(response.getBody().path("name").equals("Apple MacBook Pro 16"));


    }


    public JsonObject getPayload() {
        JsonObject payload = new JsonObject();
        payload.addProperty("name", "Apple MacBook Pro 16");
        payload.add("data", getData());

        return payload;
    }

    public JsonObject getData() {
        JsonObject data = new JsonObject();
        data.addProperty("Year", 2019);
        data.addProperty("price", 2049.99);
        data.addProperty("CPU model", "Intel Core i9");
        data.addProperty("Hard disk size", "1 TB");
        data.addProperty("color", "silver");

        return data;
    }

}
