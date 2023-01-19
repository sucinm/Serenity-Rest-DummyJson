package starter.dummyjson.StepDef.Products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.ProductsApi;

public class DeleteProductStepDef {
    @Steps
    ProductsApi productsApi;

    @Given("Delete product with id {int}")
    public void deleteProductWithId(int id) {
        productsApi.deleteProduct(id);
    }

    @When("Send request delete product")
    public void sendRequestDeleteProduct() {
        SerenityRest.when().delete(ProductsApi.DELETE_PRODUCT);
    }

}
