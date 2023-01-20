package starter.dummyjson;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.dummyjson.Utils.Constant;

public class CommentsApi {
    public static String POST_COMMENTS = Constant.BASE_URL + "/comments/add";
    public static String PUT_COMMENTS = Constant.BASE_URL + "/comments/{id}";
    public static String DELETE_SINGLE_COMMENTS = Constant.BASE_URL + "/comments/{id}";
    public static String GET_COMMENTS = Constant.BASE_URL + "/comments/post/{id}";
    public static String INVALID_POST_COMMENTS = Constant.BASE_URL + "/commentsss/add";
    public static String INVALID_DELETE_COMMENTS = Constant.BASE_URL + "/comments?limit=10&skip=10&select=body,postId'";
    public static String INVALID_DELETE_SINGLE_COMMENTS = Constant.BASE_URL + "/comments/{invalidId}";

    @Step("Delete single comment")
    public void deleteSingleComment(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }
    @Step("Delete single comment with invalid id")
    public void deleteSingleCommentWithInvalidId(String invalidId){
        SerenityRest.given()
                .pathParam("invalidId",invalidId);
    }
}
