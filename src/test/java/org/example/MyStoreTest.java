package org.example;

import org.example.pages.MyStoreCart;
import org.example.pages.MyStoreMainPage;
import org.example.pages.MyStorePDP;
import org.example.pages.MyStorePLP;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyStoreTest extends BaseTest{

    MyStoreMainPage mainPage;
    MyStorePLP plp;
    MyStorePDP pdp;
    MyStoreCart cart;
    String baseUrl;
    @BeforeClass
    public void before() {
        mainPage = new MyStoreMainPage(driver);
        plp = new MyStorePLP(driver);
        pdp = new MyStorePDP(driver);
        cart = new MyStoreCart(driver);
        baseUrl = "http://146.59.32.4/index.php";
    }

    /**
     * check if sum of two products in the cart is calculated correctly
     */

    @Test
    public void productPriceCalculationSummaryInCart() {

        driver.get(baseUrl);
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

    /**
     * check if sorting by price works correctly
     */

    @Test
    public void checkSortingByPriceAscending() {
        driver.get(baseUrl);
        mainPage.clickOnAccessories();
        plp.setSortByPriceAscending();
        List<String> productPrices = plp.readPricesOfAllProductsOnPLP();
        List<Integer> productPricesInt = productPrices.stream()
                .map(MyStoreCart::StringPriceToCents)
                .toList();
        List<Integer> productPricesIntSorted = new ArrayList<>(productPricesInt);
        Collections.sort(productPricesIntSorted);
        Assert.assertEquals(productPricesInt,productPricesIntSorted);
        System.out.println(productPrices + "\n" + productPricesInt + "\n" + productPricesIntSorted);
    }

    @Test
    public void checkSortingByPriceDescending() {
        driver.get(baseUrl);
        mainPage.clickOnAccessories();
        plp.setSortByPriceDescending();
        List<String> productPrices = plp.readPricesOfAllProductsOnPLP();
        List<Integer> productPricesInt = productPrices.stream()
                .map(MyStoreCart::StringPriceToCents)
                .toList();
        List<Integer> productPricesIntSorted = new ArrayList<>(productPricesInt);
        productPricesIntSorted.sort(Collections.reverseOrder());
        Assert.assertEquals(productPricesInt,productPricesIntSorted);
        System.out.println(productPrices + "\n" + productPricesInt + "\n" + productPricesIntSorted);
    }
}
