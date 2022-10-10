import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class ZippoTest {

    @Test
    public void test(){

        given()

                .when()

                .then()

        ;

    }

    @Test
    public void statusCodeTest(){

        given()
                .when()
                .get("http://api.zippopotam.us/us/90210")

                .then()
                .log().body()
                .body("country", equalTo("United States"))
                .statusCode(200)
                .contentType(ContentType.JSON)
                ;

    }

    @Test
    public void extractingJsonPath(){

        int limit=
        given()
                .when()
                .get("https://gorest.co.in/public/v1/users")

                .then()
                .statusCode(200)
                .extract().path("meta.pagination.limit")
        ;

        Assert.assertEquals(limit,10,"sonuc kontrol");

    }

    @Test
    public void extractingJsonPath2(){

        int id=
                given()
                        .when()
                        .get("https://gorest.co.in/public/v1/users")

                        .then()
                        .statusCode(200)
                        .extract().path("data[2].id")
                ;

        System.out.println("id = " + id);

    }

    @Test
    public void extractingJsonPathdizi() {

        List<Integer> idList =
                given()
                        .when()
                        .get("https://gorest.co.in/public/v1/users")

                        .then()
                        .statusCode(200)
                        .extract().path("data.id");

        System.out.println("id List = " + idList);
        Assert.assertTrue(idList.contains(3044));
    }
}
