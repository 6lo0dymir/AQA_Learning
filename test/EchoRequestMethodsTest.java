import io.restassured.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class EchoRequestMethodsTest {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void postmanEchoGetTest() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("url", containsString("/get"));
    }

    @Test
    public void postmanEchoPostRawTextTest() {
        String newText = "This is test Text";
        given()
                .contentType("text/plain")
                .body(newText)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", containsString("This is test Text"))
                .body("json", nullValue())
                .body("headers.content-type", containsString("text/plain"))
                .body("url", containsString("/post"));
    }

    @Test
    public void postmanEchoPostFormDataTest() {
        Map<String, String> testData = new HashMap<>();
        testData.put("foo1", "bar1");
        testData.put("foo2", "bar2");

        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParams(testData)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("form", equalTo(testData))
                .body("json", equalTo(testData))
                .body("headers.content-type", containsString("x-www-form-urlencoded"))
                .body("url", containsString("/post"));
    }
    @Test
    public void postmanEchoPutTest(){
        String testText = "This is expected to be sent back as part of response body.";
        given()
                .contentType("text/plain")
                .body(testText)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data", containsString("This is expected to be sent back as part of response body."))
                .body("headers.content-type", containsString("text/plain"))
                .body("json", nullValue())
                .body("url", containsString("/put"));

    }
    @Test
    public void postmanEchoPatchTest(){
        String testText = "This is expected to be sent back as part of response body.";
        given()
                .contentType("text/plain")
                .body(testText)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data", containsString("This is expected to be sent back as part of response body."))
                .body("headers.content-type", containsString("text/plain"))
                .body("json", nullValue())
                .body("url", containsString("/patch"));
    }
    @Test
    public void postmanEchoDeleteTest(){
        String testText = "This is expected to be sent back as part of response body.";
        given()
                .contentType("text/plain")
                .body(testText)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("data", containsString("This is expected to be sent back as part of response body."))
                .body("headers.content-type", containsString("text/plain"))
                .body("json", nullValue())
                .body("url", containsString("/delete"));
    }

}
