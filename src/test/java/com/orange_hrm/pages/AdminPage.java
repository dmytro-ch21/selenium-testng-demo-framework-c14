package com.orange_hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

    public AdminPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id = 'systemUser-information']/div/h1")
    private WebElement userManagementHeader;

    public String getUserManagementHeader(){
        return userManagementHeader.getText();
    }

}
