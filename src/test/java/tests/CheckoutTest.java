package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void userCanCompleteOrder() {
        new LoginPage(driver).login("standard_user", "secret_sauce");
        ProductsPage products = new ProductsPage(driver);
        products.addBackpackToCart();
        products.openCart();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.clickCheckout();
        checkout.fillDetails("Darshan", "Patgar", "560001");
        checkout.finishOrder();

        Assert.assertEquals(checkout.getSuccessMessage(), "Thank you for your order!");
    }

    @Test
    public void emptyFirstNameShowsError() {
        new LoginPage(driver).login("standard_user", "secret_sauce");
        ProductsPage products = new ProductsPage(driver);
        products.addBackpackToCart();
        products.openCart();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.clickCheckout();
        checkout.fillDetails("", "Patgar", "560001");

        Assert.assertTrue(checkout.getErrorMessage().contains("First Name is required"));
    }
}