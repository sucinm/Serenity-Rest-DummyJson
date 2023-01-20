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

public class PostAddNewCartStepDef {
    @Steps
    CartApi cartApi;


    @When("Send request post add new cart")
    public void sendRequestPostAddNewCart() {
        SerenityRest.when().post(CartApi.POST_ADD_CART);
    }

    @And("Response body user id should be {int}")
    public void responseBodyUserIdShouldBe(int userId) {
        SerenityRest.then().body("userId",equalTo(userId));
    }

    @And("Validate json schema post add cart")
    public void validateJsonSchemaPostAddCart() {
        File jsonSchema=new File(Constant.JSON_SCHEMA+"/Carts/PostAddNewCartsValidSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.
                matchesJsonSchema(jsonSchema));
    }

    @Given("Post add new cart with invalid json")
    public void postAddNewCartWithInvalidJson() {
        File json=new File(Constant.JSON_REQUEST+"/Carts/PostAddNewCartsInvalid.json");
        cartApi.postCarts(json);

    }


    @Given("Post add new cart with valid json and valid user id {int}")
    public void postAddNewCartWithValidJsonAndValidUserId(int id) {
        File json=new File(Constant.JSON_REQUEST+"/Carts/PostAddNewCartsValid.json");
        cartApi.postCarts(id,json);
        //SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
