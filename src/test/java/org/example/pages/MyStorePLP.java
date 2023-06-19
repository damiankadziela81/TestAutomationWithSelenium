package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MyStorePLP extends BasePage{


    @FindBy(css = "div:nth-of-type(1) > article h2 > a")
    private WebElement product1;

    @FindBy(css = "div:nth-of-type(2) > article h2 > a")
    private WebElement product2;

    @FindBy(css = "div:nth-of-type(3) > article h2 > a")
    private WebElement product3;


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


}
