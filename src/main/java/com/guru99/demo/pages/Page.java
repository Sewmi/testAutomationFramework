package com.guru99.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page {
    public static final int TIMEOUT_10_SECONDS = 10;
    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement waitUntilNextElementAppears(By locator, int timeOut) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeOut))
                .until(ExpectedConditions.presenceOfElementLocated(locator));

    }
}

