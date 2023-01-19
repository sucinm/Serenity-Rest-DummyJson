package starter.dummyjson;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.dummyjson.Utils.Constant;

import java.io.File;

public class ProductsApi {
    public static String POST_ADD_PRODUCT = Constant.BASE_URL + "/products/add";
    public static String PUT_UPDATE_PRODUCT = Constant.BASE_URL + "/products/{id}";
    public static String PATCH_UPDATE_PRODUCT = Constant.BASE_URL + "/products/{id}";
    public static String DELETE_PRODUCT = Constant.BASE_URL + "/products/{id}";
    public static String GET_LIST_PRODUCT = Constant.BASE_URL + "/auth/products";

    @Step("Get list product with authorization")
    public void getListProduct(String token) {
        SerenityRest.given()
                .header("Authorization", "Bearer" + token);
    }

    @Step("Post product")
    public void postProduct(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update product")
    public void putUpdateProduct(int id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Patch update product")
    public void patchUpdateProduct(int id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete product")
    public void deleteProduct(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }
}
