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

public class DeleteTodosStepDef {
    @Steps
    TodosAPI todosAPI;
    @Given("Given Delete todos with valid id {int}")
    public void givenDeleteTodoWithValidId(int id) {
        todosAPI.deleteTodosValidId(id);
    }

    @When("Send request delete todos")
    public void sendRequestDeleteTodo() {
        SerenityRest.when().delete(TodosAPI.DELETE_TODOS);
    }

    @And("Validate JSON schema Success delete todos")
    public void validateJSONSchemaSuccessDeleteTodo() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/Todos/SuccessfulDeleteTodos.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Delete todos with unavailable id {string}")
    public void deleteTodoWithUnavailableId(String id) {
        todosAPI.getSingleTodos(id);
    }

    @And("Validate json schema failed delete todos")
    public void validateJsonSchemaFailedDeleteTodo() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/Todos/FailedDeleteTodos.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
