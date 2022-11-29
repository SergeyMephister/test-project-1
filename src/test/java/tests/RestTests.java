package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@Tag("API")
public class RestTests {

    @BeforeAll
    public static void setBaseUrl(){
        RestAssured.baseURI = "https://reqres.in";
    }

    @Test
    @Owner("Sergey Mephister")
    @Description("Register new customer in system")
    @DisplayName("Register new customer in system")
    public void createTestForTest () {
        String testMan = "{\n" +
                " \"email\":\"eve.holt@reqres.in\",\n" +
                " \"password\":\"pistol\"\n" +
                "}";
        given().basePath("/api/").
                contentType(ContentType.JSON).
        body(testMan).
                log().all().
                when().post("register").
                then().assertThat().
                statusCode(200).
                body("id", Matchers.notNullValue()).
                body("token", Matchers.notNullValue()).
                log().all();
    }

}
