package api.themoviedb.v2.request

import api.basic.Get
import api.basic.Post
import io.qameta.allure.Step
import io.restassured.response.ValidatableResponse
import utils.configuration.Config
import api.themoviedb.v2.theMovieDbEndPoints

class ClearListRequest {
    static Map headers = [:]
    static ValidatableResponse response

    @Step("Get Address by Address Line1 and Address Line 2")
    static def clearList(String listId){
        headers.put("Content-Type", Config.getTheMovieDbApiContentType())
        headers.put("Authorization", "Bearer "+ Config.getTheMovieDbCreateToken())
        println(theMovieDbEndPoints.EP_LIST + "/" + listId + "/clear")
        response =  Get.makeRequest(theMovieDbEndPoints.EP_LIST + "/" + listId + "/clear",headers)
        println(response.extract().response().path("id").toString())
    }
}
