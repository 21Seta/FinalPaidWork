package ge.store.veli.Api;

import ge.store.veli.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;


public class ApiTest extends BaseTest {



    @Test
    public void getPostTest(){
        RestAssured.baseURI = "https://api.escuelajs.co/api/v1";


        Response response = given()
        .when()
        .header("Content-Type", "application/json")
        .queryParam("id" , 2)
        .get("/products")
        .then()
                .log().all()
        .assertThat()
        .statusCode(200)
        .extract()
        .response();

//        System.out.println(ids.get(4));
        //Assert.assertTrue(response.asString().contains("id")); // ვგებულობთ მთლიან ბადიში თუ არის String id და ვამოწმებთ AssertTrue-თი
        System.out.println("Response: " + response.asString());

//        for(String title : titles){
//            System.out.println("title is:" + titles);
//        }

    }
}
