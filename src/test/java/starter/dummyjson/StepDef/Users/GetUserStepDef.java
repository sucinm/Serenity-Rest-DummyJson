package starter.dummyjson.StepDef.Users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matcher;
import starter.dummyjson.UserApi;
import starter.dummyjson.Utils.Constant;

import java.io.File;

public class GetUserStepDef {
    @Steps
    UserApi userApi;

    @Given("Get single user with valid id {int}")
    public void getSingleUserWithValidId(int id) {
        userApi.getSingleUser(id);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(UserApi.GET_SINGLE_USER);
    }

    @And("Validate json schema single user")
    public void validateJsonSchemaSingleUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/Users/GetUsers.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get single user with invalid id {string}")
    public void getSingleUserWithInvalidId(String id) {
        userApi.getSingleUser(id);
    }

}
