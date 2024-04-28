package com.orange_hrm.test;


import com.orange_hrm.base.TestBase;
import com.orange_hrm.pages.HomePage;
import com.orange_hrm.pages.LoginPage;
import com.orange_hrm.test_data.DataProvides;
import com.orange_hrm.test_data.ExpectedMessages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends TestBase {

    // to access now the welcome message element we need to create an object of HomePage
    @Test
    public void testSuccessfulLoginWithValidCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("yoll-student", "Bootcamp5#"); // TODO - read the creds from file
        HomePage homePage = new HomePage(driver);
        String actualWelcomeMessage = homePage.getWelcomeMessage();
        Assert.assertEquals(actualWelcomeMessage, ExpectedMessages.WELCOME_MESSAGE, "The login validation failed!");
    }

    @Test(dataProviderClass = DataProvides.class, dataProvider = "invalidLoginCredentials")
    public void testErrorMessagesWithInvalidCredentials(String username, String password, String expectedErrorMessage){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message verification failed!");
    }



}

