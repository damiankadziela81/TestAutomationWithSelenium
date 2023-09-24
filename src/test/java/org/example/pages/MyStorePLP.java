package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyStorePLP extends BasePage{


    @FindBy(css = "div:nth-of-type(1) > article h2 > a")
    private WebElement product1;

    @FindBy(css = "div:nth-of-type(2) > article h2 > a")
    private WebElement product2;

    @FindBy(css = "div:nth-of-type(3) > article h2 > a")
    private WebElement product3;

    @FindBy(css = ".btn-unstyle.select-title")
    private WebElement sortSelect;

    @FindBy(css = ".dropdown-menu > a:nth-of-type(5)")
    private WebElement sortByPriceAscending;

    @FindBy(css = ".dropdown-menu > a:nth-of-type(6)")
    private WebElement sortByPriceDescending;

    @FindBy(css = ".product-price-and-shipping > .price")
    private List<WebElement> productPrices;

    public MyStorePLP(WebDriver driver) {
        super(driver);
    }

    public void clickProduct1() {
        product1.click();
    }

    public void clickProduct2() {
        product2.click();
    }

    public void clickProduct3() {
        product3.click();
    }

    public void setSortByPriceAscending() {
        sortSelect.click();
        sortByPriceAscending.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setSortByPriceDescending() {
        sortSelect.click();
        sortByPriceDescending.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<String> readPricesOfAllProductsOnPLP() {
        return productPrices
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }


}
