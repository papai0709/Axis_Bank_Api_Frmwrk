package Common;

import groovy.json.JsonParser;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
//import org.json.simple.parser.JSONParser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Scanner;



public class FetchAPIResponse {
    Properties prop = new Properties();
    JSONParser parser=new JSONParser();
    Constants cnt = new Constants();
    Response response;


    public Response addCardMethod(String cardNO) throws IOException, ParseException {
        Reader reader=new FileReader(cnt.ADDCARD_REQUESTBODY);
        prop.load(Files.newInputStream(Paths.get("/Users/Jayabrata/IdeaProjects/Axis_Bank_Api_Frmwrk/src/main/resources/API_URL.properties")));
        JSONObject jsonObject=(JSONObject)parser.parse(reader);
        RestAssured.baseURI=prop.getProperty("addCardUrl")+cardNO;
        RequestSpecification requestSpecification=RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON);
        RestAssured.given().header("x-checksum", "9vQ52JNHbvU/kHnRRVsltS5QnTDgLjnuuvfBeNtVNMo=");
        response =  requestSpecification.relaxedHTTPSValidation().body(jsonObject.toJSONString()).request(Method.POST);
        return response;
    }

    public Response getOTPMethod(String mobileNO) throws IOException, ParseException {
        Reader reader=new FileReader(cnt.GETOTP_REQUESTBODY);
        prop.load(Files.newInputStream(Paths.get("/Users/Jayabrata/IdeaProjects/Axis_Bank_Api_Frmwrk/src/main/resources/API_URL.properties")));
        JSONObject jsonObject=(JSONObject)parser.parse(reader);
        RestAssured.baseURI=prop.getProperty("getOtpReq")+mobileNO;
        RequestSpecification requestSpecification=RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON);
        RestAssured.given().contentType("application/json").accept("application/json");
        response =  requestSpecification.relaxedHTTPSValidation().body(jsonObject.toJSONString()).request(Method.POST);
        return response;
    }

}


