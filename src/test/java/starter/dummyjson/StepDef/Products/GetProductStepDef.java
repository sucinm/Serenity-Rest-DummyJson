package starter.dummyjson.StepDef.Products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.ProductsApi;
import starter.dummyjson.Utils.Authorization;
import starter.dummyjson.Utils.Constant;

import java.io.File;

public class GetProductStepDef {
    @Steps
    ProductsApi productsApi;
    Authorization auth = new Authorization();

    @Given("Get list product with valid token")
    public void getListProductWithValidToken() {
        productsApi.getListProduct(auth.getToken());
    }

    @Given("Get list product with expired token")
    public void getListProductWithExpiredToken() {
        productsApi.getListProduct("");
    }

    @When("Send request get list product")
    public void sendRequestGetListProduct() {
        SerenityRest.when().get(ProductsApi.GET_LIST_PRODUCT);
    }

    @And("Validate json schema list product")
    public void validateJsonSchemaListProduct() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/ListProduct.json");
    }

    @Then("Should return status code {int}")
    public void shouldReturnStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }
}
