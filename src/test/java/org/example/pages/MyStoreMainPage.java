package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyStoreMainPage extends BasePage{

    @FindBy(css = "#_desktop_top_menu .category:nth-of-type(1) [data-depth='0']")
    private WebElement clothesButton;

    @FindBy(css = "#_desktop_top_menu .category:nth-of-type(2) [data-depth='0']")
    private WebElement accessoriesButton;

    @FindBy(css = "#_desktop_top_menu .category:nth-of-type(3) [data-depth='0']")
    private WebElement artButton;




    public MyStoreMainPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnClothes() {
        clothesButton.click();
    }

    public void clickOnAccessories() {
        accessoriesButton.click();
    }

    public void clickOnArt() {
        artButton.click();
    }


}
