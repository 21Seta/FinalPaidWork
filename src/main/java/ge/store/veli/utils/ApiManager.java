package ge.store.veli.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.Map;
import static io.restassured.RestAssured.given;
public class ApiManager {

    public ApiManager(String baseUrl) {
        RestAssured.baseURI = baseUrl;
    }

    /**
     * აგზავნის GET request-ს header-ით
     *
     * @param endPoint API endPoint
     * @param headers request header
     * @return API-ის სრული პასუხი
     */
    public Response get(String endPoint , Map<String, String> headers) {
        return   given()
                .headers(headers)
                .log().all()
                .when()
                .get(endPoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    /**
     * აგზავნის GET request-ს query parameter-ებით
     *
     * @param endPoint API endPoint
     * @param queryParams request
     * @return API-ის სრული პასუხი
     */
    public Response getWithQueryParam(String endPoint , Map<String, Object> queryParams) {
        return  given()
                .queryParams(queryParams)
                .log().all()
                .when()
                .get(endPoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    /**
     * აგზავნის GET request-ს path parameter-ით
     *
     * @param endPoint API endpoint parameter-ით
     * @param paramName path parameter-ის სახელი
     * @param paramValue path parameter-is მნიშვნელობა
     * @return API-ის სრული პასუხი
     */
    public Response getWithPathParam(String endPoint , String paramName, int paramValue){
        return  given()
                .pathParam(paramName , paramValue)
                .log().all()
                .when()
                .get(endPoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    /**
     * აგზავნის POST request-ს headers-ით და body-ით
     *
     * @param endPoint API endpoint
     * @param headers request request header-ები
     * @param body request body
     * @return API-ის სრული პასუხი
     */
    public Response post(String endPoint , Map<String, String> headers, Object body) {
        return   given()
                .headers(headers)
                .log().all()
                .body(body)
                .when()
                .post(endPoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    /**
     * აგზავნის DELETE request -ს headers-ით მითითებულ path-ზე
     *
     * @param path request path
     * @return API-ის სრული პასუხი
     */
    public Response delete(String path){
        return  given()
                .when()
                .delete(path)
                .then()
                .log().all()
                .extract()
                .response();
    }

    /**
     * აგზავნის PUT request-ს header-ით და განახლებული body-ით
     *
     * @param endPoint API endpoint
     * @param headers request header-ები
     * @param body განახლებული request body
     * @return API-ის სრული პასუხი
     */
    public Response put(String endPoint, Map<String, String> headers, Object body){
        return   given()
                .headers(headers)
                .log().all()
                .body(body)
                .when()
                .put(endPoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    /**
     * აგზავნის GET request-ს bearer token-ით ავტორიზებულ endpoint-ზე
     *
     * @param endPoint API endpoint
     * @param token ავტორიზაციის ტოკენი
     * @return API-ის სრული პასუხი
     */
    public Response getWithBearerToken(String endPoint , String token){
        return   given()
                .header("Authorization" , "Bearer " + token)
                .log().all()
                .when()
                .get(endPoint)
                .then()
                .log().all()
                .extract()
                .response();
    }
}
