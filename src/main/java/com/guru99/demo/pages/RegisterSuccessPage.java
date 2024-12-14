package com.guru99.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterSuccessPage extends Page{

    public RegisterSuccessPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, RegisterSuccessPage.class);
    }

    @FindBy(xpath = "//*[contains(text(),\"Dear\")]")
    private WebElement salutationMessageWebElement;

    public String getSalutationMessage(){
        salutationMessageWebElement = waitUntilNextElementAppears(By.xpath("//*[contains(text(),\"Dear\")]"),TIMEOUT_10_SECONDS);
        return salutationMessageWebElement.getText();
    }
}
