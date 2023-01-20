package starter.dummyjson.StepDef.Users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.DummyjsonResponses;
import starter.dummyjson.UserApi;
import starter.dummyjson.Utils.Constant;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PostUserStepDef {
    @Steps
    UserApi userApi;
    @Given("Add user with valid json")
    public void addUserWithValidJson() {
        File json = new File(Constant.JSON_REQUEST + "/Users/RequestUser.json");
        userApi.postUser(json);
    }

    @When("Post user request")
    public void postUserRequest() {
        SerenityRest.when().post(UserApi.POST_USER);
    }

    @And("Response body should contain {string} as firstName and {string} as lastName")
    public void responseBodyShouldContainAsFirstNameAndAsLastName(String firstName, String lastName) {
        SerenityRest.then()
                .body(DummyjsonResponses.FIRST_NAME, equalTo(firstName))
                .body(DummyjsonResponses.LAST_NAME, equalTo(lastName));
    }

    @And("Validate json schema success add user")
    public void validateJsonSchemaSuccessAddUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/Users/SuccessfulPostUser.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Add user without json")
    public void addUserWithoutJson() {
        SerenityRest.given();
    }

}
