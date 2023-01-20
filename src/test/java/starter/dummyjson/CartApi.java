package starter.dummyjson;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.Utils.Constant;

import java.io.File;

public class CartApi {
    public static String POST_ADD_CART = Constant.BASE_URL + "/carts/add";
    public static String PUT_UPDATE_CART = Constant.BASE_URL + "/carts/{id}";
    public static String DELETE_CART = Constant.BASE_URL + "/carts/{id}";

    public static String GET_SINGLE_CART = Constant.BASE_URL + "/carts/{id}";

    public static String GET_CART_OF_USER = Constant.BASE_URL + "/carts/user/{id}";


    @Step("Get single cart with valid id")
    public void getSingleCart(int id) {
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Delete cart with id")
    public void deleteCarts(int id) {
        SerenityRest.given().pathParam("id", id);

    }

    @Step("Post cart")
    public void postCarts(int id, File json) {
        SerenityRest.given().pathParam("id", id).body(json).contentType(ContentType.JSON);

    }

    @Step("Post cart invalid")
    public void postCarts(File json) {
        SerenityRest.given().body(json).contentType(ContentType.JSON);
    }

    @Step("Put update a cart")
    public void putUpdateACart(int id,File json) {
        SerenityRest.given().pathParam("id", id).body(json).contentType(ContentType.JSON);
    }

    @Step("Get cart of user")
    public void getCartOfUser(int id) {
        SerenityRest.given().pathParam("id", id);

    }
}
