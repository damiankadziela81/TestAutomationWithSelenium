package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyStoreCart extends  BasePage{

    @FindBy(css = "li:nth-of-type(1) span.product-price")
    private WebElement price1;

    @FindBy(css = "li:nth-of-type(2) span.product-price")
    private WebElement price2;

    @FindBy(css = "#cart-subtotal-products .value")
    private WebElement subtotalPrice;

    @FindBy(css = "#cart-subtotal-shipping span.value")
    private WebElement shipping;

    @FindBy(css = ".cart-total .value")
    private WebElement totalPrice;

    public MyStoreCart(WebDriver driver) {
        super(driver);
    }

    public int getPrice1() {
        return StringPriceToCents(price1.getText());
    }

    public int getPrice2() {
        return StringPriceToCents(price2.getText());
    }

    public int getSubtotalPrice() {
        return StringPriceToCents(subtotalPrice.getText());
    }

    public int getShippingPrice() {
        return StringPriceToCents(shipping.getText());
    }

    public int getTotalPrice() {
        return StringPriceToCents(totalPrice.getText());
    }

    private int StringPriceToCents(String price) {
        if (price != null) {
            price =  price.replace("$","").replace(".","");
            if(price.matches("[0-9]+")) return Integer.parseInt(price);
        }
        return 0;
    }
}
