package starter.dummyjson.StepDef.Auth;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.AuthApi;
import starter.dummyjson.Utils.Constant;

import java.io.File;

public class LoginStepDef {
    @Steps
    AuthApi authApi;
    @Given("Login with valid JSON")
    public void loginWithValidJSON() {
        File jsonRequest = new File(Constant.JSON_REQUEST + "/Auth/RequestLogin.json");
        authApi.postLogin(jsonRequest);
    }

    @When("Send request post to login")
    public void sendRequestPostToLogin() {
        SerenityRest.when().post(AuthApi.POST_LOGIN);
    }

    @And("Validate json schema success login")
    public void validateJsonSchemaSuccessLogin() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/Auth/SuccessfulLogin.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Login with invalid JSON")
    public void loginWithInvalidJSON() {
        File jsonRequest = new File(Constant.JSON_REQUEST + "/Auth/InvalidRequestLogin.json");
        authApi.postLogin(jsonRequest);
    }

    @And("Validate json schema failed login")
    public void validateJsonSchemaFailedLogin() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/Auth/FailedLogin.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
