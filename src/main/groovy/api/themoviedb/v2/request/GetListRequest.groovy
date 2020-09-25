package api.themoviedb.v2.request

import api.basic.Get
import api.themoviedb.v2.theMovieDbEndPoints
import api.themoviedb.v2.response.GetListResponse
import io.qameta.allure.Step
import io.restassured.response.ValidatableResponse
import org.testng.Assert
import utils.configuration.Config

/***
 * function calls on Get List api Request
 */
class GetListRequest {
    static Map headers = [:]
    static ValidatableResponse response

    @Step("Get list api request")
    static def getList(String listId){
        headers.put("Content-Type", Config.getTheMovieDbApiContentType())
        headers.put("Authorization", "Bearer "+ Config.getTheMovieDbApiToken())
        headers.put("api-key",Config.getTheMovieDbAPiKey())
        println(theMovieDbEndPoints.EP_LIST)
        response = Get.makeRequest(theMovieDbEndPoints.EP_LIST+ "/"+ listId,headers)
        println(response.extract().response().path("id").toString())
        return response }

    @Step("Assert list ID in the response")
    static def assertListId(ValidatableResponse response, String listId){
        Assert.assertTrue(response.extract().response().path("id").toString().equalsIgnoreCase(listId)) }
}
