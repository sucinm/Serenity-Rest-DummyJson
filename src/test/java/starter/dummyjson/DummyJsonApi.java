package starter.dummyjson;

import starter.dummyjson.Utils.Constant;

public class DummyJsonApi {
    public static String POST_ADD_PRODUCT = Constant.BASE_URL + "/products?add";
    public static String PUT_UPDATE_PRODUCT = Constant.BASE_URL + "/products/{id}";
    public static String PATCH_UPDATE_PRODUCT = Constant.BASE_URL + "/products/{id}";
    public static String DELETE_USER = Constant.BASE_URL + "/products/{id}";
    public static String GET_LIST_PRODUCT = Constant.BASE_URL + "/auth/products";
}
