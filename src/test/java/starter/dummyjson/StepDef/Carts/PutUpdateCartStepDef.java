package starter.dummyjson.StepDef.Carts;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.CartApi;
import starter.dummyjson.Utils.Constant;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.StringContains.containsString;

public class PutUpdateCartStepDef {
    @Steps
    CartApi cartApi;

    @Given("Put update a cart with valid json and id {int}")
    public void putUpdateACartWithValidJson(int id) {
        File json= new File(Constant.JSON_REQUEST + "/Carts/PutUpdateCartsValid.json");
        cartApi.putUpdateACart(id, json);
    }

    @When("Send request put update a cart")
    public void sendRequestPutUpdateACart() {
        SerenityRest.when().put(CartApi.PUT_UPDATE_CART);
    }

    @And("Response body should be id {int}")
    public void responseBodyShouldBeIdId(int id) {
        SerenityRest.then().body("id", equalTo(id));
    }

    @And("Validate json schema put update cart")
    public void validateJsonSchemaPutUpdateACart() {
        File jsonSchema=new File(Constant.JSON_SCHEMA+"/Carts/PutUpdateCartsValidSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.
                matchesJsonSchema(jsonSchema));
    }

    @Given("Put update a cart with invalid json and id {int}")
    public void putUpdateACartWithInvalidJson(int id) {
        File json=new File(Constant.JSON_REQUEST+"/Carts/PutUpdateCartsInvalid.json");
        cartApi.putUpdateACart(id, json);
    }


    @And("Validate json schema put update cart invalid json")
    public void validateJsonSchemaPutUpdateACartInvalidJson() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/Carts/PutUpdateCartsInvalidSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.
                matchesJsonSchema(jsonSchema));
    }





}
