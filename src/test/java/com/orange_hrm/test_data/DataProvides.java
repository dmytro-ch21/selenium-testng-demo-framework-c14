package com.orange_hrm.test_data;

import org.testng.annotations.DataProvider;

public class DataProvides {

    @DataProvider(name = "invalidLoginCredentials")
    public Object[][] invalidCredentials(){
        return new Object[][]{
                {"invalid", "invalid", ExpectedErrorMessages.INVALID_CREDENTIALS},
                {"", "invalid", ExpectedErrorMessages.EMPTY_USERNAME},
                {"invalid", "", ExpectedErrorMessages.EMPTY_PASSWORD}
        };
    }

}
