package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyStorePDP extends BasePage{

    @FindBy(css = "[itemprop = \"price\"]")
    private WebElement price;

    @FindBy(css = "[data-button-action]")
    private WebElement addToCartButton;

    private final String continueButtonSelector = ".//button[text()='Continue shopping']";
    @FindBy(xpath = continueButtonSelector)
    private WebElement continueShoppingButton;

    private final String checkoutButtonSelector = ".cart-content-btn .btn-primary";
    @FindBy(css = checkoutButtonSelector)
    private WebElement checkoutButton;

    public MyStorePDP(WebDriver driver) {
        super(driver);
    }

    public String readPrice() {
        return price.getText();
    }

    public void addProductToCart() {
        addToCartButton.click();
    }

    public void continueShopping() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(continueButtonSelector)));
        continueShoppingButton.click();
    }

    public void checkout() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(checkoutButtonSelector)));
        checkoutButton.click();
    }
}
