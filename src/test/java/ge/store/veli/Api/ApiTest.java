package ge.store.veli.Api;

import ge.store.veli.utils.ApiManager;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;


public class ApiTest {

    private final ApiManager api = new ApiManager("https://api.escuelajs.co/api/v1");

    @Test
    public void createProductWithNegativePriceTest() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        Map<String, Object> productDetails  = new HashMap<>();
        List<String> images = new ArrayList<>();
        images.add("https://placehold.co/600x400");

        productDetails.put("title", "product with zero price");
        productDetails.put("price", 0);
        productDetails.put("description", "Test product with zero price");
        productDetails.put("categoryId", 1);
        productDetails.put("images", images);

        Response response = api.post("/products" , headers, productDetails);

        Assert.assertEquals(response.getStatusCode(), 400 , "Api accepted product price with zero");
    }
    @Test
    public void verifyProductIsNotFoundByIdTest(){

        Response response = api.getWithPathParams("/products/{id}" , "id" , 11111) ;

        Assert.assertEquals(response.getStatusCode(), 400 , "Api accepted product with id not found");

    }
    @Test
    public void filterProductByPriceTest() {
        Map<String, Object> queryParams  = new HashMap<>();

        queryParams.put("price_min" , 100);
        queryParams.put("price_max", 100);

        //Send GET request with price filter query parameters
        Response response = api.getWithQueryParams("/products" , queryParams);

        //Verify that products were filtered successfully
        Assert.assertEquals(response.getStatusCode(), 200 , "Product were not filtered successfully");

        //Verify that returned product prices match selected price
        List<Integer> productPrices = response.jsonPath().getList("price");
        for (Integer price : productPrices) {
            Assert.assertEquals(price, 100, "Product price " + price);
        }
    }
    @Test
    public void validLoginTest(){
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        //Prepare user to login
        Map<String, Object> loginDetails  = new HashMap<>();
        loginDetails.put("email", "john@mail.com");
        loginDetails.put("password", "changeme");

        Response response = api.post("/auth/login" , headers , loginDetails);
        //Check if we authorize successfully
        Assert.assertTrue(response.getStatusCode() == 201 , "Api accepted login");

        String accessToken = response.jsonPath().getString("access_token");
        String refreshToken = response.jsonPath().getString("refresh_token");

        //Check if we received access token
        Assert.assertTrue(!accessToken.isEmpty(), "Access token is null or empty");
        Assert.assertTrue(!refreshToken.isEmpty(), "Refresh token is null or empty");

        Response profileResponse = api.getWithBearerToken("/auth/profile" , accessToken);
        //Check if we transited Profile
        Assert.assertEquals(profileResponse.getStatusCode() ,200 , "Profile request wan not successful");

    }
    @Test
    public void createUserWithInvalidEmailTest() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        // Prepare user data with invalid email format
        Map<String, String> newUserDetails = new HashMap<>();
        newUserDetails.put("name", "Invalid email test");
        newUserDetails.put("email" , "testmail.com");// email without "@"
        newUserDetails.put("password", "1234567qw");
        newUserDetails.put("role", "customer");
        newUserDetails.put("avatar", "https://images7.alphacoders.com/801/thumb-1920-801755.jpg");

        Response createNewUser = api.post("/users" ,  headers, newUserDetails);
        // Check if we receive correct status code
        Assert.assertEquals(createNewUser.getStatusCode(), 400, "API accepted user with invalid email");
    }
}