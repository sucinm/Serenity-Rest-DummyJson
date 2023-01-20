package starter.dummyjson.StepDef.Comments;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.CommentsApi;
import starter.dummyjson.DummyjsonResponses;
import starter.dummyjson.Utils.Constant;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PostNewComments {
    @Steps
    CommentsApi commentsApi;

    //Scenario Post add new comment with invalid path
    @Given("Post add new comment with valid json")
    public void postAddNewCommentWithValidJson() {
        File json = new File(Constant.JSON_REQUEST+"/Comments/RequestPostComment.json");
        commentsApi.postNewComment(json);
    }

    @When("send invalid request post comment")
    public void sendInvalidRequestPostComment() {
        SerenityRest.when().post(CommentsApi.INVALID_POST_COMMENTS);
    }

    //Scenario Post add new comment with valid path
    @When("send request post comment")
    public void sendRequestPostComment() {
        SerenityRest.when().post(CommentsApi.POST_COMMENTS);
    }

    @And("response body post ID should be {int}, user ID {int}, and body {string}")
    public void responseBodyPostIDShouldBeUserIDAndBody(int postID, int userID, String body) {
        SerenityRest.then()
                .body(DummyjsonResponses.POST_ID, equalTo(postID))
                .body(DummyjsonResponses.USER_ID, equalTo(userID))
                .body(DummyjsonResponses.BODY, equalTo(body));
    }

    @And("validate json schema post comments")
    public void validateJsonSchemaPostComments() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/Comments/SuccessPostNewComment.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
