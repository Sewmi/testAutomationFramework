package com.guru99.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends Page  {

    public RegisterPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(name="firstName")
    private WebElement firstNameWebElement;

    @FindBy(name="lastName")
    private WebElement lastNameWebElement;

    @FindBy(name = "phone")
    private WebElement phoneWebElement;

    @FindBy(id="userName")
    private WebElement emailWebElement;

    @FindBy(name="country")
    private WebElement countryWebElement;

    @FindBy(id="email")
    private WebElement usernameWebElement;

    @FindBy(name="password")
    private WebElement passwordWebElement;

    @FindBy(name="confirmPassword")
    private WebElement comfirmPasswordWebElement;

    @FindBy(name="submit")
    private WebElement sumbitButtomWebElement;

    public RegisterPage setFirstName(String firstName){
        firstNameWebElement = waitUntilNextElementAppears(By.name("firstName"),TIMEOUT_10_SECONDS);
        firstNameWebElement.sendKeys(firstName);
        return this;
    }

    public  RegisterPage setLastName(String lastName){
        lastNameWebElement = waitUntilNextElementAppears(By.name("lastName"),TIMEOUT_10_SECONDS);
        lastNameWebElement.sendKeys(lastName);
        return this;
    }

    public  RegisterPage setPhoneNumber(String phoneNumber){
        phoneWebElement = waitUntilNextElementAppears(By.name("phone"),TIMEOUT_10_SECONDS);
        phoneWebElement.sendKeys(phoneNumber);
        return this;
    }

    public  RegisterPage setEmail(String email){
        emailWebElement = waitUntilNextElementAppears(By.id("userName"),TIMEOUT_10_SECONDS);
        emailWebElement.sendKeys(email);
        return this;
    }

    public  RegisterPage selectCountry(String country){
        countryWebElement = waitUntilNextElementAppears(By.name("country"),TIMEOUT_10_SECONDS);
        Select countryDropdown = new Select(countryWebElement);
        countryDropdown.selectByVisibleText(country);
        return this;
    }

    public RegisterPage setUserName(String userName){
        usernameWebElement = waitUntilNextElementAppears(By.id("email"),TIMEOUT_10_SECONDS);
        usernameWebElement.sendKeys(userName);
        return this;
    }

    public RegisterPage setPassword(String password){
        passwordWebElement = waitUntilNextElementAppears(By.name("password"),TIMEOUT_10_SECONDS);
        passwordWebElement.sendKeys(password);
        return this;
    }

    public RegisterPage setConfirmPassword(String password){
        comfirmPasswordWebElement = waitUntilNextElementAppears(By.name("confirmPassword"),TIMEOUT_10_SECONDS);
        comfirmPasswordWebElement.sendKeys(password);
        return this;
    }

    public RegisterSuccessPage clickSubmit(){
        sumbitButtomWebElement = waitUntilNextElementAppears(By.name("submit"),TIMEOUT_10_SECONDS);
        sumbitButtomWebElement.click();
        return new RegisterSuccessPage(driver);
    }
}
