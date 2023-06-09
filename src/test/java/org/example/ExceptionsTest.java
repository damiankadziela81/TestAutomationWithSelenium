package org.example;

import org.example.pages.ExceptionsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExceptionsTest extends BaseTest{

    /**
     * Test case 1: NoSuchElementException
     * Open page
     * Click Add button
     * Verify Row 2 input field is displayed
     * Row 2 doesn’t appear immediately. This test will fail with org.openqa.selenium.NoSuchElementException
     * without proper wait
     */
    //This will fail and throw NoSuchElementException
    @Test
    public void noSuchElementExample() {
        ExceptionsPage exceptionsPage = openPage();
        exceptionsPage.clickAddButton();
        Assert.assertTrue(exceptionsPage.is2ndRowDisplayed());
    }
    //This will wait for the element to load
    @Test
    public void row2ShouldDisplay() {
        ExceptionsPage exceptionsPage = openPage();
        exceptionsPage.clickAddButton();
        exceptionsPage.waitForElementByCss("#row2 .input-field");
        Assert.assertTrue(exceptionsPage.is2ndRowDisplayed());
    }

    /**
     * Test case 2: ElementNotInteractableException
     * Open page
     * Click Add button
     * Wait for the second row to load
     * Type text into the second input field
     * Push Save button using locator By.name(“Save”)
     * Verify text saved
     *
     * This page contains two elements with attribute name=”Save”.
     * The first one is invisible. So when we are trying to click on the invisible element, we get
     * ElementNotInteractableException.
     */
    @Test
    public void elementNoInteractableExample() {
        ExceptionsPage exceptionsPage = openPage();
        exceptionsPage.clickAddButton();
        exceptionsPage.waitForElementByCss("#row2 .input-field");
        exceptionsPage.inputTextInto2ndField("text");
        exceptionsPage.clickInvisibleSaveButton();
        Assert.assertTrue(exceptionsPage.isConfirmationDisplayed());
    }
    //fix the selector
    @Test
    public void interactionRightWay() {
        ExceptionsPage exceptionsPage = openPage();
        exceptionsPage.clickAddButton();
        exceptionsPage.waitForElementByCss("#row2 .input-field");
        exceptionsPage.inputTextInto2ndField("text");
        exceptionsPage.clickSaveButton();
        Assert.assertTrue(exceptionsPage.isConfirmationDisplayed());
    }

    /**
     * Test case 3: InvalidElementStateException
     * Open page
     * Clear input field
     * Type text into the input field
     * Verify text changed
     *
     * The input field is disabled. Trying to clear the disabled field will throw InvalidElementStateException.
     * We need to enable editing of the input field first by clicking the Edit button.
     *
     * If we try to type text into the disabled input field, we will get ElementNotInteractableException,
     * as in Test case 2.
     */
    @Test
    public void invalidElementSateExample() {
        ExceptionsPage exceptionsPage = openPage();
        exceptionsPage.clearInputField();
        exceptionsPage.inputTextInto1stField("text");
        Assert.assertTrue(exceptionsPage.isTextIn1stInputFieldEqualTo("text"));
    }
    //first make the field editable
    @Test
    public void changeTextProper() {
        ExceptionsPage exceptionsPage = openPage();
        exceptionsPage.clickEditButton();
        exceptionsPage.clearInputField();
        exceptionsPage.inputTextInto1stField("text");
        exceptionsPage.clickInvisibleSaveButton();
    }

    /**
     *Test case 4: StaleElementReferenceException
     * Open page
     * Find the instructions text element
     * Push add button
     *
     * Verify instruction text element is no longer displayed
     * The instructions element is removed from the page when the second row is added.
     * That’s why we can no longer interact with it. Otherwise, we will see StaleElementReferenceException.
     *
     */
    @Test
    public void staleElementExample() {
        ExceptionsPage exceptionsPage = openPage();
        WebElement instruction = driver.findElement(By.cssSelector("p#instructions"));
        exceptionsPage.clickAddButton();
        instruction.isDisplayed();
    }

    /**
     * Test case 5: TimeoutException
     * Open page
     * Click Add button
     * Wait for 3 seconds for the second input field to be displayed
     * Verify second input field is displayed
     *
     * The second row shows up after about 5 seconds, so a 3-second timeout is not enough.
     * That’s why we will get TimeoutException while executing steps in the above test case.
     */
    @Test
    public void timeoutExample() {
        ExceptionsPage exceptionsPage = openPage();
        exceptionsPage.clickAddButton();
        exceptionsPage.waitForElementByCss("#row2 .input-field",3);
    }


    ExceptionsPage openPage() {
        ExceptionsPage page = new ExceptionsPage(driver);
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
        return page;
    }




}
