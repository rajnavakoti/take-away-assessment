package api.basic

import io.restassured.response.ValidatableResponse

import static io.restassured.RestAssured.given

class Post {
    static ValidatableResponse makeRequest(String url, Map headers,String jsonBody ) {
        return given()
                .headers(headers)
                .when()
                .body(jsonBody)
                .post(url)
                .then()
                .log()
                .all()
    }
}
