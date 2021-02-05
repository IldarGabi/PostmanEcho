package ru.netology;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.entity.mime.Header;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import java.util.logging.Handler;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;
import static org.hamcrest.Matchers.equalTo;
public class postmanEcho {
    @Test
void shouldReturnDemoStatus() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .contentType(ContentType.JSON)
                .body("some data")
                // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .log()
                .body()
                .body("data", equalTo("some data"))
                .contentType(ContentType.JSON)
        ;
    }

}
