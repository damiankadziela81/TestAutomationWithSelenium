package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "ul > li:nth-of-type(2) > b:nth-of-type(1)")
    private WebElement userName;

    @FindBy(css = "ul > li:nth-of-type(2) > b:nth-of-type(2)")
    private WebElement password;

    @FindBy(css = "[name = \"username\"]")
    private WebElement userNameInput;

    @FindBy(css = "[name = \"password\"]")
    private WebElement passwordInput;

    @FindBy(css = ".btn")
    private WebElement submitButton;

    @FindBy(css = "strong")
    private WebElement loginGreetingsMessage;

    @FindBy(xpath = "//*[text()='Log out']")
    private WebElement logOutButton;

    @FindBy(css = "div#error")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getUserName() {
        return userName.getText();
    }

    public String getPassword() {
        return password.getText();
    }

    public void enterUserName(String userName) {
        userNameInput.sendKeys(userName);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public String readGreetingMessage() {
        return loginGreetingsMessage.getText();
    }

    public boolean isLogOutButtonPresent() {
        return !driver.findElements(By.xpath("//*[text()='Log out']")).isEmpty();
    }

    public boolean isErrorMessageDisplayed() {
        return !driver.findElements(By.cssSelector("div#error")).isEmpty();
    }

    public String readErrorMessage() {
        return errorMessage.getText();
    }

}
