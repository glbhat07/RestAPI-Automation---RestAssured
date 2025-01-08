package Util;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;

import java.util.HashMap;

public class UtilHelpers {

    public static Response getApi(String url) {
        try {
            return RestAssured.given().header(getHeader()).get(url).then().log().all().extract().response();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Response getApi(String url, HashMap<String, String> queryParams) {
        try {
            return RestAssured.given().header(getHeader()).queryParams(queryParams).get(url).then().log().all().extract().response();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Response postApi(String url, String body) {
        try {
            return RestAssured.given().header(getHeader()).body(body).post(url).then().log().all().extract().response();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Response putApi(String url, String body) {
        try {
            return RestAssured.given().header(getHeader()).body(body).put(url).then().log().all().extract().response();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Response patchApi(String url, String body) {
        try {
            return RestAssured.given().header(getHeader()).body(body).patch(url).then().log().all().extract().response();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Response deleteApi(String url) {
        try {
            return RestAssured.given().header(getHeader()).delete(url).then().log().all().extract().response();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Header getHeader() {
        Header header = new Header("Content-Type", "application/json");
        return header;
    }

}
