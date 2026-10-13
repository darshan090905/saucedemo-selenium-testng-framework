package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;

    private By checkoutButton = By.id("checkout");
    private By firstName      = By.id("first-name");
    private By lastName       = By.id("last-name");
    private By postalCode     = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton   = By.id("finish");
    private By successHeader  = By.className("complete-header");
    private By errorMessage   = By.cssSelector("[data-test='error']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }

    public void fillDetails(String first, String last, String zip) {
        driver.findElement(firstName).sendKeys(first);
        driver.findElement(lastName).sendKeys(last);
        driver.findElement(postalCode).sendKeys(zip);
        driver.findElement(continueButton).click();
    }

    public void finishOrder() {
        driver.findElement(finishButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successHeader).getText();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}