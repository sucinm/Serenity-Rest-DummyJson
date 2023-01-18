package starter.dummyjson.Utils;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import starter.dummyjson.AuthApi;

import java.io.File;

public class Authorization {
    public String getToken(){
        File jsonRequest = new File(Constant.JSON_REQUEST + "/Auth/RequestLogin.json");
        Response response = SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(jsonRequest)
                .post(AuthApi.POST_LOGIN);

        // https://www.toolsqa.com/rest-assured/read-json-response-body-using-rest-assured/
        // First get the JsonPath object instance from the Response interface
        JsonPath jsonPathEvaluator = response.jsonPath();

        // Then simply query the JsonPath object to get a String value of the node
        String token = jsonPathEvaluator.get("token");
        return token;
    }
}
