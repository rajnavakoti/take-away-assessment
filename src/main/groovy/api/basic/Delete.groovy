package api.basic

import io.restassured.response.ValidatableResponse

import static io.restassured.RestAssured.given

class Delete {
    static ValidatableResponse makeRequest(String url, Map headers) {
        return given()
                .headers(headers)
                .when()
                .delete(url)
                .then()
                .log()
                .all()
    }
}
