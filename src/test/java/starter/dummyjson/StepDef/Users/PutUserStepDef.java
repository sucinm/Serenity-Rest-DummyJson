package starter.dummyjson.StepDef.Users;

import com.sun.xml.bind.v2.runtime.reflect.opt.Const;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.UserApi;
import starter.dummyjson.Utils.Constant;

import java.io.File;

public class PutUserStepDef {
    @Steps
    UserApi userApi;

    @Given("Update user with {int} as id and valid JSON")
    public void updateUserWithAsIdAndValidJSON(int id) {
        File json = new File(Constant.JSON_REQUEST + "/Users/RequestUser.json");
        userApi.putUser(id, json);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(UserApi.PUT_USER);
    }

    @And("Validate json schema success update user")
    public void validateJsonSchemaSuccessUpdateUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/Users/SuccessfulPutUser.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @And("Validate json schema failed update user")
    public void validateJsonSchemaFailedUpdateUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/Users/FailedUpdateUser.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
