package api.themoviedb.v2.response

import io.qameta.allure.Step
import io.restassured.response.ValidatableResponse

class GetListResponse extends Response{
    GetListResponse(ValidatableResponse validatableResponse){
        super(validatableResponse) }

    @Step("assert Status Code")
    def assertStatusCode(String statusCode) {
        this.validatableResponse.assertThat().statusCode(statusCode.toInteger())
        this
    }
}
