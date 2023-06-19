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

    @FindBy(xpath = ".//button[text()='Continue shopping']")
    private WebElement continueShoppingButton;

    @FindBy(css = ".cart-content-btn .btn-primary")
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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//button[text()='Continue shopping']")));
        continueShoppingButton.click();
    }

    public void checkout() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".cart-content-btn .btn-primary")));
        checkoutButton.click();
    }
}
