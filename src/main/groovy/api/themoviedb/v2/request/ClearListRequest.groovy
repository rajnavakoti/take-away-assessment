package api.themoviedb.v2.request

import api.basic.Get
import api.basic.Post
import io.qameta.allure.Step
import io.restassured.response.ValidatableResponse
import org.testng.Assert
import utils.configuration.Config
import api.themoviedb.v2.theMovieDbEndPoints

/***
 * function calls on clear List api Request
 */
class ClearListRequest {
    static Map headers = [:]
    static ValidatableResponse response

    @Step("Clear list api request")
    static def clearList(String listId){
        headers.put("Content-Type", Config.getTheMovieDbApiContentType())
        headers.put("Authorization", "Bearer "+ Config.getTheMovieDbCreateToken())
        println(theMovieDbEndPoints.EP_LIST + "/" + listId + "/clear")
        response =  Get.makeRequest(theMovieDbEndPoints.EP_LIST + "/" + listId + "/clear",headers)
        println(response.extract().response().path("id").toString())
        return response }

    @Step("Assert status code, status message and success flag")
    static def assertSuccessResponse(ValidatableResponse response, String statusCode,String statusMessage,String successFlag){
        Assert.assertTrue(response.extract().statusCode().toString().contains("20"))
        Assert.assertTrue(response.extract().response().path("status_code").toString().equalsIgnoreCase(statusCode))
        Assert.assertTrue(response.extract().response().path("status_message").toString().equalsIgnoreCase(statusMessage))
        Assert.assertTrue(response.extract().response().path("success").toString().equalsIgnoreCase(successFlag)) }
}
