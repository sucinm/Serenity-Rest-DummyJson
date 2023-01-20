package starter.dummyjson;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.dummyjson.Utils.Constant;

import java.io.File;

public class CommentsApi {
    public static String POST_COMMENTS = Constant.BASE_URL + "/comments/add";
    public static String PUT_COMMENTS = Constant.BASE_URL + "/comments/{id}";
    public static String DELETE_SINGLE_COMMENTS = Constant.BASE_URL + "/comments/{id}";
    public static String GET_COMMENTS = Constant.BASE_URL + "/comments/post/{id}";
    public static String INVALID_GET_COMMENTS = Constant.BASE_URL + "/comments/post/{invalidId}";
    public static String INVALID_POST_COMMENTS = Constant.BASE_URL + "/commentsss/add";
    public static String INVALID_DELETE_COMMENTS = Constant.BASE_URL + "/comments?limit={limit}&skip={skip}&select=body,postId'";
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
    @Step("Delete comments with filter")
    public void deleteCommentsWithFilter(int limit, int skip){
        SerenityRest.given()
                .pathParam("limit", limit)
                .pathParam("skip", skip);
    }
    @Step("Get single comment")
    public void getSingleComment(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }
    @Step("Get single comment with invalid")
    public void getSingleCommentWithInvalidId(String invalidId){
        SerenityRest.given()
                .pathParam("invalidId", invalidId);
    }
    @Step("Put update comment")
    public void putUpdateComment(int id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post new comment")
    public void postNewComment(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
