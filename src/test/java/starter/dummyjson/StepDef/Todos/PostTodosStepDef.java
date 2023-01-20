package starter.dummyjson.StepDef.Todos;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.TodosAPI;
import starter.dummyjson.Utils.Constant;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class PostTodosStepDef {
    @Steps
    TodosAPI todosAPI;

    @Given("Post add new todo with valid JSON")
    public void postAddNewTodoWithValidJSON() {
        File json = new File(Constant.JSON_REQUEST+"/Todos/RequestPostTodos.json");
        todosAPI.postTodos(json);
    }

    @When("Send request post add new todo")
    public void sendRequestPostAddNewTodo() {
        SerenityRest.when().post(TodosAPI.POST_TODOS);
    }

    @And("Response body name should be id {int}")
    public void responseBodyNameShouldBeId(int id) {
        SerenityRest.then().body("id",equalTo(id));
    }

    @And("Validate JSON schema success add new todo")
    public void validateJSONSchemaSuccessAddNewTodo() {
        File jsonSchema =new File(Constant.JSON_SCHEMA+"/Todos/SuccessfulAddTodos.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Post add new todo invalid JSON")
    public void postAddNewTodoInvalidJSON() {
        File jsonInvalid = new File(Constant.JSON_REQUEST+"/Todos/InvalidRequestPostTodos.json");
        todosAPI.postTodos(jsonInvalid);
    }

    @And("Validate JSON schema failed add new todo")
    public void validateJSONSchemaFailedAddNewTodo() {
        File jsonSchema =new File(Constant.JSON_SCHEMA+"/Todos/FailedAddTodos.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
