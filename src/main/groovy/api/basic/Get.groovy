package api.basic

import io.restassured.response.ValidatableResponse
import static io.restassured.RestAssured.given

class Get {
    static ValidatableResponse makeRequest(String url, Map headers){
        return given()
                .headers(headers)
                .when()
                .get(url)
                .then() }

    static ValidatableResponse makeRequestWithQueryParams(String url, Map headers, Map queryParams){
        return given()
                .headers(headers)
                .queryParams(queryParams)
                .when()
                .get(url)
                .then() }
}
