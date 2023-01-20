package starter.dummyjson.StepDef.Products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.DummyjsonResponses;
import starter.dummyjson.ProductsApi;
import starter.dummyjson.Utils.Constant;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.StringContains.containsString;

public class PutProductStepDef {
    @Steps
    ProductsApi productsApi;

    @Given("Update product with {int} as id and valid JSON")
    public void updateProductWithAsIdAndValidJSON(int id) {
        File jsonRequest = new File(Constant.JSON_REQUEST + "/Products/RequestUpdateProduct.json");
        productsApi.putUpdateProduct(id, jsonRequest);
    }

    @When("Send request put update product")
    public void sendRequestPutUpdateProduct() {
        SerenityRest.when().put(ProductsApi.PUT_UPDATE_PRODUCT);
    }

    @And("Response body id {int}")
    public void responseBodyId(int id) {
        SerenityRest.then()
                .assertThat()
                .body(DummyjsonResponses.ID, equalTo(id));
    }

    @And("Validate json schema success update product")
    public void validateJsonSchemaSuccessUpdateProduct() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/Products/SuccessfulUpdateProduct.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @When("Send request put update product with {string} as invalid base url")
    public void sendRequestPutUpdateProductWithAsInvalidBaseUrl(String baseUrl) {
        SerenityRest.when()
                .put(ProductsApi.PUT_UPDATE_PRODUCT.replace(Constant.BASE_URL, baseUrl));
    }

    @And("Response body message {string}")
    public void responseBodyError(String errorMessage) {
        SerenityRest.then()
                .assertThat()
                .body(DummyjsonResponses.ERRORMESSAGE, containsString(errorMessage));
    }

    @And("Validate json schema failed update product")
    public void validateJsonSchemaFailedUpdateProduct() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/Products/FailedUpdateProduct.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }


}
