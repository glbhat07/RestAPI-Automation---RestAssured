package APITests;

import Util.UtilHelpers;
import files.APITest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class GETAPITest{
    static String objectId;

    @Test(priority = 0)
    public static void testGetAPI() {
        objectId = POSTAPITest.ApiTest();

        String url = APITest.getURL1;
        Response response = UtilHelpers.getApi(url);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(response);
    }


    @Test(priority = 2)
    public static void testGetAPIWithPathParams() {
        objectId = POSTAPITest.ApiTest();

        String url = APITest.getURL2.replace("{objectId}", objectId);
        Response response = UtilHelpers.getApi(url);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.body().path("data"));
        Assert.assertTrue(response.body().path("id").toString().contains(objectId));
    }

    @Test(priority = 1)
    public static void testGetAPIWithQueryParams() {
        objectId = POSTAPITest.ApiTest();

        String url = APITest.getURL1;
        HashMap<String, String> queryParams = getQueryParams();
        Response response = UtilHelpers.getApi(url, queryParams);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.body().path("data"));
        Assert.assertTrue(response.body().path("id").toString().contains(objectId));
    }

    public static HashMap<String, String> getQueryParams() {
        HashMap<String, String> queryParams = new HashMap();
        queryParams.put("id", objectId);
        return queryParams;
    }



}
