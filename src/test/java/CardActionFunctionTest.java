import Common.FetchAPIResponse;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;


import java.io.IOException;



public class CardActionFunctionTest extends FetchAPIResponse {


    JSONParser parser=new JSONParser();

    JSONObject requestParams =new JSONObject();

    @Test
    public void addCardFn() throws ParseException, IOException {

        Response response = addCardMethod("12345");
        parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(response.body().asString());
        System.out.println(jsonObject.get("desc"));
    }

    @Test
    public void getOTPFn() throws ParseException, IOException {

        Response response = getOTPMethod("9482848937");
        parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(response.body().asString());

        System.out.println(jsonObject.get("desc"));
    }

}
