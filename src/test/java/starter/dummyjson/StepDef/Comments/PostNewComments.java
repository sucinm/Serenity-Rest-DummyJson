package starter.dummyjson.StepDef.Comments;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.CommentsApi;
import starter.dummyjson.Utils.Constant;

import java.io.File;

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
}
