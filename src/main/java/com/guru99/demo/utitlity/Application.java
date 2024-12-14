package com.guru99.demo.utitlity;

import com.guru99.demo.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * The Application class initializes a WebDriver instance based on the specified browser name
 * and provides functionality to navigate to the application's home page.
 *
 * Key Features:
 * - Supports browser initialization for Chrome, Firefox, and Edge.
 * - Defaults to Chrome if an unsupported browser name is provided.
 * - Manages browser window maximization upon initialization.
 * - Reads the application URL from a configuration file via the PropertyFileHandler utility.
 * - Provides access to the WebDriver instance and facilitates navigation to the HomePage.
 *
 * Dependencies:
 * - Selenium WebDriver for browser automation.
 * - PropertyFileHandler for configuration management.
 * - HomePage for representing the application's home page.
 */


public class Application {

    private WebDriver driver;
    PropertyFileHandler propertyFileHandler = new PropertyFileHandler();

    public Application(String browserName) {
        switch (browserName) {
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            case "Edge":
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Requested Driver not available. Chrome is selected as the default browser");
                driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
    }

    public HomePage navigateToHomePage() {
        driver.get(propertyFileHandler.getProperty("config", "url"));
        return new HomePage(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }
}