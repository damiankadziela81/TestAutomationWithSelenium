package org.example;

import org.example.pages.MyStoreCart;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTests {

    @Test
    public void priceConversionTests() {
        Assert.assertEquals(MyStoreCart.StringPriceToCents("$12.34"),1234);
        Assert.assertEquals(MyStoreCart.StringPriceToCents("12.00"),1200);
        Assert.assertEquals(MyStoreCart.StringPriceToCents(null),0);
        Assert.assertEquals(MyStoreCart.StringPriceToCents("text01"),0);
    }

}
