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

public class GetCartsOfUserStepDef {
    @Steps
    CartApi cartApi;

    @Given("Get cart of user with valid id {int}")
    public void getCartOfUserWithValidId(int id) {
        cartApi.getCartOfUser(id);
    }

    @When("Send request get cart of user")
    public void sendRequestGetSingleCart() {
        SerenityRest.when().get(CartApi.GET_CART_OF_USER);
    }



    @And("Validate json schema get cart of user")
    public void validateJsonSchemaGetCartOfUser()
    {
        File jsonSchema=new File(Constant.JSON_SCHEMA+"/Carts/GetCartsOfUserValidSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.
                matchesJsonSchema(jsonSchema));
    }



    @Given("Get cart of user with invalid id {int}")
    public void getCartOfUserWithInvalidId(int id) {
        cartApi.getCartOfUser(id);
    }

    @And("Validate json schema get cart of user Invalid Schema")
    public void validateJsonSchemaGetCartOfUserInvalidSchema() {
        File jsonSchema=new File(Constant.JSON_SCHEMA+"/Carts/GetCartsOfUserInvalidSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.
                matchesJsonSchema(jsonSchema));
    }

}
