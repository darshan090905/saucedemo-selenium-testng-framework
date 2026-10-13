package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginShowsProductsPage() {
        new LoginPage(driver).login("standard_user", "secret_sauce");
        Assert.assertEquals(new ProductsPage(driver).getTitle(), "Products");
    }

    @DataProvider(name = "invalidLogins")
    public Object[][] invalidLogins() {
        return new Object[][] {
            {"standard_user", "wrong_pass", "Username and password do not match"},
            {"locked_out_user", "secret_sauce", "this user has been locked out"},
            {"", "secret_sauce", "Username is required"}
        };
    }

    @Test(dataProvider = "invalidLogins")
    public void invalidLoginShowsError(String user, String pass, String expectedText) {
        LoginPage login = new LoginPage(driver);
        login.login(user, pass);
        Assert.assertTrue(login.getErrorMessage().contains(expectedText));
    }

    @Test
    public void logoutReturnsToLoginPage() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");
        new ProductsPage(driver).logout();
        Assert.assertTrue(login.isLoginButtonDisplayed());
    }
}