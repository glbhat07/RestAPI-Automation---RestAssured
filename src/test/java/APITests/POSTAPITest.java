package APITests;

import Util.UtilHelpers;
import Util.Utilities;
import com.google.gson.JsonObject;
import files.APITest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class POSTAPITest {
    @Test
    public void postApiTest() {
        String createdObjectId = ApiTest();
        Assert.assertNotNull(createdObjectId);
    }

    public static String ApiTest() {
        String URL = APITest.postURL;
        System.out.println("PAYLOAD>>>" + getPayload());

        String formattedDate = Utilities.getDate("YYYY-MM");

        Response response = UtilHelpers.postApi(URL, getPayload().toString());
        Assert.assertTrue(response.getStatusCode() == 200);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.body().path("createdAt"));
        Assert.assertTrue(response.body().path("createdAt").toString().contains(formattedDate));
        Assert.assertEquals(response.body().path("name").toString(), getPayload().get("name").getAsString());

        return response.getBody().path("id");


    }

    public static JsonObject getPayload() {
        JsonObject payload = new JsonObject();
        payload.addProperty("name", "Apple MacBook Pro 16");
        payload.add("data", getData());

        return payload;
    }

    public static JsonObject getData() {
        JsonObject data = new JsonObject();
        data.addProperty("Year", 2019);
        data.addProperty("price", 1849.99);
        data.addProperty("CPU model", "Intel Core i9");
        data.addProperty("Hard disk size", "1 TB");

        return data;
    }
}
