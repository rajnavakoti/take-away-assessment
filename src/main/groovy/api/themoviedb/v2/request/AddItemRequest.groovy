package api.themoviedb.v2.request

import api.basic.Post
import io.qameta.allure.Step
import io.restassured.response.ValidatableResponse
import org.testng.Assert
import utils.configuration.Config
import api.themoviedb.v2.theMovieDbEndPoints

/***
 * function calls on add item api Request
 */
class AddItemRequest {
    static Map headers = [:]
    static ValidatableResponse response

    @Step("Add item api request")
    static def addItemsToList(String jsonBody, String itemId){
        headers.put("Content-Type", Config.getTheMovieDbApiContentType())
        headers.put("Authorization", "Bearer "+ Config.getTheMovieDbCreateToken())
        println(theMovieDbEndPoints.EP_LIST + "/" + itemId + "/items")
        response =  Post.makeRequest(theMovieDbEndPoints.EP_LIST + "/" + itemId + "/items",headers,jsonBody)
        println(response.extract().response().path("status_code").toString())
        return response }

    @Step("Assert status code, status message and success flag")
    static def assertSuccessResponse(ValidatableResponse response, String statusCode,String statusMessage,String successFlag){
        Assert.assertTrue(response.extract().response().path("status_code").toString().equalsIgnoreCase(statusCode))
        Assert.assertTrue(response.extract().response().path("status_message").toString().equalsIgnoreCase(statusMessage))
        Assert.assertTrue(response.extract().response().path("success").toString().equalsIgnoreCase(successFlag)) }
}
