package starter.dummyjson;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.Utils.Constant;

import java.io.File;

public class TodosAPI {
    public static String GET_SINGLE_TODOS = Constant.BASE_URL + "/todos/{id}";
    public static String POST_TODOS = Constant.BASE_URL + "/todos/add";
    public static String PUT_TODOS = Constant.BASE_URL + "/todos/{id}";
    public static String DELETE_TODOS = Constant.BASE_URL + "/todos/{id}";

    @Step("Get single todos with invalid id")
    public void getSingleTodos(String id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step("Get single todos with valid id")
    public void getSingleTodosValidId(int id) {
        SerenityRest.given().pathParam("id",id);
    }

    @Step("Delete todos with invalid id")
    public void deleteTodosValidId(int id) {
        SerenityRest.given().pathParam("id",id);
    }

    @Step("Delete todos with unavalaible id")
    public void deleteTodosUnavalaibleId(String id) {
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Post todos with JSON")
    public void postTodos(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @Step("Put todos with JSON")
    public void putTodos(int id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put todos with invalid JSON")
    public void putTodosInvalidJson (int id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON).body(json);
    }




}
