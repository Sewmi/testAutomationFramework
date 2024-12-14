package com.guru99.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Page {
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "REGISTER")
    private WebElement registerMenuWebElement;

    public RegisterPage clickOnRegisterMenu() {
        registerMenuWebElement = waitUntilNextElementAppears(By.linkText("REGISTER"), TIMEOUT_10_SECONDS);
        registerMenuWebElement.click();
        return new RegisterPage(driver);
    }
}
