package api.themoviedb.v2.response

import io.qameta.allure.Step
import io.restassured.module.jsv.JsonSchemaValidator
import io.restassured.response.ValidatableResponse

class Response {
    ValidatableResponse validatableResponse = null

    Response(ValidatableResponse validatableResponse) {
        this.validatableResponse = validatableResponse }

    Response verifySchema(File schemaPath) {
        this.validatableResponse
                .body(JsonSchemaValidator.matchesJsonSchema(schemaPath))
        this }

    @Step("Assert status code = {statusCode}")
    def assertStatusCode(def statusCode) {
        this.validatableResponse.assertThat().statusCode(statusCode)
        this }
}
