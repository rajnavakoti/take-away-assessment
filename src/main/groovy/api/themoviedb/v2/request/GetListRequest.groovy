package api.themoviedb.v2.request

import api.basic.Get
import api.themoviedb.v2.theMovieDbEndPoints
import api.themoviedb.v2.response.GetListResponse
import io.qameta.allure.Step
import io.restassured.response.ValidatableResponse
import utils.configuration.Config

class GetListRequest {
    static Map headers = [:]
    static ValidatableResponse response

    @Step("Get list")
    static def getList(int listId){
        headers.put("Content-Type", Config.getTheMovieDbApiContentType())
        headers.put("Authorization", "Bearer "+ Config.getTheMovieDbApiToken())
        headers.put("api-key",Config.getTheMovieDbAPiKey())
        println(theMovieDbEndPoints.EP_LIST)
        response = Get.makeRequest(theMovieDbEndPoints.EP_LIST+ "/"+ listId,headers)
        println(response.extract().response().path("id").toString()) }
}
