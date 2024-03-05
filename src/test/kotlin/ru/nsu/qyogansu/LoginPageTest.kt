package ru.nsu.qyogansu

import io.restassured.RestAssured
import io.restassured.builder.RequestSpecBuilder
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.hamcrest.CoreMatchers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import ru.nsu.qyogansu.app.QYogaApp

@SpringBootTest(classes = [QYogaApp::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LoginPageTest {

    @LocalServerPort
    var port: Int = 0

    @BeforeEach
    fun setupRestAssured() {
        val baseUri = "http://localhost:$port"
        RestAssured.requestSpecification = RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setContentType("application/x-www-form-urlencoded; charset=UTF-8")
                .setRelaxedHTTPSValidation()
                .build()
    }

    @Test
    fun `Afet login with valid credentials user should should stay logged in`() {
        // Given
        val user = "therapist"
        val password = "password"

        // When
        val cookie = Given {
            formParam("user", user)
            formParam("password", password)
        } When {
            post("/login")
        } Then {
            statusCode(HttpStatus.FOUND.value())
            cookie("JSESSIONID", CoreMatchers.notNullValue())
        } Extract {
            detailedCookie("JSESSIONID").value
        }

        // Then

    }

}