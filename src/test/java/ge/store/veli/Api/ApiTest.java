package ge.store.veli.Api;

import ge.store.veli.utils.ApiManager;
import ge.store.veli.utils.ConfigReader;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;


public class ApiTest {

    private final ApiManager api = new ApiManager(ConfigReader.get("base.URI"));

    /**
     * ამოწმებს რომ API არ იღებს პროდუქტს არასწორი ფასით
     */
    @Test
    public void createProductWithZeroPriceTest() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        Map<String, Object> productDetails  = new HashMap<>();
        List<String> image = new ArrayList<>();
        image.add(ConfigReader.get("api.product.image"));

        productDetails.put("title", "product with zero price");
        productDetails.put("price", 0);
        productDetails.put("description", "Test product with zero price");
        productDetails.put("categoryId", 1);
        productDetails.put("images", image);


        Response zeroProductPrice = api.post("/products" , headers, productDetails);

        Assert.assertEquals(zeroProductPrice.getStatusCode(), 400 , "Api accepted product with zero price");
    }

    /**
     * ამოწმებს რომ არარსებულ პროდუქტის Id-ზე API შესაბამის შეცდომას აბრუნებს
     */
    @Test
    public void verifyProductNotFoundByIdTest(){

        Response response = api.getWithPathParam("/products/{id}" , "id" , 11111) ;

        Assert.assertEquals(response.getStatusCode(), 400 , "Invalid product id did not return 400 status code");

    }

    /**
     * ამოწმებს რომ პროდუქტები ზუსტი ფასით სწორად იფილტრება
     */
    @Test
    public void filterProductByPriceTest() {
        Map<String, Object> queryParams  = new HashMap<>();

        queryParams.put("price_min" , 100);
        queryParams.put("price_max", 100);

        Response response = api.getWithQueryParam("/products" , queryParams);

        Assert.assertEquals(response.getStatusCode(), 200 , "Product price filtering request was not successful");

        List<Integer> productPrices = response.jsonPath().getList("price");
        for (Integer price : productPrices) {
            Assert.assertEquals(price, 100, "Product prices wan not filtered successfully");
        }
    }

    /**
     * ამოწმებს რომ მომხარებელი წარმატებით გადის ავტორიზაციას
     */
    @Test
    public void validLoginTest(){
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        Map<String, Object> loginDetails  = new HashMap<>();
        loginDetails.put("email", ConfigReader.get("api.user.email"));
        loginDetails.put("password", ConfigReader.get("api.user.password"));

        Response login = api.post("/auth/login" , headers , loginDetails);

        Assert.assertEquals(login.getStatusCode(), 201 , "Login request was not successful");

        String accessToken = login.jsonPath().getString("access_token");
        String refreshToken = login.jsonPath().getString("refresh_token");

        Assert.assertTrue(!accessToken.isEmpty(), "Access token is null or empty");
        Assert.assertTrue(!refreshToken.isEmpty(), "Refresh token is null or empty");

        Response profile = api.getWithBearerToken("/auth/profile" , accessToken);
        Assert.assertEquals(profile.getStatusCode() ,200 , "Profile request was not successful");


    }

    /**
     * ამოწმებს რომ API არ იღებს მომხმარებელს არასწორი email ფორმატით
     */
    @Test
    public void createUserWithInvalidEmailFormatTest() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        Map<String, String> newUserDetails = new HashMap<>();
        newUserDetails.put("name", "Invalid email format test");
        newUserDetails.put("email" , "testmail.com");// email without "@"
        newUserDetails.put("password", "1234567qw");
        newUserDetails.put("role", "customer");
        newUserDetails.put("avatar", ConfigReader.get("api.user.avatar"));

        Response createNewUser = api.post("/users" ,  headers, newUserDetails);
        Assert.assertEquals(createNewUser.getStatusCode(), 400, "API accepted user with invalid email format");

        List<String> errorMessage = createNewUser.jsonPath().getList("message");
        Assert.assertTrue(errorMessage.contains("email must be an email") , "Validation message for invalid email format was not returned");
    }

    /**
     * ამოწმებს რომ API არ იღებს მომხმარებელს ემაილის გარეშე.
     */
    @Test
    public void createUserWithoutEmailTest(){
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        Map<String, String> newUserDetails = new HashMap<>();
        newUserDetails.put("name" , "User without email");
        newUserDetails.put("email", "");
        newUserDetails.put("password", "1234567qw");
        newUserDetails.put("role", "customer");
        newUserDetails.put("avatar", ConfigReader.get("api.user.avatar"));

        Response createNewUser = api.post("/users" ,  headers, newUserDetails);
        Assert.assertEquals(createNewUser.getStatusCode(), 400, "API accepted user without email");

        List<String> errorMessageCheck = createNewUser.jsonPath().getList("message");
        Assert.assertTrue(errorMessageCheck.contains("email should not be empty") , "Validation message for empty email was not returned");
    }

    /**
     * ამოწმებს რომ მომხმარებლის შექმნა , დეტალების შეცვლა და წაშლა წარმატებით შესრულდა
     */
    @Test
    public void createUpdateDeleteUserTest() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        String email = "testEmail" + UUID.randomUUID() + "@gmail.com";

        Map <String , String> newUserDetails = new HashMap<>();
        newUserDetails.put("name","New user");
        newUserDetails.put("email" ,email );
        newUserDetails.put("password", "1234567qw");
        newUserDetails.put("role", "customer");
        newUserDetails.put("avatar", ConfigReader.get("api.user.avatar"));

        Response createNewUser = api.post("/users" ,  headers, newUserDetails);
        Assert.assertEquals(createNewUser.getStatusCode(), 201 , "API accepted new user");

        int newUserId = createNewUser.jsonPath().getInt("id");

        Map<String, String> updatedUser = new HashMap<>();
        updatedUser.put("name","Updated user");
        updatedUser.put("email", email);
        updatedUser.put("password", "1234567qw");
        updatedUser.put("role", "admin");
        updatedUser.put("avatar", ConfigReader.get("api.user.avatar"));

        Response updateUser = api.put("/users/" + newUserId , headers , updatedUser);
        Assert.assertEquals(updateUser.getStatusCode(), 200 , "API accepted updates for user");
        Assert.assertEquals(updateUser.jsonPath().getString("role"), "admin");

        Response deleteUser = api.delete("/users/" + newUserId);
        Assert.assertEquals(deleteUser.getStatusCode(), 200 , "API accepted user delete");
    }
}