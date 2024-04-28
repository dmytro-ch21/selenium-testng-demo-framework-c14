package com.orange_hrm.base;

import com.orange_hrm.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class TestBase {

    protected WebDriver driver;

    @Parameters("browserType")
    @BeforeMethod
    public void setup(@Optional("chrome") String browserType){
        driver = DriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.get("http://dev-hrm.yoll.io/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown(){
        // code that takes screenshot
        driver.quit();
    }

}
