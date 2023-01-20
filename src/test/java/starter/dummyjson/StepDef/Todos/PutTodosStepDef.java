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

import static org.hamcrest.CoreMatchers.equalTo;

public class PutTodosStepDef {
    @Steps
    TodosAPI todosAPI;
    @Given("Put update todos with valid JSON and as {int} valid id todos")
    public void putUpdateTodosWithValidJSONAndAsValidIdTodos(int id) {
        File json = new File(Constant.JSON_REQUEST+"/Todos/PutUpdateTodos.json");
        todosAPI.putTodos(id, json);
    }

    @When("Send request put update todo and completed")
    public void requestPutUpdateTodoAndCompleted() {
        SerenityRest.when().put(TodosAPI.PUT_TODOS);
    }

    @And("Response body name should be todo {string}")
    public void responseBodyNameShouldBeTodosAndCompleted(String todo) {
        SerenityRest.then()
                .body("todo",equalTo(todo));
    }

    @And("Validate JSON schema update todos")
    public void validateJSONSchemaUpdateTodos() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/Todos/PutTodos.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));

    }

    @Given("Put update todo with invalid JSON and {int} as valid id todos")
    public void putUpdateTodoWithInvalidJSONAndAsValidIdTodos(int id) {
        File json = new File(Constant.JSON_REQUEST+"/Todos/InvalidPutTodos.json");
        todosAPI.putTodosInvalidJson(id, json);
    }
}
