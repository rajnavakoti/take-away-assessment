package api.themoviedb.v2.request

import api.basic.Get
import api.basic.Post
import api.themoviedb.v2.response.GetListResponse
import io.qameta.allure.Step
import io.restassured.response.ValidatableResponse
import utils.configuration.Config
import api.themoviedb.v2.theMovieDbEndPoints

class CreateListRequest {
    static Map headers = [:]
    static ValidatableResponse response

    @Step("Get Address by Address Line1 and Address Line 2")
    static def createANewList(String jsonBody){
        headers.put("Content-Type", Config.getTheMovieDbApiContentType())
        headers.put("Authorization", "Bearer "+ Config.getTheMovieDbCreateToken())
        println(theMovieDbEndPoints.EP_LIST)
        response =  Post.makeRequest(theMovieDbEndPoints.EP_LIST,headers,jsonBody)
        println(response.extract().response().path("id").toString())
    }
}
