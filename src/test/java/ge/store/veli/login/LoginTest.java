package ge.store.veli.login;

import Pages.LoginPage;
import ge.store.veli.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;



// Ჩემი Ველი
public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("seturidzegeorge3@gmail.com", "Giviko21");

        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(@class,'account')]")).isDisplayed());
    }

}

