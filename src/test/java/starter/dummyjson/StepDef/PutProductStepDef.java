package starter.dummyjson.StepDef;

import com.sun.xml.bind.v2.runtime.reflect.opt.Const;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.DummyJsonApi;
import starter.dummyjson.Utils.Constant;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.StringContains.containsString;

public class PutProductStepDef {
    @Steps
    DummyJsonApi dummyJsonApi;

    @Given("Update product with {int} as valid id and valid JSON")
    public void updateProductWithAsValidIdAndValidJSON(int id) {
        File jsonRequest = new File(Constant.JSON_REQUEST + "/RequestUpdateProduct.json");
        dummyJsonApi.putUpdateProduct(id, jsonRequest);
    }

    @When("Send request put update product")
    public void sendRequestPutUpdateProduct() {
        SerenityRest.when().put(DummyJsonApi.PUT_UPDATE_PRODUCT);
    }

    @And("Response body id {int}")
    public void responseBodyId(int id) {
        SerenityRest.then()
                .assertThat()
                .body("id", equalTo(id));
    }

    @And("Validate json schema success update product")
    public void validateJsonSchemaSuccessUpdateProduct() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/SuccessfulUpdateProduct.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @When("Send request put update product with {string} as invalid base url")
    public void sendRequestPutUpdateProductWithAsInvalidBaseUrl(String baseUrl) {
        SerenityRest.when()
                .put(DummyJsonApi.PUT_UPDATE_PRODUCT.replace(Constant.BASE_URL, baseUrl));
    }

    @And("Response body message {string}")
    public void responseBodyError(String errorMessage) {
        SerenityRest.then()
                .assertThat()
                .body("message", containsString(errorMessage));
    }

    @And("Validate json schema failed update product")
    public void validateJsonSchemaFailedUpdateProduct() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/FailedUpdateProduct.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }


}
