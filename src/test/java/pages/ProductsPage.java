package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private WebDriver driver;

    private By pageTitle       = By.className("title");
    private By addBackpack     = By.id("add-to-cart-sauce-labs-backpack");
    private By removeBackpack  = By.id("remove-sauce-labs-backpack");
    private By addBikeLight    = By.id("add-to-cart-sauce-labs-bike-light");
    private By cartBadge       = By.className("shopping_cart_badge");
    private By cartLink        = By.className("shopping_cart_link");
    private By menuButton      = By.id("react-burger-menu-btn");
    private By logoutLink      = By.id("logout_sidebar_link");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public void addBackpackToCart() {
        driver.findElement(addBackpack).click();
    }

    public void addBikeLightToCart() {
        driver.findElement(addBikeLight).click();
    }

    public void removeBackpackFromCart() {
        driver.findElement(removeBackpack).click();
    }

    public String getCartCount() {
        return driver.findElement(cartBadge).getText();
    }

    public boolean isCartBadgeVisible() {
        return !driver.findElements(cartBadge).isEmpty();
    }

    public void openCart() {
        driver.findElement(cartLink).click();
    }

    public void logout() {
        driver.findElement(menuButton).click();
        driver.findElement(logoutLink).click();
    }
}