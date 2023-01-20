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

import static org.hamcrest.Matchers.equalTo;

public class PostProductStepDef {
    @Steps
    ProductsApi productsApi;

    @Given("Add products with valid json")
    public void addProductsWithValidJson() {
        File jsonRequest = new File(Constant.JSON_REQUEST + "/Products/RequestPostProduct.json");
        productsApi.postProduct(jsonRequest);
    }

    @When("Post products request")
    public void postProductsRequest() {
        SerenityRest.when().post(ProductsApi.POST_ADD_PRODUCT);
    }

    @And("Response body should contain {string}")
    public void responseBodyShouldContain(String title) {
        SerenityRest.then()
                .body(DummyjsonResponses.TITLE, equalTo(title));
    }

    @And("Validate json schema success add products")
    public void validateJsonSchemaSuccessAddProducts() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/Products/SuccessfulPostProduct.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
