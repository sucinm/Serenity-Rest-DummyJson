package starter.dummyjson;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.dummyjson.Utils.Constant;

import java.io.File;

public class DummyJsonApi {
    public static String POST_ADD_PRODUCT = Constant.BASE_URL + "/products?add";
    public static String PUT_UPDATE_PRODUCT = Constant.BASE_URL + "/products/{id}";
    public static String PATCH_UPDATE_PRODUCT = Constant.BASE_URL + "/products/{id}";
    public static String DELETE_PRODUCT = Constant.BASE_URL + "/products/{id}";
    public static String GET_LIST_PRODUCT = Constant.BASE_URL + "/auth/products";

    @Step("Put update product with invalid url")
    public void putUpdateProduct(int id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

}
