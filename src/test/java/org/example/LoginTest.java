package org.example;

import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    /**
    Test case 1: Positive LogIn test
    Verify new page URL contains practicetestautomation.com/logged-in-successfully/
    Verify new page contains expected text ('Congratulations' or 'successfully logged in')
    Verify button Log out is displayed on the new page
    */
    @Test
    public void positiveLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://practicetestautomation.com/practice-test-login/");
        //get credentials from the page
        String userName = loginPage.getUserName();
        String password = loginPage.getPassword();
        //enter credentials
        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
        loginPage.clickSubmitButton();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://practicetestautomation.com/logged-in-successfully/");
        Assert.assertEquals(loginPage.readGreetingMessage(),"Congratulations student. You successfully logged in!");
        Assert.assertTrue(loginPage.isLogOutButtonPresent());
    }

    /**
     * Test case 2: Negative username test
     * Verify error message is displayed
     * Verify error message text is Your username is invalid!
     */
    @Test
    public void incorrectUserName() {
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://practicetestautomation.com/practice-test-login/");
        String password = loginPage.getPassword();
        loginPage.enterUserName("incorrectUser");
        loginPage.enterPassword(password);
        loginPage.clickSubmitButton();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        Assert.assertEquals(loginPage.readErrorMessage(),"Your username is invalid!");
    }

    /**
     * Test case 3: Negative password test
     * Verify error message is displayed
     * Verify error message text is Your password is invalid!
     */
    @Test
    public void incorrectPassword() {
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://practicetestautomation.com/practice-test-login/");
        String userName = loginPage.getUserName();
        loginPage.enterUserName(userName);
        loginPage.enterPassword("incorrectPassword");
        loginPage.clickSubmitButton();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        Assert.assertEquals(loginPage.readErrorMessage(),"Your password is invalid!");
    }

}
