package starter.dummyjson.StepDef.Users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.UserApi;

import static org.hamcrest.core.StringContains.containsString;

public class DeleteUserStepDef {
    @Steps
    UserApi userApi;
    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidId(int id) {
        userApi.deleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(UserApi.DELETE_USER);
    }

    @Given("Delete user with invalid id {string}")
    public void deleteUserWithInvalidId(String id) {
        userApi.deleteUser(id);
    }

}
