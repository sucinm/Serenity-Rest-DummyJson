package starter.dummyjson;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.dummyjson.Utils.Constant;

import java.io.File;

public class UserApi {
    public static String GET_SINGLE_USER = Constant.BASE_URL + "/users/{id}";
    public static String POST_USER = Constant.BASE_URL + "/users/add";
    public static String PUT_USER = Constant.BASE_URL + "/users/{id}";
    public static String DELETE_USER = Constant.BASE_URL + "/users/{id}";

    @Step("Get single with valid id")
    public void getSingleUser(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Get single with invalid id")
    public void getSingleUser(String id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Post user")
    public void postUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put user product")
    public void putUser(int id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete product with valid id")
    public void deleteProduct(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Delete product with invalid id")
    public void deleteProduct(String id) {
        SerenityRest.given()
                .pathParam("id", id);
    }
}
