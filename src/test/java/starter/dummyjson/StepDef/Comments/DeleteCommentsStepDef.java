package starter.dummyjson.StepDef.Comments;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.CommentsApi;
import starter.dummyjson.DummyjsonResponses;
import starter.dummyjson.Utils.Constant;

import java.io.File;

import static org.hamcrest.Matchers.*;

public class DeleteCommentsStepDef {
    @Steps
    CommentsApi commentsApi;

    //Scenario Delete comment with valid id
    @Given("Delete comment with id {int}")
    public void deleteCommentWithId(int id) {
        commentsApi.deleteSingleComment(id);
    }

    @When("send request delete comment")
    public void sendRequestDeleteComment() {
        SerenityRest.when().delete(CommentsApi.DELETE_SINGLE_COMMENTS);
    }

    @Then("API should return status code {int}")
    public void apiShouldReturnStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("response body id should be {int} and user ID {int}, and Username {string}")
    public void responseBodyIdShouldBeAndIsDeleted(int id, int userID, String userName) {
        SerenityRest.then()
                .body(DummyjsonResponses.ID, equalTo(id))
                .body(DummyjsonResponses.USER_ID, equalTo(userID))
                .body(DummyjsonResponses.USERNAME, equalTo(userName));
    }

    @And("validate json schema success delete comments")
    public void validateJsonSchemaSuccessDeleteComments() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/Comments/SuccessDeleteSingleComment.json");
        SerenityRest.then()
                .assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Scenario Delete comment with invalid id
    @Given("Delete comment with id {string}")
    public void deleteCommentWithId(String id) {
        commentsApi.deleteSingleCommentWithInvalidId(id);
    }

    @When("send invalid request delete comment")
    public void sendInvalidRequestDeleteComment() {
        SerenityRest.when().delete(CommentsApi.INVALID_DELETE_SINGLE_COMMENTS);
    }

    @And("response body error should be {string}")
    public void responseBodyErrorShouldBe(String errorMessage) {
        SerenityRest.then()
                .body(DummyjsonResponses.ERRORMESSAGE, equalTo(errorMessage));
    }

    @And("validate json schema failed delete comments")
    public void validateJsonSchemaFailedDeleteComments() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/Comments/FailedDeleteSingleComment.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Scenario Delete comments with filter
    @Given("Delete comments with limit {int} and skip {int}")
    public void deleteCommentsWithLimitAndSkip(int limit, int skip) {
        commentsApi.deleteCommentsWithFilter(limit, skip);
    }

    @When("send request delete comment with filter")
    public void sendRequestDeleteCommentWithFilter() {
        SerenityRest.when().delete(CommentsApi.INVALID_DELETE_COMMENTS);
    }
}
