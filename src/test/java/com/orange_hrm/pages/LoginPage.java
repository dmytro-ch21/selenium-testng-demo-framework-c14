package com.orange_hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "txtUsername")
    private WebElement usernameInputBox;

    @FindBy(css = "#txtPassword")
    private WebElement passwordInputBox;

    @FindBy(xpath = "//*[@id = 'btnLogin']")
    private WebElement loginButton;

    @FindBy(id = "spanMessage")
    private WebElement errorMessageElement;

    public String getErrorMessage(){
        return errorMessageElement.getText();
    }

    public void login(String username, String password){
        usernameInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password);
        loginButton.click();
    }


}
