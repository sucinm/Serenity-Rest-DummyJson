package starter.dummyjson.StepDef.Todos;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.TodosAPI;
import starter.dummyjson.Utils.Constant;

import java.io.File;

public class GetTodosStepDef {
    @Steps
    TodosAPI todosAPI;

    @Given("Get single todos with valid id {int}")
    public void getSingleTodosWithValidId(int id) {
        todosAPI.getSingleTodosValidId(id);
    }

    @When("Send request get single todos")
    public void sendRequestGetSingleTodos() {
        SerenityRest.when().get(TodosAPI.GET_SINGLE_TODOS);
    }

    @And("Validate JSON schema single todos")
    public void validateJSONSchemaSingleTodos() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/Todos/GetValidSingleTodos.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));

    }

    @Given("Get single todos with invalid id {string}")
    public void getSingleTodoWithInvalidId(String id) {
        todosAPI.getSingleTodos(id);
    }
}
