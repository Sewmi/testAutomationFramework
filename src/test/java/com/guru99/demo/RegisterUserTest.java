package com.guru99.demo;

import com.guru99.demo.pages.HomePage;
import com.guru99.demo.pages.RegisterPage;
import com.guru99.demo.pages.RegisterSuccessPage;
import com.guru99.demo.utitlity.Application;
import com.guru99.demo.utitlity.PropertyFileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterUserTest {

    private PropertyFileHandler fileHandler = new PropertyFileHandler();
    private Application app;
    private HomePage homePage;
    private RegisterPage registerPage;
    private RegisterSuccessPage registerSuccessPage;

    @BeforeMethod
    public void setUp() {
        app = new Application(fileHandler.getProperty("config","browser"));
        homePage = app.navigateToHomePage();
    }

    @Test
    public void testRegisterNewUser() {
        registerPage = homePage.clickOnRegisterMenu();
        registerSuccessPage = registerPage
                .setFirstName("imperial")
                .setLastName("Collage")
                .setPhoneNumber("0112354006")
                .setEmail("info@imparial.lk")
                .selectCountry("SRI LANKA")
                .setUserName("Imperial")
                .setPassword("password")
                .setConfirmPassword("password")
                .clickSubmit();
        Assert.assertEquals(registerSuccessPage.getSalutationMessage()
                ,"Dear imperial Collage,"
                , "Registration failed! Salutation message mismatch!");
    }

    @AfterMethod
    public void tearDown() {
        app.getDriver().quit();
    }
}
