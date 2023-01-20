package starter.dummyjson.StepDef.Carts;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.CartApi;
import starter.dummyjson.Utils.Constant;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteCartStepDef {
    @Steps
    CartApi cartApi;


    @Then("Should return code {int}")
    public void shouldReturnCode(int code) {
        SerenityRest.then().statusCode(code);
    }


    @Given("Delete a cart with valid id {int}")
    public void deleteACartWithValidId(int id) {
        cartApi.deleteCarts(id);
    }

    @And("Response body id should be {int}")
    public void responseBodyIdShouldBe(int id) {
        SerenityRest.then().body("id", equalTo(id));
    }

    @And("Validate schema delete a cart")
    public void validateSchemaDeleteACart() {
        File jsonSchema=new File(Constant.JSON_SCHEMA+"/Carts/GetSingleCarts.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.
                matchesJsonSchema(jsonSchema));
    }

    @Given("Delete a cart with invalid id {int}")
    public void deleteACartWithInvalidId(int id) {
        cartApi.deleteCarts(id);
    }

    @When("Send request delete a cart")
    public void sendRequestDeleteACart() {
        SerenityRest.when().delete(CartApi.DELETE_CART);
    }

    @And("Validate schema delete a cart invalid id")
    public void validateSchemaDeleteACartInvalidId() {
        File jsonSchema=new File(Constant.JSON_SCHEMA+"/Carts/DeleteCartsInvalidId.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.
                matchesJsonSchema(jsonSchema));

    }
}
