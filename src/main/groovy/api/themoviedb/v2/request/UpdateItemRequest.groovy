package api.themoviedb.v2.request

import api.basic.Put
import io.qameta.allure.Step
import io.restassured.response.ValidatableResponse
import utils.configuration.Config
import api.themoviedb.v2.theMovieDbEndPoints

class UpdateItemRequest {
    static Map headers = [:]
    static ValidatableResponse response

    @Step("Get Address by Address Line1 and Address Line 2")
    static def updateItem(String jsonBody, String itemId){
        headers.put("Content-Type", Config.getTheMovieDbApiContentType())
        headers.put("Authorization", "Bearer "+ Config.getTheMovieDbCreateToken())
        println(theMovieDbEndPoints.EP_LIST + "/" + itemId + "/items")
        println(jsonBody)
        response =  Put.makeRequest(theMovieDbEndPoints.EP_LIST + "/" + itemId + "/items",headers,jsonBody)
        println(response.extract().response().path("status_code").toString())
    }
}
