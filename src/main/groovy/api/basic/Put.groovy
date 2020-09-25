package api.basic

import io.restassured.response.ValidatableResponse

import static io.restassured.RestAssured.given

/***
 * API put request
 */
class Put {
    static ValidatableResponse makeRequest(String url, Map headers, String jsonBody ) {
        return given()
                .headers(headers)
                .when()
                .body(jsonBody)
                .put(url)
                .then()
                .log()
                .all() }
}
