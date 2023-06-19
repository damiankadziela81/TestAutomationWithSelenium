package org.example;

import org.example.pages.MyStoreCart;
import org.example.pages.MyStoreMainPage;
import org.example.pages.MyStorePDP;
import org.example.pages.MyStorePLP;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyStoreTest extends BaseTest{

    /**
     * check if sum of two products in the cart is calculated correctly
     */

    @Test
    public void productPriceCalculationSummaryInCart() {
        MyStoreMainPage mainPage = new MyStoreMainPage(driver);
        MyStorePLP plp = new MyStorePLP(driver);
        MyStorePDP pdp = new MyStorePDP(driver);
        MyStoreCart cart = new MyStoreCart(driver);

        driver.get("http://146.59.32.4/index.php");
        mainPage.clickOnClothes();
        String page = driver.getCurrentUrl();
        plp.clickProduct1();
        pdp.addProductToCart();
        pdp.continueShopping();
        driver.get(page);
        plp.clickProduct2();
        pdp.addProductToCart();
        pdp.checkout();
        int product1price = cart.getPrice1();
        int product2price = cart.getPrice2();
        int productsSubtotal = cart.getSubtotalPrice();
        int shippingCosts = cart.getShippingPrice();
        int totalPrice = cart.getTotalPrice();
        Assert.assertEquals(product1price + product2price, productsSubtotal);
        Assert.assertEquals(product1price + product2price + shippingCosts, totalPrice);
        System.out.println(product1price + " " + product2price + " " + shippingCosts + " " + totalPrice);
    }
}
