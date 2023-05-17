package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless");
        options.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(options);
    }

    @AfterClass
    public void tearDown(){
        try{
            Thread.sleep(3000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
