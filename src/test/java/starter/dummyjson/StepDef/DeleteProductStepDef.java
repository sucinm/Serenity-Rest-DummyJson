package starter.dummyjson.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.DummyJsonApi;

public class DeleteProductStepDef {
    @Steps
    DummyJsonApi dummyJsonApi;

    @Given("Delete product with valid id <id>")
    public void deleteProductWithValidIdId() {
    }

    @When("Send request delete product")
    public void sendRequestDeleteProduct() {
    }

    @Then("Should return status code {int}")
    public void shouldReturnStatusCode(int arg0) {
    }

    @And("Validate json schema delete product")
    public void validateJsonSchemaDeleteProduct() {
    }
}
