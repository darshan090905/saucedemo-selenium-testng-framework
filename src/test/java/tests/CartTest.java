package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class CartTest extends BaseTest {

    @Test
    public void addItemUpdatesCartBadge() {
        new LoginPage(driver).login("standard_user", "secret_sauce");
        ProductsPage products = new ProductsPage(driver);
        products.addBackpackToCart();
        Assert.assertEquals(products.getCartCount(), "1");
    }

    @Test
    public void removeItemClearsCartBadge() {
        new LoginPage(driver).login("standard_user", "secret_sauce");
        ProductsPage products = new ProductsPage(driver);
        products.addBackpackToCart();
        products.removeBackpackFromCart();
        Assert.assertFalse(products.isCartBadgeVisible());
    }

    @Test
    public void addTwoItemsShowsCountTwo() {
        new LoginPage(driver).login("standard_user", "secret_sauce");
        ProductsPage products = new ProductsPage(driver);
        products.addBackpackToCart();
        products.addBikeLightToCart();
        Assert.assertEquals(products.getCartCount(), "2");
    }
}