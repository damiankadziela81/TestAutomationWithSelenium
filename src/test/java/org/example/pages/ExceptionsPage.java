package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExceptionsPage extends BasePage {

    @FindBy(css = "[name=\"Add\"]")
    private WebElement addButton;

    @FindBy(css = "[name=\"Edit\"]")
    private WebElement editButton;

    @FindBy(css = ".input-field")
    private WebElement inputField;

    @FindBy(css = "#row2 .input-field")
    private WebElement row2InputField;

    @FindBy(css = "#confirmation")
    private WebElement confirmation;

    @FindBy(css = "[name=\"Save\"]")
    WebElement saveButtonInvisible;

    @FindBy(css = "#row2 [name=\"Save\"]")
    WebElement saveButton;

    public ExceptionsPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddButton() {
        addButton.click();
    }

    public boolean is2ndRowDisplayed() {
        return row2InputField.isDisplayed();
    }

    public void waitForElementByCss(String selector) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector)));
    }

    public void waitForElementByCss(String selector, long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector)));
    }

    public void inputTextInto2ndField(String input) {
        row2InputField.sendKeys(input);
    }

    public void clickInvisibleSaveButton() {
        saveButtonInvisible.click();
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public boolean isConfirmationDisplayed() {
        return confirmation.getText().equals("Row 2 was saved");
    }

    public void clearInputField() {
        inputField.clear();
    }

    public void inputTextInto1stField(String input) {
        inputField.sendKeys(input);
    }

    public boolean isTextIn1stInputFieldEqualTo(String input) {
        return inputField.getText().equals(input);
    }

    public void clickEditButton() {
        editButton.click();
    }
}
