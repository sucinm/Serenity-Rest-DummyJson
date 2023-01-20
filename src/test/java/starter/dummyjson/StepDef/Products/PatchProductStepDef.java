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

public class PatchProductStepDef {
    @Steps
    ProductsApi productsApi;
    @Given("Patch update product with valid JSON and {int} as valid Id product")
    public void patchUpdateProductWithValidJSONAndIdAsValidIdProduct(int id) {
        File jsonRequest = new File(Constant.JSON_REQUEST + "/Products/RequestPatchProduct.json");
        productsApi.patchUpdateProduct(id, jsonRequest);
    }

    @When("Send request patch update product")
    public void sendRequestPatchUpdateProduct() {
        SerenityRest.when().patch(ProductsApi.PATCH_UPDATE_PRODUCT);
    }

    @And("Response body should be {int} as price and {int} as stock")
    public void responseBodyShouldBePriceAsPriceAndStockAsStock(int price, int stock) {
        SerenityRest.then()
                .body(DummyjsonResponses.PRICE, equalTo(price))
                .body(DummyjsonResponses.STOCK, equalTo(stock));
    }

    @And("Validate json schema update products")
    public void validateJsonSchemaUpdateProducts() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/Products/SuccessfulUpdateProduct.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Patch update product with invalid JSON and {int} as valid Id product")
    public void patchUpdateProductWithInvalidJSONAndAsValidIdProduct(int id) {
        File jsonRequest = new File(Constant.JSON_REQUEST + "/Products/InvalidRequestPatchProduct.json");
        productsApi.patchUpdateProduct(id, jsonRequest);
    }
}
