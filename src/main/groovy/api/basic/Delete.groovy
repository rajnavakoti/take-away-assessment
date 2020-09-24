package api.basic

import io.restassured.response.ValidatableResponse

import static io.restassured.RestAssured.given

class Delete {
    static ValidatableResponse makeRequest(String jsonBody,String url, Map headers) {
        return given()
                .headers(headers)
                .when()
                .body(jsonBody)
                .delete(url)
                .then()
                .log()
                .all()
    }
}
